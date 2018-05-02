package com.wbc.androidmvpdemo.base.persenter;

import com.wbc.androidmvpdemo.base.view.BaseView;

/**
 * <p>描述：Presenter 基类</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 11:44 <br>
 * 版本： V1.0<br>
 */
public interface AbstractPresenter<T extends BaseView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();
}
