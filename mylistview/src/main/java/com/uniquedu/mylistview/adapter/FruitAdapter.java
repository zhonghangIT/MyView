package com.uniquedu.mylistview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquedu.mylistview.R;
import com.uniquedu.mylistview.modle.Fruit;

import java.util.List;

/**
 * Created by ZhongHang on 2015/10/24.
 */
public class FruitAdapter extends BaseAdapter {
    private List<Fruit> mFruits;
    private LayoutInflater mInflater;

    public FruitAdapter(List<Fruit> fruits, LayoutInflater inflater) {
        mFruits = fruits;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        //获取数据的长度
        return mFruits.size();
    }

    @Override
    public Object getItem(int position) {
        //返回该条数据的对象
        return mFruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        //返回该条数据的id
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //返回listview中第position条显示的View
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_fruit, null);
            vh = new ViewHolder();
            vh.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            vh.textViewName = (TextView) convertView.findViewById(R.id.textview_fruit_name);
            vh.textViewWhen = (TextView) convertView.findViewById(R.id.textview_fruit_when);
            vh.textViewMessage = (TextView) convertView.findViewById(R.id.textview_fruit_message);
            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();
        Fruit fruit = mFruits.get(position);
        vh.imageView.setImageResource(fruit.getImg());
        vh.textViewName.setText(fruit.getName());
        vh.textViewWhen.setText(fruit.getWhen());
        vh.textViewMessage.setText(fruit.getMessage());
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewWhen;
        TextView textViewMessage;
    }
}
