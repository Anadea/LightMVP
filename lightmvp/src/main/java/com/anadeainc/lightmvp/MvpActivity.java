package com.anadeainc.lightmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class MvpActivity<T> extends AppCompatActivity {

    protected T mvpComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //noinspection unchecked
        mvpComponent = (getLastCustomNonConfigurationInstance() == null) ?
                createRetainedComponent() : (T) getLastCustomNonConfigurationInstance();
    }

    protected abstract T createRetainedComponent();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        notifyComponentOnDestroy(isChangingConfigurations());

        mvpComponent = null;
    }

    protected abstract void notifyComponentOnDestroy(boolean isChangingConfigurations);

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mvpComponent;
    }

}
