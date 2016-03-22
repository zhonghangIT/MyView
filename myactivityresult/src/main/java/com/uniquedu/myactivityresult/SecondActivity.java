package com.uniquedu.myactivityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ZhongHang on 2015/10/18.
 */
public class SecondActivity extends AppCompatActivity {
    private EditText mEditText;
    private Button mButtonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mEditText= (EditText) findViewById(R.id.edittext);
        mButtonBack= (Button) findViewById(R.id.button_back);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String data=mEditText.getText().toString();
                intent.putExtra(MainActivity.GET_MY_DATA,data);
                setResult(RESULT_OK,intent);//code代表结果正常，data中存储了将要返回的内容
                finish();//关闭Activity
            }
        });
    }
}
