package com.uniquedu.mypage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private String[] name = {"Andorid基础", "Android系统框架", "四大组件", "基础控件",
            "TextView", "Button", "ImageView", "ProgressBar", "SeekBar", "RatingBar",
            "Switcher", "ListView", "GridView", "Dialog", "Notification", "Menu", "Spinner",
            "Toast", "CheckBox", "RadioButton", "RadioGroup"};
    private Button mButtonInsert;
    private ListView mListView;
    private SQLiteDatabase mDatabase;
    private List<String> mData;
    private MyAdapter myAdapter;
    private int page;
    private Button buttonFoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonInsert= (Button) findViewById(R.id.button_insert);
        mListView= (ListView) findViewById(R.id.listview);
        mButtonInsert.setOnClickListener(this);
        MySqliteHelper helper=new MySqliteHelper(getApplicationContext(),"TEST.DB",null,1);
        mDatabase= helper.getWritableDatabase();
        mData=new ArrayList<>();
        myAdapter=new MyAdapter();
        View foot=getLayoutInflater().inflate(R.layout.foot,null);
        buttonFoot= (Button) foot.findViewById(R.id.button_next);
        buttonFoot.setOnClickListener(this);
        mListView.addFooterView(foot);
        mListView.setAdapter(myAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_insert:
                for(String value:name) {
                    ContentValues values = new ContentValues();
                    values.put("name", value);
                    mDatabase.insert("project", null, values);
                }
                break;
            case R.id.button_next:
                //每次点击更多，都去查询数据库添加更多的数据
                 Cursor cursor=mDatabase.rawQuery("select * from project limit 3 offset ?", new String[]{"" + page * 3});
                if(cursor.getCount()>0){
                    cursor.moveToFirst();
                    while(!cursor.isAfterLast()){
                        mData.add(cursor.getString(cursor.getColumnIndex("name")));
                        cursor.moveToNext();
                    }
                    mListView.setSelection(mData.size()-1);
                    //游标的值比数量值小1
                    myAdapter.notifyDataSetChanged();
                }else{
                    buttonFoot.setEnabled(false);
                }
                page++;
                break;
        }
    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh=null;
            if(convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.item_project,null);
                vh=new ViewHolder();
                vh.textView= (TextView) convertView.findViewById(R.id.textview_name);
                convertView.setTag(vh);
            }
            vh= (ViewHolder) convertView.getTag();
            vh.textView.setText(mData.get(position));
            return convertView;
        }
        class ViewHolder{
            TextView textView;
        }
    }
}
