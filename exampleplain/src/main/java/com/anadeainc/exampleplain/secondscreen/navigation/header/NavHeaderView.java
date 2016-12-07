package com.anadeainc.exampleplain.secondscreen.navigation.header;

import android.support.annotation.DrawableRes;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anadeainc.exampleplain.R;
import com.anadeainc.exampleplain.base.BaseMvpView;
import com.anadeainc.exampleplain.secondscreen.SecondActivity;

import java.util.Observable;

public class NavHeaderView extends BaseMvpView<SecondActivity, NavHeaderMvp.View, NavHeaderPresenter>
        implements NavHeaderMvp.View {

    private ImageView avatar;
    private TextView userName;
    private TextView userEmail;

    public NavHeaderView(NavHeaderPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onCreate(SecondActivity parent, Observable observable) {
        super.onCreate(parent, observable);

        NavigationView navigationView = (NavigationView) parent.findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);

        avatar = (ImageView) header.findViewById(R.id.nav_header_imageView);
        userName = (TextView) header.findViewById(R.id.nav_header_nameText);
        userEmail = (TextView) header.findViewById(R.id.nav_header_emailText);
    }

    @Override
    public void setUserInfo(@DrawableRes int avatarResId, String name, String email) {
        avatar.setImageDrawable(ContextCompat.getDrawable(parent(), avatarResId));
        userName.setText(name);
        userEmail.setText(email);
    }
}
