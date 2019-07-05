package com.android.kotlinmall.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.android.kotlinmall.R;

/**
 * * Create by 对方已经拉黑你
 * *
 * * Time at 2019-07-03
 * *
 * * Description is
 **/
public class test extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView=findViewById(R.id.mNavigationMain);

getSupportFragmentManager().beginTransaction();

getFragmentManager().beginTransaction();

new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
    }
}
