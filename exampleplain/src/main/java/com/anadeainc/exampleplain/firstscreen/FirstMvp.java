package com.anadeainc.exampleplain.firstscreen;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

interface FirstMvp {

    interface View extends IView {
        void setScreenTitle();

        void setCounter(int count);

        void toSecondActivity();
    }

    interface Presenter extends IPresenter<View> {
        void onButtonClick();
    }
}
