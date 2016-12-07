package com.anadeainc.exampledagger.basemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.anadeainc.exampledagger.ExampleApp;
import com.anadeainc.exampledagger.dagger.subcomponent.SubComponent;
import com.anadeainc.lightmvp.MvpActivity;

public abstract class BaseMvpActivity extends MvpActivity<SubComponent> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //noinspection unchecked
        mvpComponent.injectMembers(this);
    }

    @Override
    protected SubComponent createRetainedComponent() {
        return ExampleApp.getAppComponent(this).builderProviders().get(this.getClass())
                .get().build();
    }

}
