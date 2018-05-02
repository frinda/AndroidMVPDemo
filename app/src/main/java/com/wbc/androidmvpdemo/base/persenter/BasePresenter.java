package com.wbc.androidmvpdemo.base.persenter;

import com.wbc.androidmvpdemo.base.view.BaseView;


/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 11:43 <br>
 * 版本： V1.0<br>
 */
public class BasePresenter<T extends BaseView> implements AbstractPresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
