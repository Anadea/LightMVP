package com.anadeainc.exampleplain.base;

import com.anadeainc.lightmvp.MvpActivity;

public abstract class CompositeActivity<D extends CompositeCoordinator> extends MvpActivity<D> {

    @Override
    protected void onStart() {
        super.onStart();
        mvpComponent.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mvpComponent.onStop();
    }

    @Override
    protected void notifyComponentOnDestroy(boolean isChangingConfigurations) {
        mvpComponent.onDestroy(isChangingConfigurations());
    }

    protected D compositeCoordinator() {
        return mvpComponent;
    }
}
