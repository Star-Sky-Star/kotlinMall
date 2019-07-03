package com.android.kotlinmall.data

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-01
 **
 ** Description is 用户实体类
 **/

data class UserInfo(
    val id: String,
    val userIcon: String,
    val userName: String,
    val userGender: String,
    val userMobile: String,
    val userSign: String
)