package com.wbc.androidmvpdemo;

import android.app.Application;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 14:46 <br>
 * 版本： V1.0<br>
 */
public class MvpApp extends Application {

    private static MvpApp instance;

    public static synchronized MvpApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
