package com.example.lixin.jingdongdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.lixin.jingdongdemo.R;

/**
 * Created by hua on 2017/9/7.
 */

public class StartActivity extends AppCompatActivity {
    private TextView textView;
    private int count = 5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // 初始化控件对象
        textView = (TextView) findViewById(R.id.textview);
        //textView.startAnimation(animation);
        handler.sendEmptyMessageDelayed(0, 1000);

    }
    private int getCount() {
        count--;
        if (count == 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return count;
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                textView.setText(getCount()+"");
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };

    public void tiaozhuan(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        handler.removeCallbacksAndMessages(null);
    }
}
