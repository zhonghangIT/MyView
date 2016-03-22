package com.uniquedu.mycookbookdemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uniquedu.mycookbookdemo.bean.Cook;
import com.uniquedu.mycookbookdemo.bean.CookType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class CookDbManager {
    private SQLiteDatabase database;
    //查询所有的菜谱分类
    private  CookDbManager(Context context){
        CookOpenHelper helper=new CookOpenHelper(context);
        database=helper.getWritableDatabase();
    }
    private static CookDbManager manager;
    public static synchronized CookDbManager newInstance(Context context){
        if(manager==null){
            manager=new CookDbManager(context);
        }
        return  manager;
    }

    /**
     * 查询所有的菜谱分类
     * @return
     */
    public List<CookType> getCookTypes(){
        List<CookType> types=new ArrayList<>();
        Cursor cursor=database.rawQuery("select * from cooktype",null);
        while(cursor.moveToNext()){
            CookType type=new CookType();
            type.setId(cursor.getString(cursor.getColumnIndex("id")));
            type.setName(cursor.getString(cursor.getColumnIndex("name")));
            types.add(type);
        }
        return types;
    }

    /**
     * 插入新的菜谱
     * @param cook 新加入的菜谱
     */
    public void insertCook(Cook cook){
        //添加新的菜谱create table cook (id integer primary key,cook_name varchar(50),cook_original text,cook_doing text,cook_type text,cook_img text)
        ContentValues values=new ContentValues();
        values.put("cook_name",cook.getName());
        values.put("cook_original",cook.getOriginal());
        values.put("cook_doing",cook.getDoing());
        values.put("cook_type",cook.getType());
        values.put("cook_img",cook.getImgPath());
        database.insert("cook",null,values);
    }

    /**
     * 根据条件查询菜谱
     * @return 查询到的菜谱的列表
     */
    public List<Cook> queryCook(String typeId){
        List<Cook> cooks=new ArrayList<>();
        Cursor cursor=database.rawQuery("select * from cook where cook_type=?",new String[]{typeId});
        while (cursor.moveToNext()){
            Cook cook=new Cook();
            cook.setId(cursor.getString(cursor.getColumnIndex("id")));
            cook.setName(cursor.getString(cursor.getColumnIndex("cook_name")));
            cook.setOriginal(cursor.getString(cursor.getColumnIndex("cook_original")));
            cook.setDoing(cursor.getString(cursor.getColumnIndex("cook_doing")));
            cook.setType(cursor.getString(cursor.getColumnIndex("cook_type")));
            cook.setImgPath(cursor.getString(cursor.getColumnIndex("cook_img")));
            cooks.add(cook);
        }
        return cooks;
    }
    /**
     * 根据条件查询菜谱
     * @return 查询到的菜谱的列表
     */
    public List<Cook> queryCookSearch(String keyword){
        List<Cook> cooks=new ArrayList<>();
        keyword="%"+keyword+"%";
        Cursor cursor=database.rawQuery("select * from cook where cook_name like ?",new String[]{keyword});
        while (cursor.moveToNext()){
            Cook cook=new Cook();
            cook.setId(cursor.getString(cursor.getColumnIndex("id")));
            cook.setName(cursor.getString(cursor.getColumnIndex("cook_name")));
            cook.setOriginal(cursor.getString(cursor.getColumnIndex("cook_original")));
            cook.setDoing(cursor.getString(cursor.getColumnIndex("cook_doing")));
            cook.setType(cursor.getString(cursor.getColumnIndex("cook_type")));
            cook.setImgPath(cursor.getString(cursor.getColumnIndex("cook_img")));
            cooks.add(cook);
        }
        return cooks;
    }
}
