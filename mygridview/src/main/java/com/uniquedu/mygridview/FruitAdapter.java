package com.uniquedu.mygridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ZhongHang on 2015/10/25.
 */
public class FruitAdapter extends BaseAdapter{
    private List<Fruit> mFruits;
    private LayoutInflater mInflater;

    public FruitAdapter(List<Fruit> mFruits, LayoutInflater mInflater) {
        this.mFruits = mFruits;
        this.mInflater = mInflater;
    }

    @Override

    public int getCount() {
        return mFruits.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if(convertView==null){
            convertView=mInflater.inflate(R.layout.grid_item,null);
            vh=new ViewHolder();
            vh.imageView= (ImageView) convertView.findViewById(R.id.imageview_fruit);
            convertView.setTag(vh);
        }
        vh= (ViewHolder) convertView.getTag();
        vh.imageView.setImageResource(mFruits.get(position).getImg());
        return convertView;
    }
    class  ViewHolder{
        ImageView imageView;
    }
}
