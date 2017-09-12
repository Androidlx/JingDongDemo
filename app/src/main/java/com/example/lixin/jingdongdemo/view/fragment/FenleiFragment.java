package com.example.lixin.jingdongdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.model.bean.FenleiInfo;
import com.example.lixin.jingdongdemo.model.utils.OkhttpUtils;
import com.example.lixin.jingdongdemo.view.adapter.MyPageAdapter_fenlei;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
        initData();

    }


    private void initData() {
        OkhttpUtils.sendOkHttpRequest("http://169.254.60.203/mobile/index.php?act=goods_class", new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String json = response.body().string();
                Gson gson = new Gson();
                FenleiInfo fenleiInfo = gson.fromJson(json, FenleiInfo.class);
                List<FenleiInfo.DatasBean.ClassListBean> list = fenleiInfo.getDatas().getClass_list();
                adapter = new MyPageAdapter_fenlei(getChildFragmentManager(), list);
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

}
