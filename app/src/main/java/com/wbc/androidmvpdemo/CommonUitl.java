package com.wbc.androidmvpdemo;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 13:44 <br>
 * 版本： V1.0<br>
 */
public class CommonUitl {

    /**
     * Show message
     *
     * @param activity Activity
     * @param msg message
     */
    public static void showMessage(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show message
     *
     * @param activity Activity
     * @param msg message
     */
    public static void showSnackMessage(Activity activity, String msg) {
        Snackbar snackbar = Snackbar.make(activity.getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(ContextCompat.getColor(activity, android.R.color.white));
        snackbar.show();
    }

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MvpApp.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
