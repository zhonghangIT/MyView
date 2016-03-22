package com.uniquedu.mycookbookdemo.adapter;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquedu.mycookbookdemo.R;
import com.uniquedu.mycookbookdemo.bean.Cook;

import java.util.List;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class CookAdapter extends BaseAdapter {
    private List<Cook>  mAllCooks;
    private LayoutInflater mInflater;

    public CookAdapter(List<Cook> mAllCooks, LayoutInflater mInflater) {
        this.mAllCooks = mAllCooks;
        this.mInflater = mInflater;
    }

    @Override
    public int getCount() {
        return mAllCooks.size();
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
            convertView=mInflater.inflate(R.layout.item_cook,null);
            vh=new ViewHolder();
            vh.imageView= (ImageView) convertView.findViewById(R.id.imageview_cook);
            vh.textViewName= (TextView) convertView.findViewById(R.id.textview_name);
            vh.textViewDetail= (TextView) convertView.findViewById(R.id.textview_detail);
            convertView.setTag(vh);
        }
        vh= (ViewHolder) convertView.getTag();
        //应作判空处理
        vh.imageView.setImageBitmap(BitmapFactory.decodeFile(mAllCooks.get(position).getImgPath()));
        vh.textViewName.setText(mAllCooks.get(position).getName());
        vh.textViewDetail.setText(mAllCooks.get(position).getOriginal());
        return convertView;
    }
    class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewDetail;
    }
}
