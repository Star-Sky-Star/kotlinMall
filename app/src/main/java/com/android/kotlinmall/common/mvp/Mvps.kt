package com.android.mvp

/**
 ** Create by android
 **
 ** Time at 2019-06-19
 **
 ** Description is
 **/


interface IPresenter<out View : IMvpView<IPresenter<View>>> : ILifecycle {
    val view: View
}

interface IMvpView<out Presenter : IPresenter<IMvpView<Presenter>>> : ILifecycle {
    val presenter: Presenter

    fun showLoading()

    fun hideLoading()
}