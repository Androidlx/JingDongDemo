package com.example.lixin.jingdongdemo.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lixin.jingdongdemo.R;

import org.w3c.dom.Text;

/**
 * Created by hua on 2017/9/7.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private Button btn_login;
    private String username;
    private String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        btn_login = (Button) findViewById(R.id.btn);
        usernameWrapper.setHint("用户名");
        passwordWrapper.setHint("密码");
        btn_login.setOnClickListener(this);
        username = usernameWrapper.getEditText().getText().toString();
        password = usernameWrapper.getEditText().getText().toString();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn:

                if (username.length()<6) {
                    usernameWrapper.setError("username name must >= 6");
                } else {
                    usernameWrapper.setErrorEnabled(false);
                    passwordWrapper.setErrorEnabled(false);
                }
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                if (TextUtils.isEmpty(username)&&TextUtils.isEmpty(password)){
                    Toast.makeText(this, "空的", Toast.LENGTH_SHORT).show();
                    btn_login.setBackgroundColor(Color.parseColor("#ff0000"));
                }else {
                    btn_login.setBackgroundColor(Color.parseColor("#ffffff"));
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
