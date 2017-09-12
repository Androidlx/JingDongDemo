package com.example.lixin.jingdongdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.view.adapter.MyAdapter3;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by hua on 2017/9/7.
 */

public  class MyFragment extends Fragment implements XRecyclerView.LoadingListener {

    private XRecyclerView xRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_fragment, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        xRecyclerView = getView().findViewById(R.id.xrecyclerview);
        xRecyclerView.setLoadingListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xRecyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter3 adapter3 = new MyAdapter3();
        xRecyclerView.setAdapter(adapter3);



    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
