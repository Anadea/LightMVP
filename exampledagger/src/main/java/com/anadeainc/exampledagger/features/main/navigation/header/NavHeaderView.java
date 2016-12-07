package com.anadeainc.exampledagger.features.main.navigation.header;

import android.support.annotation.DrawableRes;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.basemvp.BaseMvpView;
import com.anadeainc.exampledagger.common.CompositeActivity;
import com.anadeainc.exampledagger.features.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class NavHeaderView extends BaseMvpView<MainActivity, NavHeaderMvp.View, NavHeaderPresenter>
        implements NavHeaderMvp.View {

    @BindView(R.id.nav_header_imageView)
    ImageView userAvatar;

    @BindView(R.id.nav_header_nameTextView)
    TextView userName;

    @BindView(R.id.nav_header_emailTextView)
    TextView userEmail;

    public NavHeaderView(NavHeaderPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onCreate(MainActivity parent, Observable<CompositeActivity.Action> observable) {
        super.onCreate(parent, observable);
        NavigationView navigationView = ButterKnife.findById(parent, R.id.nav_view);
        ButterKnife.bind(this, navigationView.getHeaderView(0));
    }

    @Override
    public void setUserInfo(@DrawableRes int avatarResId, String name, String email) {
        userAvatar.setImageDrawable(ContextCompat.getDrawable(parent(), avatarResId));
        userName.setText(name);
        userEmail.setText(email);
    }
}
