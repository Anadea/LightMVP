package com.anadeainc.lightmvp.contract;

public interface IPresenter<T extends IView> {

    void attachView(T mvpView);

    void detachView();

    void destroy();

}
