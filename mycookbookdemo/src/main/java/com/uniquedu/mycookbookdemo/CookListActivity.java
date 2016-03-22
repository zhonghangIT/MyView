package com.uniquedu.mycookbookdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.uniquedu.mycookbookdemo.adapter.CookAdapter;
import com.uniquedu.mycookbookdemo.bean.Cook;
import com.uniquedu.mycookbookdemo.bean.CookType;
import com.uniquedu.mycookbookdemo.db.CookDbManager;

import java.util.List;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class CookListActivity extends AppCompatActivity {
    private TextView mTextViewName;//分类的名称
    private ListView mListViewCook;
    private CookType cookType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_list);
        cookType=new CookType();
        Intent intent=getIntent();
        cookType.setId(intent.getStringExtra("type_id"));
        cookType.setName(intent.getStringExtra("type_name"));
        mTextViewName= (TextView) findViewById(R.id.textview_name);
        mTextViewName.setText(cookType.getName());
        //分类的名称由intent传递过来
        mListViewCook= (ListView) findViewById(R.id.listview_cook);
        //根据传递过来的分类名称去查询数据库中的数据
        final List<Cook> cooks= CookDbManager.newInstance(getApplicationContext()).queryCook(cookType.getId());
        CookAdapter adapter=new CookAdapter(cooks,getLayoutInflater());
        mListViewCook.setAdapter(adapter);
        mListViewCook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CookListActivity.this);
                builder.setTitle("菜谱的详细信息").setMessage(cooks.get(position).toString())
                        .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                            }
                        });
                builder.show();
            }
        });
    }
}
