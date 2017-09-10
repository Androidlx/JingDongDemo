package com.example.lixin.jingdongdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.view.adapter.MyPageAdapter_fenlei;

import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * Created by hua on 2017/9/6.
 */

public class FenleiFragment extends Fragment {

    private VerticalTabLayout tabLayout;
    private ViewPager viewPager;
    private MyPageAdapter_fenlei adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fenlei, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = getView().findViewById(R.id.tablayout);
        viewPager = getView().findViewById(R.id.viewpager);
        adapter = new MyPageAdapter_fenlei(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
