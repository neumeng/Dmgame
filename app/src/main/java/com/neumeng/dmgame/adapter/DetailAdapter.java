package com.neumeng.dmgame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koo on 2016/11/6.
 */

public class DetailAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public DetailAdapter(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment fragment, String title) {
        if (mFragments == null)
            mFragments = new ArrayList<>();
        if (mTitles == null)
            mTitles = new ArrayList<>();
        mFragments.add(fragment);
        mTitles.add(title);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
