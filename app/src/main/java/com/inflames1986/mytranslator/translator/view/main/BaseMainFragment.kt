package com.inflames1986.mytranslator.translator.view.main

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.inflames1986.mytranslator.R
import com.inflames1986.model.data.AppState
import com.inflames1986.model.data.DictionaryResult

abstract class BaseMainFragment<T : com.inflames1986.model.data.AppState, I : IMainInteractor<com.inflames1986.model.data.DictionaryResult>> :
    Fragment(R.layout.fragment_main) {

    protected var isNetworkAvailable: Boolean = false

    //abstract val model: BaseMainViewModel<T>

    //abstract fun renderData(appState: T)

    protected fun noInternetMessageShow() {
        Toast.makeText(requireContext(), getString(R.string.no_internet_message), Toast.LENGTH_LONG)
            .show()
    }

}