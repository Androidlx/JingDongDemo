package com.example.lixin.jingdongdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.model.bean.FenleiInfo2;
import com.example.lixin.jingdongdemo.model.bean.FenleiInfo3;
import com.example.lixin.jingdongdemo.model.utils.OkhttpUtils;
import com.example.lixin.jingdongdemo.view.adapter.MyAdapter5;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by hua on 2017/9/10.
 */

public class MyFragment_fenlei extends Fragment {

    private RecyclerView recyclerView;
    private int id;
    private MyAdapter5 myAdapter5;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str = arguments.getString("id");
        id = Integer.valueOf(str).intValue();
        Toast.makeText(getActivity(), "-------"+ id, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_fenlei, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = getView().findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        initData();
    }
    public void initData(){

        OkhttpUtils.sendOkHttpRequest("http://169.254.60.203/mobile/index.php?act=goods_class&gc_id="+id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String json = response.body().string();
                Gson gson = new Gson();
                FenleiInfo2 fenleiInfo2 = gson.fromJson(json, FenleiInfo2.class);
                final List<FenleiInfo2.DatasBean.ClassListBean> list = fenleiInfo2.getDatas().getClass_list();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(getActivity(), "chenggong"+json, Toast.LENGTH_SHORT).show();
                        myAdapter5 = new MyAdapter5(getActivity(),list);
                        recyclerView.setAdapter(myAdapter5);
                        myAdapter5.notifyDataSetChanged();
                    }
                });
            }
        });


    }
}
