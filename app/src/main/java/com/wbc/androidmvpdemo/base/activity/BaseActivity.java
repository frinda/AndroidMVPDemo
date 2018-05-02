package com.wbc.androidmvpdemo.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wbc.androidmvpdemo.CommonUitl;
import com.wbc.androidmvpdemo.base.persenter.AbstractPresenter;
import com.wbc.androidmvpdemo.base.view.BaseView;

/**
 * <p>描述：MVP模式的Base Activity</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 11:40 <br>
 * 版本： V1.0<br>
 */
public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void onDestroy() {
        if(mPresenter!=null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract T getPresenter();

    @Override
    protected void onViewCreated() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        CommonUitl.showSnackMessage(this,errorMsg);
    }

    @Override
    public void showNormal() {
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void showError() {
    }

    @Override
    public void reload() {

    }
}
