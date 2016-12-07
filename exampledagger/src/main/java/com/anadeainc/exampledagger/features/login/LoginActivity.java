package com.anadeainc.exampledagger.features.login;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.common.CommonUtils;
import com.anadeainc.exampledagger.common.SimpleActivity;
import com.anadeainc.exampledagger.features.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends SimpleActivity<LoginMvp.View, LoginPresenter>
        implements LoginMvp.View {

    @BindView(R.id.login_toolbar)
    Toolbar toolbar;

    @BindView(R.id.login_emailInputLayout)
    TextInputLayout loginInputLayout;

    @BindView(R.id.login_emailEditText)
    TextInputEditText login;

    @BindView(R.id.login_passwordInputLayout)
    TextInputLayout passwordInputLayout;

    @BindView(R.id.login_passwordEditText)
    TextInputEditText password;

    @BindView(R.id.login_button)
    Button button;

    @BindView(R.id.login_progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        button.setOnClickListener(view -> presenter()
                .onDoneClick(login.getText().toString(), password.getText().toString()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        button.setOnClickListener(null);
    }

    @Override
    public void setTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void setLoginFormErrors(String loginError, String passwordError) {
        loginInputLayout.setError(loginError);
        passwordInputLayout.setError(passwordError);
    }

    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        button.setEnabled(!show);
        loginInputLayout.setEnabled(!show);
        passwordInputLayout.setEnabled(!show);
    }

    @Override
    public void showBackendError(String message) {
        CommonUtils.showDialogCommon(getSupportFragmentManager(), null, message);
    }

    @Override
    public void toMainActivity() {
        CommonUtils.startActivityClearTask(this, MainActivity.class);
    }
}

