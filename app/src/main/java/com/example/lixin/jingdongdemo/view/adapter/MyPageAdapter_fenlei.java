package com.example.lixin.jingdongdemo.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lixin.jingdongdemo.model.bean.FenleiInfo;
import com.example.lixin.jingdongdemo.view.fragment.MyFragment;
import com.example.lixin.jingdongdemo.view.fragment.MyFragment_fenlei;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hua on 2017/9/10.
 */

public class MyPageAdapter_fenlei extends FragmentPagerAdapter {

    List<FenleiInfo.DatasBean.ClassListBean> list = new ArrayList<>();

    public MyPageAdapter_fenlei(FragmentManager fm, List<FenleiInfo.DatasBean.ClassListBean> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        //new 我对应得fragment
        MyFragment_fenlei myFragment = new MyFragment_fenlei();
        Bundle bundle = new Bundle();
        bundle.putString("id",list.get(position).getGc_id());
        myFragment.setArguments(bundle);
        return myFragment;
    }
    //记得盘空
    @Override
    public int getCount() {
        return list.size();
    }

    //设置tablayout的每个tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getGc_name();
    }
}
