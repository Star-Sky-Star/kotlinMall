package com.android.kotlinmall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.kotlinmall.R
import com.android.kotlinmall.data.UserInfo
import com.android.kotlinmall.ext.loadUrl
import com.android.kotlinmall.ext.onClick
import com.android.kotlinmall.ext.otherwise
import com.android.kotlinmall.ext.yes
import com.android.kotlinmall.presenter.OwnPresenter
import com.android.kotlinmall.repository.UserRepority.afterLogin
import com.android.kotlinmall.repository.UserRepority.isLogined
import com.android.kotlinmall.ui.activity.LoginActivity
import com.android.kotlinmall.ui.activity.UserInfoActivity
import com.android.mvp.impl.BaseFragment
import kotlinx.android.synthetic.main.fragment_userinfo.*
import org.jetbrains.anko.support.v4.startActivity

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-03
 **
 ** Description is个人中心
 **/


class UserInfoFragment : BaseFragment<OwnPresenter>(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_userinfo, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        presenter.getUser()

    }


    override fun onStart() {
        super.onStart()
    }

    fun refreshUser(userInfo: UserInfo?) {
        val userIcon = userInfo?.userIcon
        userIcon?.let { mUserIconIv.loadUrl(userIcon) } ?: mUserIconIv.setImageResource(R.drawable.icon_default_user)
        mUserNameTv.text = userInfo?.userName ?: getString(R.string.un_login_text)
    }

    private fun initView() {
        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)
        mWaitPayOrderTv.onClick(this)
        mWaitConfirmOrderTv.onClick(this)
        mCompleteOrderTv.onClick(this)
        mAllOrderTv.onClick(this)
        mAddressTv.onClick(this)
        mShareTv.onClick(this)
        mSettingTv.onClick(this)
    }

    /*
            点击事件
         */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mUserIconIv, R.id.mUserNameTv -> {

                isLogined().yes {
                    startActivity<UserInfoActivity>()
                }.otherwise {
                    startActivity<LoginActivity>()
                }
            }

            R.id.mWaitPayOrderTv -> {
                //  startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_PAY)
            }
            R.id.mWaitConfirmOrderTv -> {
                //  startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_CONFIRM)
            }
            R.id.mCompleteOrderTv -> {
                // startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_COMPLETED)
            }
            R.id.mAllOrderTv -> {
                /*  afterLogin {
                      startActivity<OrderActivity>()
                  }*/
            }

            R.id.mAddressTv -> {
                /*  afterLogin {
                      startActivity<ShipAddressActivity>()
                  }*/
            }
            R.id.mShareTv -> {
                //   toast(R.string.coming_soon_tip)
            }
            R.id.mSettingTv -> {
                // startActivity<SettingActivity>()
            }
        }
    }


    override fun onResume() {
        super.onResume()
        presenter.getUser()
    }

}
