package com.anadeainc.exampleplain.secondscreen;

import android.support.annotation.NonNull;

import com.anadeainc.exampleplain.base.CompositeCoordinator;
import com.anadeainc.exampleplain.secondscreen.navigation.header.NavHeaderPresenter;
import com.anadeainc.exampleplain.secondscreen.navigation.header.NavHeaderView;
import com.anadeainc.exampleplain.secondscreen.navigation.menu.NavMenuPresenter;
import com.anadeainc.exampleplain.secondscreen.navigation.menu.NavMenuView;
import com.anadeainc.exampleplain.secondscreen.rootview.RootView;
import com.anadeainc.exampleplain.secondscreen.rootview.RootViewPresenter;

class SecondCoordinator extends CompositeCoordinator<SecondActivity> {

    private final NavHeaderPresenter navHeaderPresenter = new NavHeaderPresenter();
    private final NavMenuPresenter navMenuPresenter = new NavMenuPresenter();
    private final RootViewPresenter rootViewPresenter = new RootViewPresenter();

    @Override
    protected void onCreate(@NonNull SecondActivity activity) {
        NavHeaderView navHeaderView = new NavHeaderView(navHeaderPresenter);
        navHeaderView.onCreate(activity, observable());

        NavMenuView navMenuView = new NavMenuView(navMenuPresenter);
        navMenuView.onCreate(activity, observable());

        RootView rootView = new RootView(rootViewPresenter);
        rootView.onCreate(activity, observable());
    }
}
