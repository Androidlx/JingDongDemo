package com.example.lixin.jingdongdemo.view.fragment;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lixin.jingdongdemo.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.R.attr.data;

/**
 * Created by hua on 2017/9/10.
 */

public class GrideAdapter extends BaseAdapter {
    Context context;
    private final ArrayList<String> list;

    public GrideAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        for (int i = 0; i<6 ; i++){
            list.add("男装");
        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = View.inflate(context,R.layout.item_gride,null);
            TextView tv = view.findViewById(R.id.tv);
            ImageView iv = view.findViewById(R.id.iv);
            tv.setText(list.get(i));
            iv.setImageResource(R.mipmap.ic_launcher);
        }
        return view;
    }
}
