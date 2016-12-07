package com.anadeainc.exampleplain.base;

import com.anadeainc.lightmvp.MvpActivity;
import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

public abstract class SimpleActivity<V extends IView, P extends IPresenter<V>> extends MvpActivity<P> {

    @Override
    protected void onStart() {
        super.onStart();
        //noinspection unchecked
        mvpComponent.attachView((V) this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mvpComponent.detachView();
    }

    @Override
    protected void notifyComponentOnDestroy(boolean isChangingConfigurations) {
        if (!isChangingConfigurations)
            mvpComponent.destroy();
    }

    protected P presenter() {
        return mvpComponent;
    }
}
