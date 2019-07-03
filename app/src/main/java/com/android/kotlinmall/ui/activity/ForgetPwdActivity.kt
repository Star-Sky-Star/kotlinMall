package com.android.kotlinmall.ui.activity

import android.os.Bundle
import com.android.kotlinmall.R
import com.android.kotlinmall.ext.enable
import com.android.kotlinmall.presenter.ForgetPwdPresenter
import com.android.mvp.impl.BaseActivity
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ForgetPwdActivity : BaseActivity<ForgetPwdPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)

        mNextBtn.enable(mPhoneForget, { isBtnEnable() })
        mNextBtn.enable(mVerifyCodeForget, { isBtnEnable() })

        mNextBtn.onClick {
            presenter.forgetPwd(mPhoneForget.text.toString().trim(), mVerifyCodeForget.text.toString().trim())
        }

    }

    private fun isBtnEnable(): Boolean {
        return mPhoneForget.text.isNullOrEmpty().not() &&
                mVerifyCodeForget.text.isNullOrEmpty().not()
    }

    fun findPwdSuccess() {
        startActivity<ResetPwdActivity>("mobile" to mPhoneForget.text.toString())
    }

    fun findPwdError(errorMessage: String) {
        toast(errorMessage)
    }

}
