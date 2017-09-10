package com.example.lixin.jingdongdemo.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lixin.jingdongdemo.view.fragment.MyFragment;
import com.example.lixin.jingdongdemo.view.fragment.MyFragment_fenlei;

/**
 * Created by hua on 2017/9/10.
 */

public class MyPageAdapter_fenlei extends FragmentPagerAdapter {
    private String[] titles = {"推荐", "热点", "北京", "视频", "军事娱乐", "热点", "北京", "视频", "军事娱乐"};


    public MyPageAdapter_fenlei(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //new 我对应得fragment
        MyFragment_fenlei myFragment = new MyFragment_fenlei();
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
