package com.example.lixin.jingdongdemo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

import cn.pedant.SweetAlert.SweetAlertDialog;

import static cn.pedant.SweetAlert.SweetAlertDialog.*;

/**
 * Created by hua on 2017/9/6.
 */

public class ShouyeFragment extends QRCodeScanFragment {

    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private RadioButton saoyisao;
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private ArrayList<Fragment> list1;
    private int index = 0;

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
        viewPager = getView().findViewById(R.id.viewpager);
        radioGroup = getView().findViewById(R.id.radiogroup);
        list1 = new ArrayList<>();
        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        list1.add(oneFragment);
        list1.add(twoFragment);


        saoyisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要打开扫一扫功能?")
                        .setContentText("这要调用你的相机权限")
                        .setCancelText("不，不打开")
                        .setConfirmText("是的，打开")
                        .showCancelButton(true)
                        .setCancelClickListener(new OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .setConfirmClickListener(new OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                startScanQRCode();
                                sweetAlertDialog.cancel();
                            }
                        })
                        .show();

            }
        });

        this.list = new ArrayList<>();
        for (String s:arr){
            this.list.add(s);
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(this.list);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setDelayTime(2000);
        banner.start();
        // radiogroup的切换监听事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                // 循环遍历radiogroup的数量
                for(int i = 0; i < radioGroup.getChildCount() ;i ++) {
                    // 如果当前radiobutton被选中的话，将对应索引的viewpager设置成当前显示页面
                    RadioButton rb = (RadioButton) radioGroup.getChildAt(i);
                    if(rb.isChecked()) {
                        viewPager.setCurrentItem(i);
                    }
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 拿到当前页面对应的radioButton
                RadioButton radioBtn = (RadioButton) radioGroup.getChildAt(position);
                // 循环遍历4个item，如果viewpager当前的选项卡和radiobutton的次数相同的情况，就设置成被选中
                for(int i = 0; i < list.size(); i++) {
                    if (position == i) {
                        radioBtn.setChecked(true);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list1.get(position);
            }

            @Override
            public int getCount() {
                return list1.size();
            }
        });
        // 拿到RadioGroup的第1个RadioButton，设置第一个默认选中
        RadioButton rb1 = (RadioButton) radioGroup.getChildAt(index);
        rb1.setChecked(true);
        // 设置viewpager默认显示第一页
        viewPager.setCurrentItem(index);
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }

    }
}
