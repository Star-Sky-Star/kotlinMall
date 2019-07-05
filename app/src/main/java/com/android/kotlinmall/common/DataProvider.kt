package com.android.kotlinmall.common

import io.reactivex.Observable

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-03
 **
 ** Description is
 **/
interface DataProvider<DataType> {
    fun getData(page:Int) :Observable< ArrayList<DataType>>
}