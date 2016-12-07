package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.anadeainc.exampleplain.R;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.PageFragment;


public class SecondFragment extends PageFragment<MvpContract.SecondView, MvpContract.SecondPresenter>
        implements MvpContract.SecondView {

    public static final String ARG_TAB_TITLE = "ARG_TAB_TITLE";

    private String tabTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabTitle = getArguments().getString(ARG_TAB_TITLE);
    }

    @Override
    protected MvpContract.SecondPresenter createPresenter() {
        return new SecondFragmentPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.tabAttached(tabTitle);
    }

    @Override
    public void showTabTitle(String tabTitle) {
        infoTextView.setText(getString(R.string.tab_title_prefix));
        infoTextView.append(tabTitle);
    }

}
