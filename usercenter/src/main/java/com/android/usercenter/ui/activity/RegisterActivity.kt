package com.android.usercenter.ui.activity

import android.os.Bundle
import com.android.baselibrary.ui.activity.BaseMvpActivity
import com.android.usercenter.R
import com.android.usercenter.presenter.RegisterPrenter
import com.android.usercenter.presenter.view.RegisterView

class RegisterActivity : BaseMvpActivity<RegisterPrenter>(),RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

    }
}
