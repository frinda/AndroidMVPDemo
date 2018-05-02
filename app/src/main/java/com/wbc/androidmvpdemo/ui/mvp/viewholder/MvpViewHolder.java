package com.wbc.androidmvpdemo.ui.mvp.viewholder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.wbc.androidmvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 14:07 <br>
 * 版本： V1.0<br>
 */
public class MvpViewHolder extends BaseViewHolder {

    @BindView(R.id.item_search_pager_group)
    CardView mItemSearchPagerGroup;
    @BindView(R.id.item_search_pager_like_iv)
    ImageView mItemSearchPagerLikeIv;
    @BindView(R.id.item_search_pager_title)
    TextView mItemSearchPagerTitle;
    @BindView(R.id.item_search_pager_author)
    TextView mItemSearchPagerAuthor;
    @BindView(R.id.item_search_pager_tag_green_tv)
    TextView mTagGreenTv;
    @BindView(R.id.item_search_pager_tag_red_tv)
    TextView mTagRedTv;
    @BindView(R.id.item_search_pager_chapterName)
    TextView mItemSearchPagerChapterName;
    @BindView(R.id.item_search_pager_niceDate)
    TextView mItemSearchPagerNiceDate;

    public MvpViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
