package com.example.lixin.jingdongdemo.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lixin.jingdongdemo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by hua on 2017/9/6.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text_register;
    private DisplayImageOptions options;
    private SharedPreferences.Editor edit;
    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private Button btn_login;
    private String username;
    private String password;
    private Button login_back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        btn_login = (Button) findViewById(R.id.btn);
        usernameWrapper.setHint("用户名");
        passwordWrapper.setHint("密码");
        btn_login.setOnClickListener(this);
        username = usernameWrapper.getEditText().getText().toString();
        password = usernameWrapper.getEditText().getText().toString();

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .build();

        text_register = (TextView) findViewById(R.id.text_register);
        ImageView qq_login = (ImageView) findViewById(R.id.qq_login);
        ImageView wechat_login = (ImageView) findViewById(R.id.wechat_login);
        ImageView login_back = (ImageView) findViewById(R.id.login_back);
        login_back.setOnClickListener(this);
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
            case R.id.btn:
                if (username.length()<6) {
                    usernameWrapper.setError("username name must >= 6");
                } else {
                    usernameWrapper.setErrorEnabled(false);
                    passwordWrapper.setErrorEnabled(false);
                }
            case R.id.login_back:
                LoginActivity.this.finish();
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
