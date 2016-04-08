package com.uniquedu.mylistview.bean;

import com.uniquedu.mylistview.adapter.ItemsAdapter;

/**
 * Created by ZhongHang on 2016/4/8.
 */
public class ButtonMessage implements MyMessage {
    private String content;

    public ButtonMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getType() {
        return ItemsAdapter.BUTTON_TYPE;
    }
}
