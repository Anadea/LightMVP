package com.anadeainc.exampleplain.secondscreen.rootview.viewpager;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

public interface IPagePresenter<V extends IView> extends IPresenter<V> {
    void getAttachCount();
}
