package com.android.kotlinmall.ui.activity

import android.os.Bundle
import com.android.kotlinmall.R
import com.android.kotlinmall.data.UserInfo
import com.android.kotlinmall.ext.enable
import com.android.kotlinmall.presenter.LoginPresenter
import com.android.kotlinmall.repository.UserRepority
import com.android.mvp.impl.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_header_bar.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity<LoginPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /**
         * 判断按钮是否可以点击
         */
        mLoginBtn.enable(mPhone, { isEnableBtn() })
        mLoginBtn.enable(mPwd, { isEnableBtn() })

        mLoginHeaderBar.mRightTv.onClick {
            startActivity<RegisterActivity>()
        }

        mLoginBtn.onClick {
            presenter.doLogin(mPhone.text.toString().trim(), mPwd.text.toString().trim(), "")
        }


        mGoForgetPwd.onClick {
            startActivity<ForgetPwdActivity>()
        }
    }


    fun isEnableBtn(): Boolean {
        return mPhone.text.isNullOrEmpty().not() && mPwd.text.isNullOrEmpty().not()
    }

    fun showError(message: String) {
        toast(message)
    }

    fun loginSuccess(userInfo: UserInfo) {
        toast("登录成功")
        UserRepority.currentUser=userInfo
        startActivity<MainActivity>()
    }


}
