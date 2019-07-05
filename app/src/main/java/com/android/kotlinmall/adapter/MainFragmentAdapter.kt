package com.android.kotlinmall.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-04
 **
 ** Description is 首页的Fragment的adapter
 **/

class MainFragmentAdapter(private val fm: FragmentManager, val context: Context, private val fragments: List<Fragment>) :
    FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        fragments.let {
            return it[p0]
        }
    }

    override fun getCount(): Int {
    return    fragments.size
    }

}
