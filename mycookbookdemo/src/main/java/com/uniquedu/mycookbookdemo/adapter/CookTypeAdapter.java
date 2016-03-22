package com.uniquedu.mycookbookdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uniquedu.mycookbookdemo.R;
import com.uniquedu.mycookbookdemo.bean.CookType;

import java.util.List;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class CookTypeAdapter extends BaseAdapter{
    private List<CookType> mTypes;
    private LayoutInflater mInflater;

    public CookTypeAdapter(List<CookType> mTypes, LayoutInflater mInflater) {
        this.mTypes = mTypes;
        this.mInflater = mInflater;
    }

    @Override
    public int getCount() {
        return mTypes.size();
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
            convertView=mInflater.inflate(R.layout.item_type,null);
            vh=new ViewHolder();
            vh.textViewName= (TextView) convertView.findViewById(R.id.textview_type_name);
            convertView.setTag(vh);
        }
        vh= (ViewHolder) convertView.getTag();
        vh.textViewName.setText(mTypes.get(position).getName());
        return convertView;
    }
    class ViewHolder{
        TextView textViewName;
    }
}
