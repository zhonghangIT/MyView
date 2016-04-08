package com.uniquedu.mylistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.uniquedu.mylistview.R;
import com.uniquedu.mylistview.adapter.ItemsAdapter;
import com.uniquedu.mylistview.bean.ButtonMessage;
import com.uniquedu.mylistview.bean.MyMessage;
import com.uniquedu.mylistview.bean.TextMessage;
import com.uniquedu.mylistview.bean.TimeMessage;

import java.util.ArrayList;
import java.util.List;

public class ItemsActivity extends AppCompatActivity {

    private ListView listview;
    private List<MyMessage> msgs;
    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        this.listview = (ListView) findViewById(R.id.listview);
        mInflater=getLayoutInflater();
        msgs = new ArrayList<>();
        msgs.add(new TextMessage("这是一个文本内容"));
        msgs.add(new TimeMessage("当前时间为2016/4/8"));
        msgs.add(new TextMessage("这是一个文本内容"));
        msgs.add(new TextMessage("这是一个文本内容"));
        msgs.add(new TimeMessage("当前时间为2016/4/8"));
        msgs.add(new TextMessage("这是一个文本内容"));
        msgs.add(new ButtonMessage("这是一个按钮"));
        msgs.add(new TimeMessage("当前时间为2016/4/8"));
        msgs.add(new TextMessage("这是一个文本内容"));
        msgs.add(new ButtonMessage("这是一个按钮"));
        msgs.add(new TimeMessage("当前时间为2016/4/8"));
        msgs.add(new ButtonMessage("这是一个按钮"));
        ItemsAdapter adapter=new ItemsAdapter(msgs,mInflater);
        listview.setAdapter(adapter);
    }
}
