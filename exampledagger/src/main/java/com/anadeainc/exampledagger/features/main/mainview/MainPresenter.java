package com.anadeainc.exampledagger.features.main.mainview;

import android.support.annotation.NonNull;

import com.anadeainc.exampledagger.basemvp.BaseRxPresenter;
import com.anadeainc.exampledagger.remote.PlaceholderService;
import com.anadeainc.exampledagger.remote.RemoteService;
import com.anadeainc.exampledagger.remote.RetrofitError;
import com.anadeainc.exampledagger.remote.api.PlaceholderApi;
import com.anadeainc.exampledagger.remote.models.Post;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BaseRxPresenter<MainMvp.View> implements MainMvp.Presenter {

    private RemoteService<PlaceholderApi> backendService;

    private List<Post> postList = new ArrayList<>();

    private String errorMessage;

    private ViewState viewState = ViewState.IDLE;

    public MainPresenter(PlaceholderService backendService) {
        this.backendService = backendService;
        composite.add(getSubscriber());
    }

    @Override
    public void attachView(@NonNull MainMvp.View mvpView) {
        super.attachView(mvpView);
        updateView();
    }

    private Disposable getSubscriber() {
        return backendService.getApi().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    viewState = ViewState.LOADING;
                    updateView();
                })
                .doOnError(throwable -> {
                    viewState = ViewState.ERROR;
                    errorMessage = RetrofitError.message(throwable);
                })
                .doOnSuccess(posts -> {
                    viewState = ViewState.COMPLETED;
                    postList = posts;
                })
                .subscribe((posts, throwable) -> {
                    composite.clear();
                    updateView();
                });
    }

    private void updateView() {
        if (viewAttached()) {
            mvpView().showProgress(viewState == ViewState.LOADING);
            mvpView().dataSetChanged(postList);
            mvpView().showEmptyListMessage(postList.isEmpty() && viewState == ViewState.COMPLETED);
            mvpView().showBackendError(viewState == ViewState.ERROR, errorMessage);
        }
    }

    @Override
    public void onFabClick() {
        mvpView().showSnakeBar();
    }

    @Override
    public void onTryAgainClick() {
        errorMessage = null;
        composite.add(getSubscriber());
    }

    @Override
    public void onItemClick(int position) {
        Post post = postList.get(position);
        mvpView().showItem(post.getTitle(), post.getBody());
    }

    private enum ViewState {
        IDLE, LOADING, COMPLETED, ERROR
    }
}
