package com.anadeainc.exampledagger.features.login;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.basemvp.BaseRxPresenter;
import com.anadeainc.exampledagger.dagger.qualifiers.AppContext;
import com.anadeainc.exampledagger.dagger.scopes.MvpScope;
import com.anadeainc.exampledagger.remote.FakeService;
import com.anadeainc.exampledagger.remote.RemoteService;
import com.anadeainc.exampledagger.remote.api.FakeApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@MvpScope
class LoginPresenter extends BaseRxPresenter<LoginMvp.View> implements LoginMvp.Presenter {

    private RemoteService<FakeApi> backendService;

    private String title;
    private String error;

    private String fakeToken;

    @Inject
    LoginPresenter(@AppContext Context context, FakeService backendService) {
        this.backendService = backendService;
        title = context.getString(R.string.login_activity);
        error = context.getString(R.string.error_field_empty);
    }

    @Override
    public void attachView(@NonNull LoginMvp.View mvpView) {
        super.attachView(mvpView);

        if (fakeToken != null) {
            mvpView().toMainActivity();
            return;
        }

        mvpView().setTitle(title);
        mvpView().showProgress(isSubscribed());
    }

    @Override
    public void onDoneClick(String login, String password) {
        boolean loginError = login.isEmpty();
        boolean passwordError = password.isEmpty();

        mvpView().setLoginFormErrors(loginError ? error : null, passwordError ? error : null);

        if (!loginError && !passwordError && !isSubscribed())
            composite.add(getSubscriber(login, password));
    }

    private Disposable getSubscriber(@NonNull String login, @NonNull String password) {
        return backendService.getApi().login(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mvpView().showProgress(true))
                .doOnError(throwable -> {
                    composite.clear();
                    if (viewAttached()) {
                        mvpView().showProgress(false);
                        mvpView().showBackendError(throwable.getMessage());
                    }
                })
                .doOnSuccess(fakeResponse -> {
                    fakeToken = fakeResponse;
                    if (viewAttached()) {
                        mvpView().showProgress(false);
                        mvpView().toMainActivity();
                    }
                })
                .subscribe((s, throwable) -> {
                });
    }

    @Override
    public void destroy() {
        super.destroy();
        backendService = null;
    }
}
