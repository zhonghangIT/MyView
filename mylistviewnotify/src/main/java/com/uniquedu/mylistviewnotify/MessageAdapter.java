package com.uniquedu.mylistviewnotify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ZhongHang on 2015/10/25.
 */
public class MessageAdapter extends BaseAdapter{
    private List<MyMessage> myMessages;
    private LayoutInflater inflater;

    public MessageAdapter(List<MyMessage> myMessages, LayoutInflater inflater) {
        this.myMessages = myMessages;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return myMessages.size();
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
            convertView=inflater.inflate(R.layout.item_message,null);
            vh=new ViewHolder();
            vh.text= (TextView) convertView.findViewById(R.id.textview_message);
            convertView.setTag(vh);
        }
        vh= (ViewHolder) convertView.getTag();
        vh.text.setText(myMessages.get(position).getText());
        return convertView;
    }
    class ViewHolder{
        TextView text;
    }
}
