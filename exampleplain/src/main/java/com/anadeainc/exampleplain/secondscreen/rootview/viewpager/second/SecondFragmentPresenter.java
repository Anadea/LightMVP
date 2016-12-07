package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.second;

import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.PagePresenter;

class SecondFragmentPresenter extends PagePresenter<MvpContract.SecondView>
        implements MvpContract.SecondPresenter {

    @Override
    public void tabAttached(String tabTitle) {
        mvpView().showTabTitle(tabTitle);
    }
}
