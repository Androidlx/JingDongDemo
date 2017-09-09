package com.example.lixin.jingdongdemo.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lixin.jingdongdemo.view.activity.LoginActivity;
import com.example.lixin.jingdongdemo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * Created by hua on 2017/9/6.
 */

public class GerenFragment extends Fragment{

    private ImageView img_login;
    private TextView username;
    private DisplayImageOptions options;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_geren, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        img_login = getView().findViewById(R.id.btn_login);
        username = getActivity().findViewById(R.id.tv_username);

        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .displayer(new CircleBitmapDisplayer())
                .build();

        img_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sp = getActivity().getSharedPreferences("key", Context.MODE_PRIVATE);
        String name = sp.getString("name", "登录/注册");
        String img = sp.getString("img", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2812194753,3291832671&fm=27&gp=0.jpg");
        ImageLoader.getInstance().displayImage(img,img_login,options);
        username.setText(name);

    }
}
