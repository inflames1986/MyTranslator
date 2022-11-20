package com.inflames1986.mytranslator.translator.view.main

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import com.inflames1986.mytranslator.translator.domain.model.AppState
import com.inflames1986.mytranslator.translator.domain.repository.RepositoryFactory
import com.inflames1986.mytranslator.translator.domain.scheduler.SchedulerFactory
import com.inflames1986.mytranslator.translator.domain.scheduler.Schedulers
import com.inflames1986.mytranslator.translator.presenter.IPresenter
import com.inflames1986.mytranslator.translator.view.base.IView

class MainPresenterImpl<T : AppState, V : IView>(
    private val interactor: MainInteractor = MainInteractor(RepositoryFactory.create()),
    private val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    private val scheduler: Schedulers = SchedulerFactory.create()
) : IPresenter<T, V> {

    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String) {
        compositeDisposable.add(
            interactor.getData(word)
                .subscribeOn(scheduler.background())
                .observeOn(scheduler.main())
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}