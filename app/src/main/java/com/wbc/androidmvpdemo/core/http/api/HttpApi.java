package com.wbc.androidmvpdemo.core.http.api;


import com.wbc.androidmvpdemo.bean.BaseResponse;
import com.wbc.androidmvpdemo.bean.mvp.FeedArticleListData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 14:34 <br>
 * 版本： V1.0<br>
 */
public interface HttpApi {

    String HOST = "http://www.wanandroid.com/";

    /**
     * 获取feed文章列表
     *
     * @param num 页数
     * @return feed文章列表数据
     */
    @GET("article/list/{num}/json")
    Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(@Path("num") int num);
}
