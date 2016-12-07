package com.anadeainc.exampleplain.firstscreen;

import android.support.annotation.NonNull;

import com.anadeainc.lightmvp.Presenter;

class FirstPresenter extends Presenter<FirstMvp.View> implements FirstMvp.Presenter {

    private int counter;

    @Override
    public void attachView(@NonNull FirstMvp.View mvpView) {
        super.attachView(mvpView);
        mvpView().setScreenTitle();
        mvpView().setCounter(++counter);
    }

    @Override
    public void onButtonClick() {
        mvpView().toSecondActivity();
    }
}
