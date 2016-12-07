package com.anadeainc.exampledagger.dagger;

import com.anadeainc.exampledagger.dagger.subcomponent.SubComponentBuilder;

import java.util.Map;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SubComponentModule.class})
public interface AppComponent {
    Map<Class<?>, Provider<SubComponentBuilder>> builderProviders();
}
