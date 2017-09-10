package com.example.lixin.jingdongdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lixin.jingdongdemo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hua on 2017/9/6.
 */

public class ShoppingFragment extends Fragment {

    private XRecyclerView xRecyclerView;
    private CheckBox selected_all;
    private MyAdapter4 adapter4;
    private TextView price;
    private int size;
    private Button btn_jiesuan;
    private Set<Map.Entry<Integer, Boolean>> entries;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shopping, container, false);
        return view;

    }
    ArrayList<String> list;
    HashMap<Integer, Boolean> isCheckedHashMap;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xRecyclerView.setLayoutManager(linearLayoutManager);
        adapter4 = new MyAdapter4(list,isCheckedHashMap);
        xRecyclerView.setAdapter(adapter4);

        adapter4.setsubClickListener(new MyAdapter4.SubClickListener() {
            @Override
            public void OntopicClickListener(View v, HashMap<Integer, Boolean> isCheckedHashMap, int position) {
                int coutn2 = 0;
                Set<Map.Entry<Integer, Boolean>> entries = isCheckedHashMap.entrySet();
                //这个for循环就是判断一下接下来要全部选中,还是全部不选中
                for (Map.Entry<Integer, Boolean> entry : entries) {
                    Boolean value = entry.getValue();

                    //如果有没选中的,那就去全部选中 ,如果发现全都选中了那就全部不选中,
                    if (value) {
                        coutn2++;
                    }
                }
                btn_jiesuan.setText("去结算"+"("+coutn2+")");
                price.setText("合计 ： ￥"+coutn2*50+".00");
            }
        });
        adapter4.setOnClickListener(new MyAdapter4.OnClickListener() {
            @Override
            public void OnClickListener(View view, int position) {
                adapter4.remove(position);
                adapter4.notifyDataSetChanged();
            }
        });

    }

    private void initView() {
        xRecyclerView = getView().findViewById(R.id.xrecyclerview);
        price = getView().findViewById(R.id.price);
        btn_jiesuan = getView().findViewById(R.id.jiesuan);
        selected_all = getView().findViewById(R.id.selected_all);
        selected_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            private Set<Map.Entry<Integer, Boolean>> entries;

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int count = 0;
                entries = adapter4.selectedAll();
                for (Map.Entry<Integer, Boolean> entry : entries) {
                    Boolean value = entry.getValue();


                    //如果有没选中的,那就去全部选中 ,如果发现全都选中了那就全部不选中,
                    if (!value) {

                    }else {
                        count++;
                    }
                }
                btn_jiesuan.setText("去结算"+"("+count+")");
                price.setText("合计 ： ￥"+count*50+".00");
            }
        });

    }

    public void initData(){
        isCheckedHashMap = new HashMap<>();
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
        list.add("这是第" + i + "个魅族手机");
        isCheckedHashMap.put(i, false);
    }

    }

}
