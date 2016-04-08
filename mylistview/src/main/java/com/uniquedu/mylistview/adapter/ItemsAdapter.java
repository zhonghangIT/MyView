package com.uniquedu.mylistview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.uniquedu.mylistview.R;
import com.uniquedu.mylistview.bean.ButtonMessage;
import com.uniquedu.mylistview.bean.MyMessage;
import com.uniquedu.mylistview.bean.TextMessage;
import com.uniquedu.mylistview.bean.TimeMessage;

import java.util.List;

/**
 * Created by ZhongHang on 2016/4/8.
 */
public class ItemsAdapter extends BaseAdapter {
    private List<MyMessage> msgs;
    private LayoutInflater mInflater;
    public static final int MESSAGE_TYPE = 0;
    public static final int TIME_TYPE = 1;
    public static final int BUTTON_TYPE = 2;

    @Override
    public int getItemViewType(int position) {
        return msgs.get(position).getType();
    }

    public ItemsAdapter(List<MyMessage> msgs, LayoutInflater mInflater) {
        this.msgs = msgs;
        this.mInflater = mInflater;
    }

    @Override
    public int getViewTypeCount() {
        return 3;//总计item数量
    }

    @Override
    public int getCount() {
        return msgs.size();
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
        ViewHolderText viewHolderText = null;
        ViewHolderButton viewHolderButton = null;
        ViewHolderTime viewHolderTime = null;
        MyMessage msg = msgs.get(position);
        int type = msg.getType();
        if (convertView == null) {
            switch (type) {
                case MESSAGE_TYPE:
                    viewHolderText = new ViewHolderText();
                    convertView = mInflater.inflate(R.layout.item_text, null);
                    viewHolderText.textViewText = (TextView) convertView.findViewById(R.id.textview_text);
                    convertView.setTag(viewHolderText);
                    break;
                case TIME_TYPE:
                    viewHolderTime = new ViewHolderTime();
                    convertView = mInflater.inflate(R.layout.item_time, null);
                    viewHolderTime.textViewTime = (TextView) convertView.findViewById(R.id.textview_time);
                    convertView.setTag(viewHolderTime);
                    break;
                case BUTTON_TYPE:
                    viewHolderButton = new ViewHolderButton();
                    convertView = mInflater.inflate(R.layout.item_button, null);
                    viewHolderButton.button = (Button) convertView.findViewById(R.id.button);
                    convertView.setTag(viewHolderButton);
                    break;
                default:
                    break;
            }
        }

        switch (type) {
            case MESSAGE_TYPE:
                viewHolderText = (ViewHolderText) convertView.getTag();
                TextMessage textMessage = (TextMessage) msg;
                viewHolderText.textViewText.setText(textMessage.getText());
                break;
            case TIME_TYPE:
                viewHolderTime = (ViewHolderTime) convertView.getTag();
                TimeMessage timeMessage = (TimeMessage) msg;
                viewHolderTime.textViewTime.setText(timeMessage.getTime());
                break;
            case BUTTON_TYPE:
                viewHolderButton = (ViewHolderButton) convertView.getTag();
                ButtonMessage buttonMessage = (ButtonMessage) msg;
                viewHolderButton.button.setText(buttonMessage.getContent());
                break;
            default:
                break;
        }

        return convertView;
    }

    class ViewHolderText {
        TextView textViewText;
    }

    class ViewHolderButton {
        Button button;
    }

    class ViewHolderTime {
        TextView textViewTime;
    }
}
