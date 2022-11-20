package com.inflames1986.mytranslator.translator.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inflames1986.mytranslator.R
import com.inflames1986.mytranslator.translator.domain.model.AppState
import com.inflames1986.mytranslator.translator.presenter.IPresenter


abstract class BaseActivity<T : AppState> : AppCompatActivity(R.layout.activity_main), IView {

    protected lateinit var presenter: IPresenter<T, IView>

    protected abstract fun createPresenter(): IPresenter<T, IView>

    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}