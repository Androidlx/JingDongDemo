package com.example.lixin.jingdongdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lixin.jingdongdemo.R;

/**
 * Created by hua on 2017/9/6.
 */

public class FenxiangFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fenxiang, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = getView().findViewById(R.id.tablayout);
        viewPager = getView().findViewById(R.id.viewpager);
//        viewPager.setOffscreenPageLimit(9);
        viewPager.setAdapter(new MyPageAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        
    }
}
