package com.anadeainc.exampledagger.dagger;

import android.app.Application;
import android.content.Context;

import com.anadeainc.exampledagger.dagger.qualifiers.AppContext;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @AppContext
    Context appContext() {
        return this.application;
    }

}
