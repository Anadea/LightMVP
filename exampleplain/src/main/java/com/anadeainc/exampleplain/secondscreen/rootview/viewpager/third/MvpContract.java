package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.third;

import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.IPagePresenter;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.IPageView;

interface MvpContract {

    interface ThirdView extends IPageView {
        void showPageNum(int pageNum);
    }

    interface ThirdPresenter extends IPagePresenter<ThirdView> {
        void pageAttached(int pageNum);
    }
}
