package com.wbc.androidmvpdemo.bean.mvp;

import java.util.List;

/**
 * <p>描述：</p>
 * 作者： DELL<br>
 * 日期： 2018/5/2 13:57 <br>
 * 版本： V1.0<br>
 */
public class FeedArticleListData {

    private int curPage;
    private List<FeedArticleData> datas;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<FeedArticleData> getDatas() {
        return datas;
    }

    public void setDatas(List<FeedArticleData> datas) {
        this.datas = datas;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
