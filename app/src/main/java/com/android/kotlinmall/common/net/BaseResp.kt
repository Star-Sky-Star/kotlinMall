package com.android.kotlinmall.common.net

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is
 **/

data class BaseResp<out T>(val status:Int, val message:String, val data:T)