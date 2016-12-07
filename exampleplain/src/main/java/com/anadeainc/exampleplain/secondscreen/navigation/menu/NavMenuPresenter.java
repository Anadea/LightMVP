package com.anadeainc.exampleplain.secondscreen.navigation.menu;

import android.support.annotation.NonNull;

import com.anadeainc.exampleplain.R;
import com.anadeainc.lightmvp.Presenter;

public class NavMenuPresenter extends Presenter<NavMenuMvp.View> implements NavMenuMvp.Presenter {

    private String title;

    @Override
    public void attachView(@NonNull NavMenuMvp.View mvpView) {
        super.attachView(mvpView);
        if (title != null)
            mvpView().setTitle(title);
    }

    @Override
    public void onMenuItemClick(int itemId) {

        switch (itemId) {
            case R.id.nav_import: {
                title = "Import";
                break;
            }
            case R.id.nav_gallery: {
                title = "Gallery";
                break;
            }
            case R.id.nav_slideshow: {
                title = "Slideshow";
                break;
            }
            case R.id.nav_tools: {
                title = "Tools";
                break;
            }
            case R.id.nav_share: {
                mvpView().showToast("Share");
                return;
            }
            case R.id.nav_send: {
                mvpView().showToast("Send");
                return;
            }
        }
        mvpView().setTitle(title);
    }

}
