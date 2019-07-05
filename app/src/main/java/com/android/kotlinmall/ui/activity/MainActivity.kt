package com.android.kotlinmall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.android.kotlinmall.R
import com.android.kotlinmall.adapter.MainFragmentAdapter
import com.android.kotlinmall.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Fragment 栈管理
    private lateinit var mFragments: List<Fragment>
    //主界面Fragment
    private val mHomeFragment by lazy { HomeFragment() }
    //商品分类Fragment
    private val mCategoryFragment by lazy { CategoryFragment() }
    //购物车Fragment
    private val mCartFragment by lazy { CartFragment() }
    //消息Fragment
    private val mMsgFragment by lazy { MessageFragment() }
    //"我的"Fragment
    private val mUserInfoFragment by lazy { UserInfoFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mFragments = listOf(mHomeFragment, mCategoryFragment, mCartFragment, mMsgFragment, mUserInfoFragment)
        mViewPager.adapter = MainFragmentAdapter(supportFragmentManager, this, mFragments)
        mNavigationMain.itemIconTintList = null
        mNavigationMain.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigationHome -> {
                    mViewPager.currentItem = 0
                }
                R.id.navigationCategories -> {
                    mViewPager.currentItem = 1
                }
                R.id.navigationCart -> {
                    mViewPager.currentItem = 2
                }
                R.id.navigationMessage -> {

                    mViewPager.currentItem = 3
                }
                R.id.navigationOwner -> {
                    mViewPager.currentItem = 4
                }
            }
            true
        }


        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                mNavigationMain.menu.getItem(p0).isChecked = true

            }

        })
    }

}
