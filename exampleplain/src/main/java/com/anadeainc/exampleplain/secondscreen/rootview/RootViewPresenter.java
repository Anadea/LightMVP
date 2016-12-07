package com.anadeainc.exampleplain.secondscreen.rootview;

import com.anadeainc.lightmvp.Presenter;

public class RootViewPresenter extends Presenter<RootViewMvp.View> implements RootViewMvp.Presenter {

    @Override
    public void onFabClick() {
        mvpView().showSnakeBar();
    }
}
