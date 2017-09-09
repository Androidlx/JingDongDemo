package com.example.lixin.jingdongdemo.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.view.adapter.MyAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by hua on 2017/9/8.
 */

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder>{

    ArrayList<String> list;
    public MyAdapter2(){
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("这是第" + i + "条");
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.img.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item2_iv);
            tv = itemView.findViewById(R.id.item2_tv);
        }
    }
}
