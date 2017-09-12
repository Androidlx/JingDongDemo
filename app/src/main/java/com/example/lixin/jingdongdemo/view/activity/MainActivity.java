package com.example.lixin.jingdongdemo.view.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.view.fragment.FenleiFragment;
import com.example.lixin.jingdongdemo.view.fragment.FenxiangFragment;
import com.example.lixin.jingdongdemo.view.fragment.GerenFragment;
import com.example.lixin.jingdongdemo.view.fragment.ShoppingFragment;
import com.example.lixin.jingdongdemo.view.fragment.ShouyeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewpager;
    private RadioGroup mRadiogroup;
    private int index = 0;
    private FrameLayout frameLayout;
    private ShouyeFragment shouyeFragment;
    private FenleiFragment fenleiFragment;
    private FenxiangFragment fenhxiangFragment;
    private ShoppingFragment shoppingFragment;
    private GerenFragment gerenFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        shouyeFragment = new ShouyeFragment();
        fenleiFragment = new FenleiFragment();
        fenhxiangFragment = new FenxiangFragment();
        shoppingFragment = new ShoppingFragment();
        gerenFragment = new GerenFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, shouyeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, fenleiFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, fenhxiangFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, shoppingFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, gerenFragment).commit();
        getSupportFragmentManager().beginTransaction().show(shouyeFragment)
                .hide(fenleiFragment).hide(fenhxiangFragment).hide(shoppingFragment)
                .hide(gerenFragment).commit();

        currentFragment=shouyeFragment;

        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

               Fragment changeToFragment=null;
                switch (i){
                    case R.id.btn1:
                        changeToFragment=shouyeFragment;
                        break;
                    case R.id.btn2:
                        changeToFragment=fenleiFragment;
                        break;
                    case R.id.btn3:
                        changeToFragment=fenhxiangFragment;
                        break;
                    case R.id.btn4:
                        changeToFragment=shoppingFragment;
                        break;
                    case R.id.btn5:
                        changeToFragment=gerenFragment;
                        break;

                }

                if(changeToFragment.equals(currentFragment)){
                    return;
                }else {
                    getSupportFragmentManager().beginTransaction().show(changeToFragment)
                            .hide(currentFragment).commit();
                    currentFragment = changeToFragment;
                }
            }
        });

    }
}