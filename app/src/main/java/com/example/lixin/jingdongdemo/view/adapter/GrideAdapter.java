package com.example.lixin.jingdongdemo.view.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.model.bean.FenleiInfo3;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.R.attr.data;

/**
 * Created by hua on 2017/9/10.
 */

public class GrideAdapter extends BaseAdapter {
    Context context;
    List<FenleiInfo3.DatasBean.ClassListBean> list3;
    public GrideAdapter(Context context, List<FenleiInfo3.DatasBean.ClassListBean> list3) {
        this.context = context;
        this.list3 = list3;
    }

    @Override
    public int getCount() {
        return list3.size();
    }

    @Override
    public Object getItem(int i) {
        return list3.get(i);
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
            tv.setText(list3.get(i).getGc_name());
            iv.setImageResource(R.mipmap.ic_launcher);
        }
        return view;
    }
}
