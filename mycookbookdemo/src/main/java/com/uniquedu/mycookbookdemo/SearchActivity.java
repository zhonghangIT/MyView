package com.uniquedu.mycookbookdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.uniquedu.mycookbookdemo.adapter.CookAdapter;
import com.uniquedu.mycookbookdemo.bean.Cook;
import com.uniquedu.mycookbookdemo.db.CookDbManager;

import java.util.List;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class SearchActivity extends AppCompatActivity {
    private EditText mEditTextSearch;
    private ListView mListView;
    private List<Cook> cooks;
    private CookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mEditTextSearch= (EditText) findViewById(R.id.edittext_search);
        mEditTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_SEARCH){
                    //此处进行关键字搜索
                    if(!mEditTextSearch.getText().toString().equals("")) {
                        String keyword=mEditTextSearch.getText().toString();
                        //搜索
                        cooks=CookDbManager.newInstance(getApplicationContext()).queryCookSearch(keyword);
                        adapter=new CookAdapter(cooks,getLayoutInflater());
                        mListView.setAdapter(adapter);
                        return true;
                    }
                }
                return false;
            }
        });
        mListView= (ListView) findViewById(R.id.listview_cook);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
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
