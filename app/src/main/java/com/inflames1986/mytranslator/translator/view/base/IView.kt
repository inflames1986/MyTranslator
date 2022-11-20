package com.inflames1986.mytranslator.translator.view.base

import com.inflames1986.mytranslator.translator.domain.model.AppState

interface IView {

    fun renderData(appState: AppState)
}