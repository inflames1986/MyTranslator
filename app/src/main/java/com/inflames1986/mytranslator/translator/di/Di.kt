package com.inflames1986.mytranslator.translator.di

import androidx.room.Room
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inflames1986.domain.BASE_URL
import com.inflames1986.domain.api.YandexApi
import com.inflames1986.mytranslator.BuildConfig
import com.inflames1986.domain.api.YandexApiInterceptor
import com.inflames1986.domain.repository.IRepository
import com.inflames1986.domain.repository.IRepositoryLocal
import com.inflames1986.model.data.DictionaryResult
import com.inflames1986.domain.repository.RepositoryImpl
import com.inflames1986.mytranslator.translator.domain.repository.RepositoryLocalImpl
import com.inflames1986.mytranslator.translator.domain.repository.datasource.CacheDataSourceImpl
import com.inflames1986.domain.repository.datasource.NetworkDataSourceImpl
import com.inflames1986.mytranslator.translator.domain.storage.WordStorage
import com.inflames1986.mytranslator.translator.view.main.MainFragment
import com.inflames1986.screenfavourite.FavouriteInteractor
import com.inflames1986.screenfavourite.FavouriteViewModel
import com.inflames1986.screenhistory.HistoryInteractor
import com.inflames1986.screenhistory.HistoryViewModel
import com.inflames1986.mytranslator.translator.view.main.MainInteractor
import com.inflames1986.mytranslator.translator.view.main.MainViewModel
import com.inflames1986.screenfavourite.FavouriteFragment
import com.inflames1986.screenhistory.HistoryFragment
import com.inflames1986.utils.Di.DiConst
import com.inflames1986.utils.network.NetworkStateObservable
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
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

    private const val PERSISTED = "Persisted"
    private const val IN_MEMORY = "InMemory"

    private const val DATABASE_NAME = "translator_database"

    fun viewModelModule() = module {
        scope<MainFragment> {
            viewModel(qualifier = named(DiConst.MAIN_VIEW_MODEL)) {
                MainViewModel(
                    interactor = get(),
                    networkState = get(),
                )
            }
        }

        scope<HistoryFragment> {
            viewModel(qualifier = named(DiConst.HISTORY_VIEW_MODEL)) {
                HistoryViewModel(interactor = get())
            }
        }

        scope<FavouriteFragment> {
            viewModel(qualifier = named(DiConst.FAVOURITE_VIEW_MODEL)) {
                FavouriteViewModel(interactor = get())
            }
        }
    }

    fun interactorModule() = module {
        factory {
            MainInteractor(
                repositoryLocal = get(),
                repositoryRemote = get()
            )
        }

        factory {
            HistoryInteractor(
                repositoryLocal = get(),
            )
        }

        factory {
            FavouriteInteractor(
                repositoryLocal = get(),
            )
        }
    }

    fun networkModule() = module {
        single { NetworkStateObservable(context = androidContext()) }
    }

    fun repositoryModule() = module {
        single<IRepository<DictionaryResult>> {
            RepositoryImpl(
                dataSource = NetworkDataSourceImpl(
                    yandexApi = get()
                )
            )
        }

        single<IRepositoryLocal> {
            RepositoryLocalImpl(
                dataSource = CacheDataSourceImpl(
                    get(
                        named(PERSISTED)
                    )
                )
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

    fun navigationModule() = module {
        single<Cicerone<Router>> {
            Cicerone.create()
        }

        single<NavigatorHolder> {
            get<Cicerone<Router>>().getNavigatorHolder()
        }

        single<Router> {
            get<Cicerone<Router>>().router
        }
    }

    fun storageModule() = module {
        single<WordStorage>(qualifier = named(PERSISTED)) {
            Room.databaseBuilder(androidContext(), WordStorage::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }

        single<WordStorage>(qualifier = named(IN_MEMORY)) {
            Room.inMemoryDatabaseBuilder(androidContext(), WordStorage::class.java)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}