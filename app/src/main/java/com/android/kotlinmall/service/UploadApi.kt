package com.android.kotlinmall.service

import com.android.baselibrary.common.retrofit
import com.android.kotlinmall.common.net.BaseResp
import io.reactivex.Observable
import retrofit2.http.POST

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-02
 **
 ** Description is
 **/

interface UploadApi {
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}

object UploadService :UploadApi by retrofit.create(UploadApi::class.java)