package com.anadeainc.exampleplain.secondscreen.rootview.viewpager.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.anadeainc.exampleplain.R;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.PageFragment;


public class FirstFragment extends PageFragment<MvpContract.FirstView, MvpContract.FirstPresenter>
        implements MvpContract.FirstView {

    @Override
    protected MvpContract.FirstPresenter createPresenter() {
        return new FirstFragmentPresenter();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.fragmentAttached(this.getClass().getSimpleName());
    }

    @Override
    public void showFragmentName(String fragmentName) {
        infoTextView.setText(getString(R.string.fragment_name_prefix));
        infoTextView.append(fragmentName);

    }

}
