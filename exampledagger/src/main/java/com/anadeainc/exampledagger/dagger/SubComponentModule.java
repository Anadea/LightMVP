package com.anadeainc.exampledagger.dagger;

import com.anadeainc.exampledagger.dagger.subcomponent.SubComponentBuilder;
import com.anadeainc.exampledagger.dagger.subcomponent.SubComponentKey;
import com.anadeainc.exampledagger.features.login.LoginActivity;
import com.anadeainc.exampledagger.features.login.LoginComponent;
import com.anadeainc.exampledagger.features.main.MainActivity;
import com.anadeainc.exampledagger.features.main.MainComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        LoginComponent.class,
        MainComponent.class
})
abstract class SubComponentModule {

    @Binds
    @IntoMap
    @SubComponentKey(LoginActivity.class)
    public abstract SubComponentBuilder bindLoginSubComponent(LoginComponent.Builder builder);

    @Binds
    @IntoMap
    @SubComponentKey(MainActivity.class)
    public abstract SubComponentBuilder bindMainSubComponent(MainComponent.Builder builder);
}
