package com.anadeainc.exampledagger.features.main;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.common.CompositeActivity;
import com.anadeainc.exampledagger.features.main.mainview.MainView;
import com.anadeainc.exampledagger.features.main.navigation.header.NavHeaderView;
import com.anadeainc.exampledagger.features.main.navigation.menu.NavMenuView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends CompositeActivity {

    @Inject
    NavHeaderView navHeaderView;

    @Inject
    NavMenuView navMenuView;

    @Inject
    MainView mainView;

    @BindView(R.id.main_drawerLayout)
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = ButterKnife.findById(this, R.id.main_toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navHeaderView.onCreate(this, observable());
        navMenuView.onCreate(this, observable());
        mainView.onCreate(this, observable());
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }
}
