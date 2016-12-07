package com.anadeainc.exampleplain.secondscreen.rootview.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anadeainc.exampleplain.R;

public abstract class PageFragment<V extends IPageView, P extends IPagePresenter<V>>
        extends Fragment implements IPageView {

    protected P presenter;

    protected TextView infoTextView;
    protected TextView countTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        presenter = createPresenter();
    }

    protected abstract P createPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        infoTextView = (TextView) view.findViewById(R.id.textView);
        countTextView = (TextView) view.findViewById(R.id.textView_attachCount);

        //noinspection unchecked
        presenter.attachView((V) this);
        presenter.getAttachCount();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
        presenter = null;
    }

    @Override
    public void showCount(int count) {
        countTextView.setText(getString(R.string.fragment_attached_prefix));
        countTextView.append(String.valueOf(count));
        countTextView.append(getString(R.string.attached_suffix));
    }

}
