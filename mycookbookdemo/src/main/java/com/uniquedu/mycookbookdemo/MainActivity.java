package com.uniquedu.mycookbookdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.uniquedu.mycookbookdemo.adapter.CookTypeAdapter;
import com.uniquedu.mycookbookdemo.bean.Cook;
import com.uniquedu.mycookbookdemo.bean.CookType;
import com.uniquedu.mycookbookdemo.db.CookDbManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //显示菜谱分类的主界面
    //进入分类下的界面
    //搜索菜谱界面
    //添加菜谱的界面

    private ListView mListViewType;
    private ImageView mImageViewSearch;
    private ImageView mImageViewAdd;
    private List<CookType> allType;
    private CookTypeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListViewType= (ListView) findViewById(R.id.listview_cook);
        mImageViewAdd= (ImageView) findViewById(R.id.imageview_add);
        mImageViewAdd.setOnClickListener(this);
        mImageViewSearch= (ImageView) findViewById(R.id.imageview_search);
        mImageViewSearch.setOnClickListener(this);
        //得到所有的菜谱分类数据
        allType=CookDbManager.newInstance(getApplicationContext()).getCookTypes();
        //生成adapter对象
        mAdapter=new CookTypeAdapter(allType,getLayoutInflater());
        //将adapter设置到listview
        mListViewType.setAdapter(mAdapter);
        mListViewType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,CookListActivity.class);
                //到分类的详情中，在intent中封装参数
                intent.putExtra("type_name",allType.get(position).getName());//传递菜谱分类的名称
                intent.putExtra("type_id",allType.get(position).getId());//菜谱分类的id
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageview_add:
                Intent intentAdd=new Intent(MainActivity.this,AddCookActivity.class);
                startActivity(intentAdd);
                break;
            case R.id.imageview_search:
                Intent intentSearch=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intentSearch);
                break;
        }
    }
}
