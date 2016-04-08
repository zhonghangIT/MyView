package com.uniquedu.mylistview.bean;

import com.uniquedu.mylistview.adapter.ItemsAdapter;

/**
 * Created by ZhongHang on 2016/4/8.
 */
public class TimeMessage implements MyMessage {
    private String time;

    public TimeMessage(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int getType() {
        return ItemsAdapter.TIME_TYPE;
    }
}
