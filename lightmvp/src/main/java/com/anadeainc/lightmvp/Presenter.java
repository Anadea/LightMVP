package com.anadeainc.lightmvp;

import android.support.annotation.NonNull;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

public abstract class Presenter<V extends IView> implements IPresenter<V> {

    private V mvpView;

    @Override
    public void attachView(@NonNull V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    @Override
    public void destroy() {
        // Nothing to clean, override if need
    }

    protected V mvpView() {
        return mvpView;
    }

    protected boolean viewAttached() {
        return mvpView != null;
    }

}
