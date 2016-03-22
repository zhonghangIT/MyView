package com.uniquedu.mylistview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZhongHang on 2015/10/24.
 */
public class SimpleActivity extends AppCompatActivity {
    private ListView mListView;
    private List<HashMap<String, String>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        mListView = (ListView) findViewById(R.id.listview);
        mData = new ArrayList<>();
        HashMap<String, String> apple = createFruit("苹果", "秋天");
        mData.add(apple);
        HashMap<String, String> pear = createFruit("梨", "夏天");
        mData.add(pear);
        HashMap<String, String> orange = createFruit("橘子", "秋天");
        mData.add(orange);
        HashMap<String, String> banana = createFruit("香蕉", "春天");
        mData.add(banana);


        SimpleAdapter simpleAdapter = new SimpleAdapter(SimpleActivity.this, mData, R.layout.item_simple, new String[]{"name","when"}, new int[]{R.id.textview_fruit_name,R.id.textview_fruit_when});
//        Context context adapter依赖的Context
//        List<? extends Map<String, ?>> data  数据必须是List 每一条数据必须是Map
//        int resource   listview中的每一条将要显示的布局文件的id
//        String[] from  从data中以该String值为key取出的对应的value值
//        int[] to  将这个值赋值到 resource中对应id的textview
        mListView.setAdapter(simpleAdapter);
    }

    @NonNull
    private HashMap<String, String> createFruit(String name, String when) {
        HashMap<String, String> apple = new HashMap<>();
        apple.put("name", name);
        apple.put("when", when);
        return apple;
    }
}
