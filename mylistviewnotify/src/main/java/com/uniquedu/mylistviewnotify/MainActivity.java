package com.uniquedu.mylistviewnotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyMessage> myMessages;
    private ListView mListView;
    private MessageAdapter mAdapter;
    private LayoutInflater mInflater;
    private Button mButtonFooter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView) findViewById(R.id.listview);
        myMessages=new ArrayList<>();
        myMessages.add(new MyMessage("已经掌握TextView"));
        myMessages.add(new MyMessage("已经掌握Button"));
        myMessages.add(new MyMessage("已经掌握ImageView"));
        myMessages.add(new MyMessage("已经掌握RadioButton"));
        myMessages.add(new MyMessage("已经掌握CheckBox"));
        myMessages.add(new MyMessage("已经掌握SeekBar"));
        mInflater= getLayoutInflater();
        mAdapter=new MessageAdapter(myMessages,mInflater);
        View footer=mInflater.inflate(R.layout.listview_footer,null);
        mButtonFooter= (Button) footer.findViewById(R.id.button_more);
        mButtonFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMessages.add(new MyMessage("已经学习的Toast"));
                myMessages.add(new MyMessage("已经学习的Dialog"));
                myMessages.add(new MyMessage("已经学习的Menu"));
                myMessages.add(new MyMessage("已经学习的Notification"));
                myMessages.add(new MyMessage("已经学习的AdapterView"));
                //此处添加的数据不会添加到数据列表当中去
                mAdapter.notifyDataSetChanged();//调用该方法后数据会对应的刷新
            }
        });
        mListView.addFooterView(footer);//添加底部必须设置到setAdapter之前
        mListView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
