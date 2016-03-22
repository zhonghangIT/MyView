package com.uniquedu.mycookbookdemo.bean;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class Cook {
    private String id;
    private String name;
    private String imgPath;
    private String original;
    private String doing;
    private String type;

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getDoing() {
        return doing;
    }

    public void setDoing(String doing) {
        this.doing = doing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "菜谱名称"+name+"\n菜谱的食材"+original+"\n菜谱做法"+doing;
    }
}
