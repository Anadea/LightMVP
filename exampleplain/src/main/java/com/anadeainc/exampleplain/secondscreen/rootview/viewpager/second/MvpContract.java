package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.second;

import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.IPagePresenter;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.IPageView;

interface MvpContract {

    interface SecondView extends IPageView {
        void showTabTitle(String tabTitle);
    }

    interface SecondPresenter extends IPagePresenter<SecondView> {
        void tabAttached(String tabTitle);
    }
}
