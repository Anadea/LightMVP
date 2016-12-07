package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.first;


import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.IPagePresenter;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.IPageView;

interface MvpContract {

    interface FirstView extends IPageView {
        void showFragmentName(String fragmentName);
    }

    interface FirstPresenter extends IPagePresenter<FirstView> {
        void fragmentAttached(String fragmentName);
    }
}
