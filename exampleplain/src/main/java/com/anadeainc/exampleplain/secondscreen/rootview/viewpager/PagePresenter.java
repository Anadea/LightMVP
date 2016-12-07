package com.anadeainc.exampleplain.secondscreen.rootview.viewpager;

import android.support.annotation.NonNull;

import com.anadeainc.lightmvp.Presenter;

public abstract class PagePresenter<V extends IPageView> extends Presenter<V>
        implements IPagePresenter<V> {

    private int count;

    @Override
    public void attachView(@NonNull V mvpView) {
        super.attachView(mvpView);
        count++;
    }

    @Override
    public void getAttachCount() {
        mvpView().showCount(count);
    }
}
