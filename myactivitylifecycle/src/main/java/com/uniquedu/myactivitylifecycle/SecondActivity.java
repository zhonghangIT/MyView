package com.uniquedu.myactivitylifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ZhongHang on 2015/10/18.
 */
public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
