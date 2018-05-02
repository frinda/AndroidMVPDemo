package com.wbc.androidmvpdemo.presenter;

import com.wbc.androidmvpdemo.base.BaseObserver;
import com.wbc.androidmvpdemo.base.persenter.BasePresenter;
import com.wbc.androidmvpdemo.bean.BaseResponse;
import com.wbc.androidmvpdemo.bean.mvp.FeedArticleListData;
import com.wbc.androidmvpdemo.contract.MvpContract;
import com.wbc.androidmvpdemo.core.http.HttpManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 13:49 <br>
 * 版本： V1.0<br>
 */
public class MvpPresenter extends BasePresenter<MvpContract.View> implements MvpContract.Presenter {

    private boolean isRefresh = true;
    private int mCurrentPage = 0;

    @Override
    public void autoRefresh() {
        isRefresh = true;
        mCurrentPage = 0;
        getFeedArticleList();
    }

    @Override
    public void loadMore() {
        isRefresh = false;
        mCurrentPage++;
        getFeedArticleList();
    }

    @Override
    public void getFeedArticleList() {
        HttpManager.getInstance().provideApi().getFeedArticleList(mCurrentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<BaseResponse<FeedArticleListData>>() {
                    @Override
                    public boolean test(BaseResponse<FeedArticleListData> feedArticleListDataBaseResponse) throws Exception {
                        return mView != null;
                    }
                }).subscribeWith(new BaseObserver<BaseResponse<FeedArticleListData>>(mView) {
            @Override
            public void onNext(BaseResponse<FeedArticleListData> feedArticleListResponse) {
                if (feedArticleListResponse.getErrorCode() == BaseResponse.SUCCESS) {
                    mView.showArticleList(feedArticleListResponse, isRefresh);
                } else {
                    mView.showArticleListFail();
                }
            }
        });
    }
}
