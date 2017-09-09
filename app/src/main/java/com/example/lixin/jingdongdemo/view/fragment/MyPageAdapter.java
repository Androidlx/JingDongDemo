package com.example.lixin.jingdongdemo.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hua on 2017/9/7.
 */

public class MyPageAdapter extends FragmentPagerAdapter{

    private String[] titles = {"推荐", "热点", "北京", "视频", "军事娱乐", "热点", "北京", "视频", "军事娱乐"};


    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //new 我对应得fragment
        MyFragment myFragment = new MyFragment();
        return myFragment;
    }
    //记得盘空
    @Override
    public int getCount() {
        return titles.length;
    }

    //设置tablayout的每个tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
