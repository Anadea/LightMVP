package com.anadeainc.exampledagger.features.login;

import com.anadeainc.exampledagger.dagger.scopes.MvpScope;
import com.anadeainc.exampledagger.dagger.subcomponent.SubComponent;
import com.anadeainc.exampledagger.dagger.subcomponent.SubComponentBuilder;

import dagger.Module;
import dagger.Subcomponent;

@MvpScope
@Subcomponent(modules = {LoginComponent.LoginModule.class})
public interface LoginComponent extends SubComponent<LoginActivity> {

    @Subcomponent.Builder
    interface Builder extends SubComponentBuilder<LoginComponent> {
    }

    @Module
    class LoginModule {

    }
}
