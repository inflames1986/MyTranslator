package com.inflames1986.mytranslator.translator.view.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.inflames1986.mytranslator.R
import com.inflames1986.mytranslator.translator.domain.model.AppState
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import com.inflames1986.mytranslator.translator.viewmodel.BaseViewModel
import com.inflames1986.mytranslator.translator.viewmodel.IInteractor
import javax.inject.Inject

abstract class BaseActivity<T : AppState, I : IInteractor<T>> :
    AppCompatActivity(R.layout.activity_main),
    HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    protected var isNetworkAvailable: Boolean = false

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    protected fun noInternetMessageShow() {
        Toast.makeText(baseContext, getString(R.string.no_internet_message), Toast.LENGTH_LONG)
            .show()
    }
}