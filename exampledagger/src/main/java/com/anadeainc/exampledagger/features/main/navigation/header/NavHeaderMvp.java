package com.anadeainc.exampledagger.features.main.navigation.header;

import android.support.annotation.DrawableRes;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

interface NavHeaderMvp {

    interface View extends IView {
        void setUserInfo(@DrawableRes int avatarResId, String name, String email);
    }

    interface Presenter extends IPresenter<View> {

    }
}
