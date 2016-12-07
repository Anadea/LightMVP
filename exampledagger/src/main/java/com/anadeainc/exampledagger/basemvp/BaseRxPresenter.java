package com.anadeainc.exampledagger.basemvp;

import com.anadeainc.lightmvp.Presenter;
import com.anadeainc.lightmvp.contract.IView;

import io.reactivex.disposables.CompositeDisposable;

public class BaseRxPresenter<V extends IView> extends Presenter<V> {

    protected CompositeDisposable composite = new CompositeDisposable();

    protected boolean isSubscribed() {
        return composite.size() != 0;
    }

    @Override
    public void destroy() {
        super.destroy();
        if (composite != null)
            composite.dispose();
    }
}
