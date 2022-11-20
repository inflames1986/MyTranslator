package com.inflames1986.mytranslator.translator.presenter

import com.inflames1986.mytranslator.translator.domain.model.AppState
import com.inflames1986.mytranslator.translator.view.base.IView

interface IPresenter<T : AppState, V : IView> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String)
}