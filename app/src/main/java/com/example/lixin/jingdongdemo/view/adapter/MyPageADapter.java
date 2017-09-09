package com.example.lixin.jingdongdemo.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by hua on 2017/9/6.
 */

public class MyPageADapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list = new ArrayList<>();
    public MyPageADapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//    }
}
