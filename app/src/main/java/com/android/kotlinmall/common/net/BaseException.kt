package com.android.kotlinmall.common.net

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-30
 **
 ** Description is
 **/

data class BaseException(val status: Int, val msg: String) : Throwable()