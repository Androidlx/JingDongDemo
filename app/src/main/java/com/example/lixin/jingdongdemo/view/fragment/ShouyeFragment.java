package com.example.lixin.jingdongdemo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.view.adapter.MyAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.library.zxing.activity.QRCodeScanFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hua on 2017/9/6.
 */

public class ShouyeFragment extends QRCodeScanFragment {

    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private ImageView saoyisao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shouye, container, false);
        return view;

    }
    private Banner banner;
    String arr[] = {"http://img06.tooopen.com/images/20170321/tooopen_sl_202648839562.jpg",
            "http://img06.tooopen.com/images/20170511/tooopen_sl_209123759718.jpg",
            "http://img06.tooopen.com/images/20170514/tooopen_sl_209849059366.jpg",
            "http://img06.tooopen.com/images/20170514/tooopen_sl_209992249686.jpg",
            "http://img07.tooopen.com/images/20170215/tooopen_sl_198728099565.jpg"};
    private List<String> list;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        banner = getView().findViewById(R.id.banner);
        saoyisao = getView().findViewById(R.id.saoyisao);
        recyclerView = getView().findViewById(R.id.recyclerview);

        gridLayoutManager = new GridLayoutManager(getActivity(),2);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        MyAdapter2 adapter = new MyAdapter2();
        recyclerView.setAdapter(adapter);
        saoyisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScanQRCode();
            }
        });

        list = new ArrayList<>();
        for (String s:arr){
            list.add(s);
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(list);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setDelayTime(2000);
        banner.start();
    }


    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }

    }
}
