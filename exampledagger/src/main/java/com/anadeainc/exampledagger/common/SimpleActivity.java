package com.anadeainc.exampledagger.common;

import com.anadeainc.exampledagger.basemvp.BaseMvpActivity;
import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

import javax.inject.Inject;

public abstract class SimpleActivity<V extends IView, P extends IPresenter<V>> extends BaseMvpActivity {

    @Inject
    P presenter;

    protected P presenter() {
        return presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        //noinspection unchecked
        presenter.attachView((V) this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    protected void notifyComponentOnDestroy(boolean isChangingConfigurations) {
        if (!isChangingConfigurations() && presenter != null)
            presenter.destroy();
        presenter = null;
    }

}
