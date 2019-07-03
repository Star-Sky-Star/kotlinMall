package com.android.kotlinmall.repository

import com.android.kotlinmall.data.*
import com.android.kotlinmall.ext.convert
import com.android.kotlinmall.ext.convertBoolean
import com.android.kotlinmall.service.UserService
import com.bennyhuo.github.utils.fromJson
import com.bennyhuo.github.utils.pref
import com.google.gson.Gson
import io.reactivex.Observable

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-06-30
 **
 ** Description is user 的 model  mvp
 **/

object UserRepority {

    var userId by pref("")
    var userName by pref("")
    var userMobile by pref("")
    var userGender by pref("0")
    var userIcon by pref("")

    private var userJson by pref("")

    var currentUser: UserInfo? = null
        get() {
            if (field == null && userJson.isNotEmpty()) {
                field = Gson().fromJson<UserInfo>(userJson)
            }
            return field
        }
        set(value) {
            if (value == null) {
                userJson = ""
            } else {
                userJson = Gson().toJson(value)
            }
            field = value
        }

    /**
     * 注册
     */
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return UserService.register(RegisterReq(mobile, pwd, verifyCode)).convertBoolean()
    }


    /**
     * 登录
     */
    fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return UserService.login(LoginReq(mobile, pwd, pushId)).convert()
    }

    /**
     * 登录
     */
    fun editUser( userName: String, userIcon: String, gender: String, sign: String): Observable<UserInfo> {
        return UserService.editUser(EditUserReq( userName, userIcon, gender, sign)).convert()
    }


    /**
     * 忘记密码
     */
    fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return UserService.forget(ForgetPwdReq(mobile, verifyCode)).convertBoolean()
    }

    /**
     * 重置密码
     */
    fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return UserService.resetPwd(ResetPwdReq(mobile, pwd)).convertBoolean()
    }
}