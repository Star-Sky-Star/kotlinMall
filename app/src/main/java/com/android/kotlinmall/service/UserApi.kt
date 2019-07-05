package com.android.kotlinmall.service

import com.android.baselibrary.common.retrofit
import com.android.kotlinmall.common.net.BaseResp
import com.android.kotlinmall.data.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-28
 **
 ** Description is
 **/


interface UserApi {
    /**
     * 注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    /**
     * d登录
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>

    /**
     * 修改用户信息
     */
    @POST("userCenter/editUser")
    fun editUser(@Body req: EditUserReq): Observable<BaseResp<UserInfo>>

    /**
     * 获取个人信息
     */
    @POST("userCenter/getUserInfo")
    fun getUserInfo(): Observable<BaseResp<UserInfo>>

    /**
     *
     */
    @POST("userCenter/forgetPwd")
    fun forget(@Body req: ForgetPwdReq): Observable<BaseResp<String>>

    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq): Observable<BaseResp<String>>

}

object UserService : UserApi by retrofit.create(UserApi::class.java)


