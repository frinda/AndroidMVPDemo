package com.wbc.androidmvpdemo.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wbc.androidmvpdemo.CommonUitl;
import com.wbc.androidmvpdemo.base.persenter.AbstractPresenter;
import com.wbc.androidmvpdemo.base.view.BaseView;
import com.wbc.androidmvpdemo.presenter.MvpPresenter;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 16:35 <br>
 * 版本： V1.0<br>
 */
public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements BaseView {

    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract T getPresenter();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {
            CommonUitl.showSnackMessage(_mActivity, errorMsg);
        }
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void reload() {

    }
}
