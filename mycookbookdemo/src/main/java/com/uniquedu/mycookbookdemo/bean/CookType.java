package com.uniquedu.mycookbookdemo.bean;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class CookType {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
