package com.wbc.androidmvpdemo.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wbc.androidmvpdemo.presenter.MvpPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <p>描述：Common simple Activity</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 11:48 <br>
 * 版本： V1.0<br>
 */
public abstract class AbstractSimpleActivity extends AppCompatActivity {

    private Unbinder unBinder;
    protected AbstractSimpleActivity mActivity;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        mActivity = this;
        onViewCreated();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }

    protected void onViewCreated() {
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();
}
