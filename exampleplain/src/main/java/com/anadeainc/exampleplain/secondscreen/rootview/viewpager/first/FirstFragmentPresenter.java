package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.first;


import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.PagePresenter;

class FirstFragmentPresenter extends PagePresenter<MvpContract.FirstView>
        implements MvpContract.FirstPresenter {

    @Override
    public void fragmentAttached(String fragmentName) {
        mvpView().showFragmentName(fragmentName);
    }
}
