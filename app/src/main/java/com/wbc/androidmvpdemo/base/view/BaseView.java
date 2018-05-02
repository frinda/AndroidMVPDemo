package com.wbc.androidmvpdemo.base.view;

/**
 * <p>描述：View 基类</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 11:42 <br>
 * 版本： V1.0<br>
 */
public interface BaseView {

    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * showNormal
     */
    void showNormal();

    /**
     * Show error
     */
    void showError();

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Reload
     */
    void reload();
}
