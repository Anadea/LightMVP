package com.anadeainc.exampledagger.features.main.navigation.menu;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.Toast;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.basemvp.BaseMvpView;
import com.anadeainc.exampledagger.common.CommonUtils;
import com.anadeainc.exampledagger.common.CompositeActivity;
import com.anadeainc.exampledagger.features.login.LoginActivity;
import com.anadeainc.exampledagger.features.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class NavMenuView extends BaseMvpView<MainActivity, NavMenuMvp.View, NavMenuPresenter>
        implements NavMenuMvp.View, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.main_drawerLayout)
    DrawerLayout drawer;

    private ActionBar actionBar;

    public NavMenuView(NavMenuPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onCreate(MainActivity parent, Observable<CompositeActivity.Action> observable) {
        super.onCreate(parent, observable);
        ButterKnife.bind(parent);

        actionBar = parent.getSupportActionBar();

        NavigationView navigationView = ButterKnife.findById(parent, R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public void toLoginActivity() {
        CommonUtils.startActivityClearTask(parent(), LoginActivity.class);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        presenter().onMenuItemClick(item.getItemId());
        drawer = ButterKnife.findById(parent(), R.id.main_drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
