package com.uniquedu.mylistview.bean;

import com.uniquedu.mylistview.adapter.ItemsAdapter;

/**
 * Created by ZhongHang on 2016/4/8.
 */
public class TextMessage implements MyMessage {
    private String text;

    public TextMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return ItemsAdapter.MESSAGE_TYPE;
    }
}
