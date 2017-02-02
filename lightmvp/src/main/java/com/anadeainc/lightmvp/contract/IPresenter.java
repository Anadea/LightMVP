package com.anadeainc.lightmvp.contract;

import android.support.annotation.NonNull;

public interface IPresenter<T extends IView> {

    void attachView(@NonNull T mvpView);

    void detachView();

    void destroy();

}
