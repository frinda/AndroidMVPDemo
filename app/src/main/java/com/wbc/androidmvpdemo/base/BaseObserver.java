package com.wbc.androidmvpdemo.base;

import android.text.TextUtils;

import com.wbc.androidmvpdemo.MvpApp;
import com.wbc.androidmvpdemo.base.view.BaseView;
import com.wbc.androidmvpdemo.core.http.ServerException;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 15:10 <br>
 * 版本： V1.0<br>
 */
public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseObserver(BaseView view){
        this.mView = view;
    }

    protected BaseObserver(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseObserver(BaseView view, boolean isShowError){
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseObserver(BaseView view, String errorMsg, boolean isShowError){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }

        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ServerException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("网络异常");
        } else {
            mView.showErrorMsg("未知错误");
        }
        if (isShowError) {
            mView.showError();
        }
    }

    @Override
    public void onComplete() {

    }
}
