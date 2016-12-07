package com.anadeainc.lightmvp.mvpview;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

public abstract class MvpView<T extends IMvpParent, V extends IView, P extends IPresenter<V>>
        implements IView {

    private P presenter;
    private T parent;

    public MvpView(P presenter) {
        this.presenter = presenter;
    }

    public void onCreate(T parent) {
        this.parent = parent;
    }

    protected void onStart() {
        //noinspection unchecked
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
