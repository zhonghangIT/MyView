package com.uniquedu.myintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ZhongHang on 2015/10/18.
 */
public class ExtraActivity extends AppCompatActivity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        mTextView= (TextView) findViewById(R.id.textview_receive);
        Intent intent=getIntent();//得到启动该界面的Intent
        String data=intent.getStringExtra("com.uniquedu.content");
        mTextView.setText(data);
    }
}
