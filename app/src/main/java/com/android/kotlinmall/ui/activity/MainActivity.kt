package com.android.kotlinmall.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.kotlinmall.R
import com.android.kotlinmall.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        mNavigationMain.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigationHome -> {

                }
                R.id.navigationCategories -> {

                }
                R.id.navigationCart -> {

                }
                R.id.navigationMessage -> {

                }
                R.id.navigationCategories -> {

                }
                else -> {

                }
            }
            true
        }

    }

    private fun initView() {
        val manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContainer, HomeFragment())
        manager.commit()
    }
}
