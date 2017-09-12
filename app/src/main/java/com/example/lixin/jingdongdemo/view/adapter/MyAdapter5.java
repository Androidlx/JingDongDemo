package com.example.lixin.jingdongdemo.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lixin.jingdongdemo.R;
import com.example.lixin.jingdongdemo.model.bean.FenleiInfo2;
import com.example.lixin.jingdongdemo.model.bean.FenleiInfo3;
import com.example.lixin.jingdongdemo.model.utils.OkhttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.nostra13.universalimageloader.core.ImageLoader.TAG;

/**
 * Created by hua on 2017/9/10.
 */

public class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.MyViewHolder> {

    Activity context;
    List<FenleiInfo2.DatasBean.ClassListBean> list;

    public MyAdapter5(Activity activity, List<FenleiInfo2.DatasBean.ClassListBean> list) {
        this.context = activity;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item5, parent, false);
        return new MyViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.text_title.setText(list.get(position).getGc_name());
        String gc_id = list.get(position).getGc_id();
        OkhttpUtils.sendOkHttpRequest("http://169.254.60.203/mobile/index.php?act=goods_class&gc_id="+gc_id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json = response.body().string();
                Gson gson = new Gson();
                FenleiInfo3 fenleiInfo3 = gson.fromJson(json, FenleiInfo3.class);
                List<FenleiInfo3.DatasBean.ClassListBean> list3 = fenleiInfo3.getDatas().getClass_list();
                final GrideAdapter adapter = new GrideAdapter(context,list3);
                context.runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       holder.gridView.setAdapter(adapter);
                       Log.e(TAG, "run:******************* "+json );
                   }
               });

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
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
