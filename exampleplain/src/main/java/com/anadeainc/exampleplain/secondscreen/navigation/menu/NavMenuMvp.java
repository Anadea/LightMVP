package com.anadeainc.exampleplain.secondscreen.navigation.menu;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

interface NavMenuMvp {

    interface View extends IView {
        void setTitle(String title);

        void showToast(String message);
    }

    interface Presenter extends IPresenter<View> {
        void onMenuItemClick(int itemId);
    }
}
