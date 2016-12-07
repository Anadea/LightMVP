package com.anadeainc.exampledagger;

import android.app.Application;
import android.content.Context;

import com.anadeainc.exampledagger.dagger.AppComponent;
import com.anadeainc.exampledagger.dagger.AppModule;
import com.anadeainc.exampledagger.dagger.DaggerAppComponent;

public class ExampleApp extends Application {

    private AppComponent appComponent;

    public static AppComponent getAppComponent(Context context) {
        return ((ExampleApp) context.getApplicationContext()).appComponent();
    }

    private AppComponent appComponent() {

        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }

        return appComponent;
    }

}
