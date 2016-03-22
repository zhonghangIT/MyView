package com.uniquedu.mylistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ZhongHang on 2015/10/24.
 */
public class ArrayActivity  extends AppCompatActivity{
    private ListView mListView;
    private String[] fruits={"桃子","芒果","香蕉","梨","猕猴桃","苹果","柠檬","樱桃"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        //使用ArrayAdapter
        mListView= (ListView) findViewById(R.id.listview);
        //adapter适配器是将数据modle以一定的格式设置到listview中
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ArrayActivity.this,android.R.layout.simple_list_item_1,fruits);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"我点击的水果为："+fruits[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
