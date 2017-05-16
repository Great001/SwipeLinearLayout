package com.example.liaohaicongsx.swipelinearlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by liaohaicongsx on 2017/05/16.
 */
public class LvAdapter extends BaseAdapter {

    private Context context;
    private String [] nums;

    public  LvAdapter(Context context,String [] array){

        this.context = context;
        nums = array;

    }

    @Override
    public int getCount() {
        return nums.length;
    }

    @Override
    public Object getItem(int position) {
        return nums[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_item, null);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (MyViewHolder) convertView.getTag();
        }
        holder.tvMain.setText(nums[position]);
        return convertView;
    }

    class MyViewHolder{
        TextView tvMain;
        TextView tvOption;

        MyViewHolder(View itemView){
            tvMain = (TextView) itemView.findViewById(R.id.tv_main);
            tvOption = (TextView) itemView.findViewById(R.id.tv_options);
        }
    }

}
