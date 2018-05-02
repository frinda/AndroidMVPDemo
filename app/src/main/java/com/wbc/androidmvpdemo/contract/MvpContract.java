package com.wbc.androidmvpdemo.contract;

import com.wbc.androidmvpdemo.base.persenter.AbstractPresenter;
import com.wbc.androidmvpdemo.base.view.BaseView;
import com.wbc.androidmvpdemo.bean.BaseResponse;
import com.wbc.androidmvpdemo.bean.mvp.FeedArticleListData;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 13:52 <br>
 * 版本： V1.0<br>
 */
public interface MvpContract {

    interface View extends BaseView {
        void showArticleList(BaseResponse<FeedArticleListData> feedArticleListResponse, boolean isRefresh);

        /**
         * Show article list fail
         */
        void showArticleListFail();
    }

    interface Presenter extends AbstractPresenter<View> {
        /**
         * Get feed article list
         */
        void getFeedArticleList();

        /**
         * Auto refresh
         */
        void autoRefresh();

        /**
         * Load more
         */
        void loadMore();

    }
}
