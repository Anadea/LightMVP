package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.third;

import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.PagePresenter;

class ThirdFragmentPresenter extends PagePresenter<MvpContract.ThirdView>
        implements MvpContract.ThirdPresenter {

    @Override
    public void pageAttached(int pageNum) {
        mvpView().showPageNum(pageNum);
    }
}
