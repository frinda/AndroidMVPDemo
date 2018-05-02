package com.wbc.androidmvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 16:29 <br>
 * 版本： V1.0<br>
 */
public class MvpFragmentActivity extends AppCompatActivity {

    FrameLayout containLayout;

    Fragment mMvpFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        containLayout = findViewById(R.id.container);
        mMvpFragment = new MvpFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,mMvpFragment).commitAllowingStateLoss();
    }
}
