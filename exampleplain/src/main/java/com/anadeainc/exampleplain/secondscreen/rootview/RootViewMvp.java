package com.anadeainc.exampleplain.secondscreen.rootview;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

interface RootViewMvp {

    interface View extends IView {
        void showSnakeBar();
    }

    interface Presenter extends IPresenter<View> {
        void onFabClick();
    }
}
