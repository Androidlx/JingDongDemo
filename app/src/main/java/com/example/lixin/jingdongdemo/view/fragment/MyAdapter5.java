package com.example.lixin.jingdongdemo.view.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lixin.jingdongdemo.R;

/**
 * Created by hua on 2017/9/10.
 */

public class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.MyViewHolder> {

    Context context;
    public MyAdapter5(FragmentActivity activity) {
        this.context = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item5, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text_title.setText("品牌 ");
        GrideAdapter adapter = new GrideAdapter(context);
        holder.gridView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView text_title;
        private final GridView gridView;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            gridView = itemView.findViewById(R.id.gridview);
        }
    }

}
