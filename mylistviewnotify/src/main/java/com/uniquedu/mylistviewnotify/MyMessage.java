package com.uniquedu.mylistviewnotify;

/**
 * Created by ZhongHang on 2015/10/25.
 */
public class MyMessage {
    private int img;
    private String text;

    public MyMessage(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
