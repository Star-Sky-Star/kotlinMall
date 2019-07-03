package com.android.kotlinmall.repository

import com.android.kotlinmall.ext.convert
import com.android.kotlinmall.service.UploadService
import io.reactivex.Observable

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-02
 **
 ** Description is
 **/


object UploadRepority {


    fun getUploadToken(): Observable<String> {
        return UploadService.getUploadToken().convert()
    }

}