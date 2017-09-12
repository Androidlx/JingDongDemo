package com.example.lixin.jingdongdemo.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lixin.jingdongdemo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hua on 2017/9/8.
 */

public class MyAdapter4 extends XRecyclerView.Adapter<MyAdapter4.MyViewHolder>{
    // 用来控制CheckBox的选中状况
    private static HashMap<Integer,Boolean> isSelected;
    private int count;
    ArrayList<String> list;
    HashMap<Integer, Boolean> isCheckedHashMap;
    private Set<Map.Entry<Integer, Boolean>> entries;

    public MyAdapter4(ArrayList<String> list, HashMap<Integer, Boolean> isCheckedHashMap) {
        this.list = list;
        this.isCheckedHashMap = isCheckedHashMap;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item4, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.item4_text1.setText(list.get(position));
        //checkbox点击事件
        holder.item4_cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCheckedHashMap.put(position, !isCheckedHashMap.get(position));
                notifyDataSetChanged();
                //暴露一个接口
                if (subClickListener!=null){
                    subClickListener.OntopicClickListener(view,isCheckedHashMap,position);
                }
            }
        });
        holder.item4_cb1.setChecked(isCheckedHashMap.get(position));
        holder.delete_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener!=null){
                    mOnClickListener.OnClickListener(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends XRecyclerView.ViewHolder{

        private final TextView item4_text1;
        private final CheckBox item4_cb1;
        private final TextView delete_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            item4_text1 = itemView.findViewById(R.id.item4_text1);
            item4_cb1 = itemView.findViewById(R.id.item4_cb1);
            delete_text = itemView.findViewById(R.id.delete_text);
        }
    }
    public void remove(int position) {
        list.remove(position);
        isCheckedHashMap.remove(list.get(position));
        notifyItemRangeRemoved(position, getItemCount());
        if (subClickListener1!=null){
            subClickListener1.OntopicClickListener1(isCheckedHashMap);
        }
    }
    //全选
    public Set<Map.Entry<Integer, Boolean>> selectedAll() {
        entries = isCheckedHashMap.entrySet();
        //如果发现有没有选中的item,我就应该去全部选中,这个变量就应该设置成true,否则就是false
        boolean shouldSelectedAll = false;
        //这个for循环就是判断一下接下来要全部选中,还是全部不选中
        for (Map.Entry<Integer, Boolean> entry : entries) {
            Boolean value = entry.getValue();
            //如果有没选中的,那就去全部选中 ,如果发现全都选中了那就全部不选中,
            if (!value) {
                shouldSelectedAll = true;
                break;
            }
        }
        //如果shouldSelectedAll为true说明需要全部选中,
        // 如果为false说明没有没有选中的,已经是是全部选中的状态,需要全部不选中
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(shouldSelectedAll);
        }
        notifyDataSetChanged();
        return entries;
    }


    private OnClickListener mOnClickListener;
    private SubClickListener subClickListener;
    public void setOnClickListener(OnClickListener onClickListener){
        this.mOnClickListener = onClickListener;
    }

    public void setsubClickListener(SubClickListener topicClickListener) {
        this.subClickListener = topicClickListener;
    }

    public interface OnClickListener{
        void OnClickListener(View view,int position);
    }

    public interface SubClickListener {
        void OntopicClickListener(View v,HashMap<Integer, Boolean> isCheckedHashMap , int position);
    }

    private SubClickListener1 subClickListener1;

    public void setsubClickListener1(SubClickListener1 topicClickListener1) {
        this.subClickListener1 = topicClickListener1;
    }
    public interface SubClickListener1 {
        void OntopicClickListener1(HashMap<Integer, Boolean> isCheckedHashMap);
    }
}
