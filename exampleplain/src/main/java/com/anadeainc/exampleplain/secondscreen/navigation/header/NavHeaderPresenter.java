package com.anadeainc.exampleplain.secondscreen.navigation.header;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.anadeainc.lightmvp.Presenter;

public class NavHeaderPresenter extends Presenter<NavHeaderMvp.View> implements NavHeaderMvp.Presenter {

    @DrawableRes
    private static final int avatarResId = android.R.drawable.sym_def_app_icon;
    private static final String userName = "John Doe";
    private static final String userEmail = "john@doe.com";

    @Override
    public void attachView(@NonNull NavHeaderMvp.View mvpView) {
        super.attachView(mvpView);
        mvpView().setUserInfo(avatarResId, userName, userEmail);
    }

}
