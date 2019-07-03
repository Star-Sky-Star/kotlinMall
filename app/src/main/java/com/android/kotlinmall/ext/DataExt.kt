package com.android.kotlinmall.ext

import com.android.kotlinmall.common.net.BaseFunc
import com.android.kotlinmall.common.net.BaseResp
import com.android.kotlinmall.common.mvp.BaseFuncBoolean
import io.reactivex.Observable

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-01
 **
 ** Description is
 **/


/*
    扩展数据转换
 */
fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

/*
    扩展Boolean类型数据转换
 */
fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}