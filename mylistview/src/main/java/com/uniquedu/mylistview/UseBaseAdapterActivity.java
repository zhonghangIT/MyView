package com.uniquedu.mylistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.uniquedu.mylistview.adapter.FruitAdapter;
import com.uniquedu.mylistview.modle.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhongHang on 2015/10/24.
 */
public class UseBaseAdapterActivity  extends AppCompatActivity{
    private ListView mListView;
    private List<Fruit> mData;
    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mListView= (ListView) findViewById(R.id.listview);
        mData=new ArrayList<>();
        for (int i=0;i<100;i++) {
            mData.add(new Fruit("苹果", "夏天", "多吃苹果有益健康", R.mipmap.apple));
            mData.add(new Fruit("香蕉", "夏天", "多吃香蕉有益健康", R.mipmap.banana));
            mData.add(new Fruit("草莓", "夏天", "多吃草莓有益健康", R.mipmap.berry));
            mData.add(new Fruit("樱桃", "夏天", "多吃樱桃有益健康", R.mipmap.cherry));
            mData.add(new Fruit("柠檬", "夏天", "多吃柠檬有益健康", R.mipmap.kiwi));
            mData.add(new Fruit("芒果", "夏天", "多吃芒果有益健康", R.mipmap.mango));
            mData.add(new Fruit("橘子", "夏天", "多吃橘子有益健康", R.mipmap.orange));
            mData.add(new Fruit("梨", "夏天", "多吃梨益健康", R.mipmap.pear));
        }
        mInflater=getLayoutInflater();
        FruitAdapter adapter=new FruitAdapter(mData,mInflater);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),mData.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
