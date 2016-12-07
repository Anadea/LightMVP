package com.anadeainc.exampledagger.features.main.mainview;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.basemvp.BaseMvpView;
import com.anadeainc.exampledagger.common.CommonUtils;
import com.anadeainc.exampledagger.common.CompositeActivity;
import com.anadeainc.exampledagger.features.main.MainActivity;
import com.anadeainc.exampledagger.features.main.mainview.adapter.DividerItemDecoration;
import com.anadeainc.exampledagger.features.main.mainview.adapter.IViewHolderCallback;
import com.anadeainc.exampledagger.features.main.mainview.adapter.RecyclerViewAdapter;
import com.anadeainc.exampledagger.remote.models.Post;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class MainView extends BaseMvpView<MainActivity, MainMvp.View, MainPresenter>
        implements MainMvp.View, IViewHolderCallback {

    @BindView(R.id.main_floatingActionButton)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.main_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.main_emptyListText)
    TextView emptyListText;

    @BindView(R.id.main_errorText)
    TextView errorText;

    @BindView(R.id.main_tryAgainButton)
    Button tryAgainButton;

    private RecyclerViewAdapter listAdapter;

    public MainView(MainPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onCreate(MainActivity parent, Observable<CompositeActivity.Action> observable) {
        super.onCreate(parent, observable);
        View mainView = ButterKnife.findById(parent, R.id.main_coordinatorLayout);
        ButterKnife.bind(this, mainView);

        floatingActionButton.setOnClickListener(view -> presenter().onFabClick());
        tryAgainButton.setOnClickListener(view -> presenter().onTryAgainClick());

        RecyclerView recyclerView = ButterKnife.findById(mainView, R.id.main_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(parent);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(itemAnimator);

        DividerItemDecoration decoration = new DividerItemDecoration(parent, R.color.colorDivider, R.dimen.dimen_1);
        recyclerView.addItemDecoration(decoration);

        listAdapter = new RecyclerViewAdapter(new WeakReference<>(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onDestroy(boolean isChangingConfigurations) {
        super.onDestroy(isChangingConfigurations);
        listAdapter.updateDataSet(null);
        floatingActionButton.setOnClickListener(null);
    }

    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showBackendError(boolean show, String message) {
        errorText.setVisibility(show ? View.VISIBLE : View.GONE);
        errorText.setText(message);
        tryAgainButton.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void dataSetChanged(List<Post> dataList) {
        listAdapter.updateDataSet(dataList);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyListMessage(boolean show) {
        emptyListText.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showSnakeBar() {
        Snackbar.make(floatingActionButton, "Replace with your own action", Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void showItem(String title, String message) {
        CommonUtils.showDialogCommon(parent().getSupportFragmentManager(), title, message);
    }

    @Override
    public void onViewHolderClick(View view, int position) {
        if (position != RecyclerView.NO_POSITION)
            presenter().onItemClick(position);
    }
}
