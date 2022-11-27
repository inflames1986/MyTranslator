package com.inflames1986.mytranslator.translator.view.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.inflames1986.mytranslator.R
import com.inflames1986.mytranslator.translator.domain.model.AppState
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.viewmodel.BaseViewModel
import com.inflames1986.mytranslator.translator.viewmodel.IInteractor


abstract class BaseActivity<T : AppState, I : IInteractor<DictionaryResult>> :
    AppCompatActivity(R.layout.activity_main) {

    protected var isNetworkAvailable: Boolean = false

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)

    protected fun noInternetMessageShow() {
        Toast.makeText(baseContext, getString(R.string.no_internet_message), Toast.LENGTH_LONG)
            .show()
    }
}