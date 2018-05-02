package com.wbc.androidmvpdemo.ui.mvp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wbc.androidmvpdemo.R;
import com.wbc.androidmvpdemo.bean.mvp.FeedArticleData;
import com.wbc.androidmvpdemo.ui.mvp.viewholder.MvpViewHolder;

import java.util.List;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 14:05 <br>
 * 版本： V1.0<br>
 */
public class ArticleListAdapter extends BaseQuickAdapter<FeedArticleData,MvpViewHolder> {

    private boolean isCollectPage;
    private boolean isSearchPage;

    public ArticleListAdapter(int layoutResId, @Nullable List<FeedArticleData> data) {
        super(layoutResId, data);
    }

    public void isCollectPage() {
        isCollectPage = true;
        notifyDataSetChanged();
    }

    public void isSearchPage() {
        isSearchPage = true;
        notifyDataSetChanged();
    }


    @Override
    protected void convert(MvpViewHolder helper, FeedArticleData article) {
        if (!TextUtils.isEmpty(article.getTitle())) {
            helper.setText(R.id.item_search_pager_title, Html.fromHtml(article.getTitle()));
        }
        if (article.isCollect() || isCollectPage) {
            helper.setImageResource(R.id.item_search_pager_like_iv, R.drawable.icon_like);
        } else {
            helper.setImageResource(R.id.item_search_pager_like_iv, R.drawable.icon_like_article_not_selected);
        }
        if (!TextUtils.isEmpty(article.getAuthor())) {
            helper.setText(R.id.item_search_pager_author, article.getAuthor());
        }
        setTag(helper, article);
        if (!TextUtils.isEmpty(article.getChapterName())) {
            String classifyName = article.getSuperChapterName() + " / " + article.getChapterName();
            if (isCollectPage) {
                helper.setText(R.id.item_search_pager_chapterName, article.getChapterName());
            } else {
                helper.setText(R.id.item_search_pager_chapterName, classifyName);
            }
        }
        if (!TextUtils.isEmpty(article.getNiceDate())) {
            helper.setText(R.id.item_search_pager_niceDate, article.getNiceDate());
        }
        if (isSearchPage) {
            CardView cardView = helper.getView(R.id.item_search_pager_group);
            cardView.setForeground(null);
        }
    }

    private void setTag(MvpViewHolder helper, FeedArticleData article) {
        helper.getView(R.id.item_search_pager_tag_green_tv).setVisibility(View.GONE);
        helper.getView(R.id.item_search_pager_tag_red_tv).setVisibility(View.GONE);
        if (isCollectPage) {
            return;
        }
        if (article.getSuperChapterName().contains("开源项目")) {
            helper.getView(R.id.item_search_pager_tag_red_tv).setVisibility(View.VISIBLE);
            helper.setText(R.id.item_search_pager_tag_red_tv, "项目");
            helper.setTextColor(R.id.item_search_pager_tag_red_tv, ContextCompat.getColor(mContext, R.color.light_deep_red));
            helper.setBackgroundRes(R.id.item_search_pager_tag_red_tv, R.drawable.selector_tag_red_background);
        }

        if (article.getSuperChapterName().contains("导航")) {
            helper.getView(R.id.item_search_pager_tag_red_tv).setVisibility(View.VISIBLE);
            helper.setText(R.id.item_search_pager_tag_red_tv, "导航");
            helper.setTextColor(R.id.item_search_pager_tag_red_tv, ContextCompat.getColor(mContext, R.color.light_deep_red));
            helper.setBackgroundRes(R.id.item_search_pager_tag_red_tv, R.drawable.selector_tag_red_background);
        }

        if (article.getNiceDate().contains("分钟")
                || article.getNiceDate().contains("小时")
                || article.getNiceDate().contains("一天")) {
            helper.getView(R.id.item_search_pager_tag_green_tv).setVisibility(View.VISIBLE);
            helper.setText(R.id.item_search_pager_tag_green_tv, "新");
            helper.setTextColor(R.id.item_search_pager_tag_green_tv, ContextCompat.getColor(mContext, R.color.light_green));
            helper.setBackgroundRes(R.id.item_search_pager_tag_green_tv, R.drawable.shape_tag_green_background);
        }
    }
}
