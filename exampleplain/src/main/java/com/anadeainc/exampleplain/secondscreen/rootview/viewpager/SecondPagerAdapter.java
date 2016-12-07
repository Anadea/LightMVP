package com.anadeainc.exampleplain.secondscreen.rootview.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.first.FirstFragment;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.second.SecondFragment;
import com.anadeainc.exampleplain.secondscreen.rootview.viewpager.third.ThirdFragment;

public class SecondPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 3;
    private static final String TAB_TITLES[] = new String[]{"Tab1", "Tab2", "Tab3"};

    public SecondPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentBuilder.create(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    private static final class FragmentBuilder {

        static Fragment create(int position) {
            switch (position) {
                case 0:
                    return new FirstFragment();
                case 1: {
                    Bundle args = new Bundle();
                    args.putString(SecondFragment.ARG_TAB_TITLE, TAB_TITLES[position]);
                    Fragment fragment = new SecondFragment();
                    fragment.setArguments(args);
                    return fragment;
                }
                case 2: {
                    Bundle args = new Bundle();
                    args.putInt(ThirdFragment.ARG_PAGE_NUM, position + 1);
                    Fragment fragment = new ThirdFragment();
                    fragment.setArguments(args);
                    return fragment;
                }
                default:
                    return null;
            }
        }

    }

}
