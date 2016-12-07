package com.anadeainc.exampleplain.secondscreen.rootview;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.anadeainc.exampleplain.R;
import com.anadeainc.exampleplain.base.BaseMvpView;
import com.anadeainc.exampleplain.secondscreen.SecondActivity;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.SecondPagerAdapter;

import java.util.Observable;

public class RootView extends BaseMvpView<SecondActivity, RootViewMvp.View, RootViewPresenter>
        implements RootViewMvp.View {

    private FloatingActionButton fab;

    public RootView(RootViewPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onCreate(SecondActivity parent, Observable observable) {
        super.onCreate(parent, observable);

        ViewPager viewPager = (ViewPager) parent.findViewById(R.id.viewPager);
        viewPager.setAdapter(new SecondPagerAdapter(parent.getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) parent.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        fab = (FloatingActionButton) parent.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter().onFabClick();
            }
        });
    }

    @Override
    public void showSnakeBar() {
        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy(boolean isChangingConfigurations) {
        super.onDestroy(isChangingConfigurations);

        fab.setOnClickListener(null);
    }
}
