package com.uniquedu.mycookbookdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class CookOpenHelper extends SQLiteOpenHelper {
    public CookOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public CookOpenHelper(Context context){
        this(context,"COOK.DB",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建菜谱分类表和菜谱详情表
        db.execSQL("create table cooktype (id integer primary key,name varchar(50))");
        db.execSQL("create table cook (id integer primary key,cook_name varchar(50),cook_original text,cook_doing text,cook_type text,cook_img text)");
        db.execSQL("insert into cooktype (name)values('家常菜')");
        db.execSQL("insert into cooktype (name)values('热菜')");
        db.execSQL("insert into cooktype (name)values('凉菜')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
