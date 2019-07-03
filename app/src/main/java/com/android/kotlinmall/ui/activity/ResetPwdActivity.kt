package com.android.kotlinmall.ui.activity

import android.os.Bundle
import com.android.kotlinmall.R
import com.android.kotlinmall.common.net.BaseException
import com.android.kotlinmall.ext.enable
import com.android.kotlinmall.presenter.ResetPwdPresenter
import com.android.mvp.impl.BaseActivity
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ResetPwdActivity : BaseActivity<ResetPwdPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)

        mResetBtn.enable(mPwd, { isBtnEnable() })
        mResetBtn.enable(mPwdSure, { isBtnEnable() })

        mResetBtn.onClick {
            if (mPwd.text.toString() != mPwdSure.text.toString()) {
                toast(getString(R.string.pwdNotEquals))
                return@onClick
            }
            presenter.resetPwd(intent.getStringExtra("mobile"), mPwd.text.toString().trim())
        }

    }

    /*
       判断按钮是否可用
    */
    private fun isBtnEnable(): Boolean {
        return mPwd.text.isNullOrEmpty().not() &&
                mPwdSure.text.isNullOrEmpty().not()

    }


    fun resetSuccess() {
        toast(getString(R.string.resetPwdSuccess))
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())
    }

    fun resetpwdError(e: BaseException) {
        toast(e.msg)
    }
}
