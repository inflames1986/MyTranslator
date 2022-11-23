package com.inflames1986.mytranslator.translator.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inflames1986.mytranslator.BuildConfig
import com.inflames1986.mytranslator.translator.domain.api.YandexApi
import com.inflames1986.mytranslator.translator.domain.api.YandexApiInterceptor
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.IRepository
import com.inflames1986.mytranslator.translator.domain.repository.RepositoryImpl
import com.inflames1986.mytranslator.translator.domain.repository.datasource.CacheDataSourceImpl
import com.inflames1986.mytranslator.translator.domain.repository.datasource.NetworkDataSourceImpl
import com.inflames1986.mytranslator.translator.utils.BASE_URL
import com.inflames1986.mytranslator.translator.view.main.MainInteractor
import com.inflames1986.mytranslator.translator.view.main.MainViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Di {
    private const val LOCAL = "LOCAL"
    private const val REMOTE = "REMOTE"

    fun viewModelModule() = module {
        viewModel {
            MainViewModel(
                interactor = get(),
                networkState = get(),
                state = get()
            )
        }
    }

    fun interactorModule() = module {
        factory {
            MainInteractor(
                repositoryLocal = get(named(LOCAL)),
                repositoryRemote = get(named(REMOTE))
            )
        }
    }

    fun networkModule() = module {
        single { NetworkStateObservable(context = androidContext()) }
    }

    fun repositoryModule() = module {
        single<IRepository<DictionaryResult>>(qualifier = named(REMOTE)) {
            RepositoryImpl(
                dataSource = NetworkDataSourceImpl(
                    yandexApi = get()
                )
            )
        }

        single<IRepository<DictionaryResult>>(qualifier = named(LOCAL)) {
            RepositoryImpl(
                dataSource = CacheDataSourceImpl()
            )
        }
    }

    fun yandexApiModule() = module {
        single<Interceptor> {
            YandexApiInterceptor()
        }

        single<Gson> {
            GsonBuilder()
                .create()
        }

        single<YandexApi> {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(interceptor = get())
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = if (BuildConfig.DEBUG) {
                                HttpLoggingInterceptor.Level.BODY
                            } else {
                                HttpLoggingInterceptor.Level.NONE
                            }
                        })
                        .build()
                )
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
                .create(YandexApi::class.java)
        }
    }
}