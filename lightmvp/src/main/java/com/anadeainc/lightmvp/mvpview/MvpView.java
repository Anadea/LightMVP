package com.anadeainc.lightmvp.mvpview;

import android.support.annotation.NonNull;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

public abstract class MvpView<T extends IMvpParent, V extends IView, P extends IPresenter<V>>
        implements IView {

    private P presenter;
    private T parent;

    public MvpView(@NonNull P presenter) {
        this.presenter = presenter;
    }

    public void onCreate(@NonNull T parent) {
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    protected void onStart() {
        presenter.attachView((V) this);
    }

    protected void onStop() {
        presenter.detachView();
    }

    public void onDestroy(boolean isChangingConfigurations) {
        if (!isChangingConfigurations)
            presenter.destroy();
        presenter = null;
        parent = null;
    }

    protected P presenter() {
        return presenter;
    }

    protected T parent() {
        return parent;
    }
}
