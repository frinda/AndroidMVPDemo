package com.wbc.androidmvpdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wbc.androidmvpdemo.base.fragment.AbstractRootFragment;
import com.wbc.androidmvpdemo.base.fragment.BaseFragment;
import com.wbc.androidmvpdemo.bean.BaseResponse;
import com.wbc.androidmvpdemo.bean.mvp.FeedArticleData;
import com.wbc.androidmvpdemo.bean.mvp.FeedArticleListData;
import com.wbc.androidmvpdemo.contract.MvpContract;
import com.wbc.androidmvpdemo.presenter.MvpPresenter;
import com.wbc.androidmvpdemo.ui.mvp.adapter.ArticleListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 16:34 <br>
 * 版本： V1.0<br>
 */
public class MvpFragment extends AbstractRootFragment<MvpPresenter> implements MvpContract.View {

    @BindView(R.id.normal_view)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mRecyclerView;

    private List<FeedArticleData> mFeedArticleDataList;
    private ArticleListAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mvp;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        mFeedArticleDataList = new ArrayList<>();
        mAdapter = new ArticleListAdapter(R.layout.item_search_pager, mFeedArticleDataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        mRecyclerView.setAdapter(mAdapter);

        setRefresh();
        mPresenter.autoRefresh();
        if (CommonUitl.isNetworkConnected()) {
            showLoading();
        }
    }

    @Override
    public void showArticleList(BaseResponse<FeedArticleListData> feedArticleListResponse, boolean isRefresh) {
        if (feedArticleListResponse == null || feedArticleListResponse.getData() == null
                || feedArticleListResponse.getData().getDatas() == null) {
            showArticleListFail();
            return;
        }
        if (mAdapter == null) {
            return;
        }
        if (isRefresh) {
            mFeedArticleDataList = feedArticleListResponse.getData().getDatas();
            mAdapter.replaceData(feedArticleListResponse.getData().getDatas());
        } else {
            mFeedArticleDataList.addAll(feedArticleListResponse.getData().getDatas());
            mAdapter.addData(feedArticleListResponse.getData().getDatas());
        }
        showNormal();
    }

    @Override
    public void showArticleListFail() {
        CommonUitl.showSnackMessage(_mActivity, "获取文章列表数据");
    }

    private void setRefresh() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.autoRefresh();
                refreshLayout.finishRefresh(1000);
            }

        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mPresenter.loadMore();
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected MvpPresenter getPresenter() {
        return new MvpPresenter();
    }
}
