package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.third;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.anadeainc.exampleplain.R;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.PageFragment;

public class ThirdFragment extends PageFragment<MvpContract.ThirdView, MvpContract.ThirdPresenter>
        implements MvpContract.ThirdView {

    public static final String ARG_PAGE_NUM = "ARG_PAGE_NUM";

    private int pageNum;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNum = getArguments().getInt(ARG_PAGE_NUM);
    }

    @Override
    protected MvpContract.ThirdPresenter createPresenter() {
        return new ThirdFragmentPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.pageAttached(pageNum);
    }

    @Override
    public void showPageNum(int tabNum) {
        infoTextView.setText(getString(R.string.page_num_prefix));
        infoTextView.append(String.valueOf(tabNum));
    }

}
