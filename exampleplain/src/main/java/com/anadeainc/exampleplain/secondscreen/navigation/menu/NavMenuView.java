package com.anadeainc.exampleplain.secondscreen.navigation.menu;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.Toast;

import com.anadeainc.exampleplain.R;
import com.anadeainc.exampleplain.base.BaseMvpView;
import com.anadeainc.exampleplain.secondscreen.SecondActivity;

import java.util.Observable;

public class NavMenuView extends BaseMvpView<SecondActivity, NavMenuMvp.View, NavMenuPresenter>
        implements NavMenuMvp.View, NavigationView.OnNavigationItemSelectedListener {

    private ActionBar actionBar;

    public NavMenuView(NavMenuPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onCreate(SecondActivity parent, Observable observable) {
        super.onCreate(parent, observable);

        actionBar = parent.getSupportActionBar();

        NavigationView navigationView = (NavigationView) parent.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        presenter().onMenuItemClick(item.getItemId());

        DrawerLayout drawer = (DrawerLayout) parent().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setTitle(String title) {
        if (actionBar != null)
            actionBar.setTitle(title);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(parent(), message, Toast.LENGTH_SHORT).show();
    }

}
