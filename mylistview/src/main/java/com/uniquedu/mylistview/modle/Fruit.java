package com.uniquedu.mylistview.modle;

/**
 * Created by ZhongHang on 2015/10/24.
 */
public class Fruit {
    private String name;
    private String when;
    private String message;
    private int img;

    public Fruit(String name, String when, String message, int img) {
        this.name = name;
        this.when = when;
        this.message = message;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
