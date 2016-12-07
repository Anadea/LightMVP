package com.anadeainc.exampledagger.features.login;

import com.anadeainc.lightmvp.contract.IPresenter;
import com.anadeainc.lightmvp.contract.IView;

interface LoginMvp {

    interface View extends IView {
        void setTitle(String title);

        void setLoginFormErrors(String loginError, String passwordError);

        void showProgress(boolean show);

        void showBackendError(String message);

        void toMainActivity();
    }

    interface Presenter extends IPresenter<View> {
        void onDoneClick(String login, String password);
    }
}
