package com.toocms.www.testframeforwzw.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList();
    private String[] titles;

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList.clear();
        this.fragmentList.addAll(fragmentList);
    }

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] titles) {
        super(fm);
        this.fragmentList.clear();
        this.fragmentList.addAll(fragmentList);
        this.titles = titles;
    }

    public CharSequence getPageTitle(int position) {
        return (CharSequence)(this.titles != null && this.titles.length > position ? this.titles[position] : super.getPageTitle(position));
    }

    public Fragment getItem(int position) {
        return (Fragment)this.fragmentList.get(position);
    }

    public int getCount() {
        return this.fragmentList.size();
    }
}
