package com.wbc.androidmvpdemo;

import java.io.File;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 14:45 <br>
 * 版本： V1.0<br>
 */
public class Constants {

    /**
     * Path
     */
    public static final String PATH_DATA = MvpApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

}
