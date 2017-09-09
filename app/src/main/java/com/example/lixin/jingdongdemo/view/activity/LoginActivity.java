package com.example.lixin.jingdongdemo.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lixin.jingdongdemo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by hua on 2017/9/6.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text_register;
    private DisplayImageOptions options;
    private SharedPreferences.Editor edit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .build();

        text_register = (TextView) findViewById(R.id.text_register);
        ImageView qq_login = (ImageView) findViewById(R.id.qq_login);
        ImageView wechat_login = (ImageView) findViewById(R.id.wechat_login);
        wechat_login.setOnClickListener(this);
        qq_login.setOnClickListener(this);
        text_register.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("key",MODE_PRIVATE);
        edit = sp.edit();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.text_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.qq_login:
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.wechat_login:

                break;
        }

    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            String name = data.get("name");
            String gender = data.get("gender");
            String iconurl = data.get("iconurl");
            edit.putString("img",iconurl);
            edit.putString("name",name);
            edit.commit();
            finish();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }




}
