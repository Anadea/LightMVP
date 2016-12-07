package com.anadeainc.exampledagger.features.main;

import com.anadeainc.exampledagger.dagger.scopes.MvpScope;
import com.anadeainc.exampledagger.dagger.subcomponent.SubComponent;
import com.anadeainc.exampledagger.dagger.subcomponent.SubComponentBuilder;
import com.anadeainc.exampledagger.features.main.mainview.MainPresenter;
import com.anadeainc.exampledagger.features.main.mainview.MainView;
import com.anadeainc.exampledagger.features.main.navigation.header.NavHeaderPresenter;
import com.anadeainc.exampledagger.features.main.navigation.header.NavHeaderView;
import com.anadeainc.exampledagger.features.main.navigation.menu.NavMenuPresenter;
import com.anadeainc.exampledagger.features.main.navigation.menu.NavMenuView;
import com.anadeainc.exampledagger.remote.PlaceholderService;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

@MvpScope
@Subcomponent(modules = {MainComponent.MainModule.class})
public interface MainComponent extends SubComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder extends SubComponentBuilder<MainComponent> {
    }

    @Module
    class MainModule {

        @MvpScope
        @Provides
        NavHeaderPresenter navHeaderPresenter() {
            return new NavHeaderPresenter();
        }

        @MvpScope
        @Provides
        NavMenuPresenter navMenuPresenter() {
            return new NavMenuPresenter();
        }

        @MvpScope
        @Provides
        MainPresenter mainPresenter(PlaceholderService placeholderService) {
            return new MainPresenter(placeholderService);
        }

        @Provides
        NavHeaderView navHeaderView(NavHeaderPresenter presenter) {
            return new NavHeaderView(presenter);
        }

        @Provides
        NavMenuView navMenuView(NavMenuPresenter presenter) {
            return new NavMenuView(presenter);
        }

        @Provides
        MainView mainView(MainPresenter presenter) {
            return new MainView(presenter);
        }
    }
}
