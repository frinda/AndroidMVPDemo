package com.wbc.androidmvpdemo.core.http;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 15:14 <br>
 * 版本： V1.0<br>
 */
public class ServerException extends Exception {

    private int code;

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
