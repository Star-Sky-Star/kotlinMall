package com.android.baselibrary.presenter.view

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-27
 **
 ** Description is
 **/

interface BaseView {
    //显示加载框
    fun showLoading()

    fun hideLoading()

    fun onError()
}