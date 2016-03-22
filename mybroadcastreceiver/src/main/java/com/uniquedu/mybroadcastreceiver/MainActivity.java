package com.uniquedu.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mButtonSend;
    private TextView mTextViewContent;
    private static final String MY_BROAD_FLAG="content";
    private MyReceiver myReceiver;
    private static  final String MY_FILTER_ACTION="com.uniquedu.myaction";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在界面上绑定一个广播，创建广播接收器
        myReceiver=new MyReceiver();
        //创建广播过滤器
        IntentFilter filter=new IntentFilter();
        //过滤的广播的action
        filter.addAction(MY_FILTER_ACTION);
        //绑定广播
        registerReceiver(myReceiver,filter);
        //创建广播接收器
        mButtonSend= (Button) findViewById(R.id.button_send);
        mTextViewContent= (TextView) findViewById(R.id.textview_content);
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播的方法，指定发送的广播的action
                Intent intent=new Intent(MY_FILTER_ACTION);
                intent.putExtra(MY_BROAD_FLAG, "广播包含的信息");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //接收广播的位置
            String content=intent.getStringExtra(MY_BROAD_FLAG);
            mTextViewContent.setText("接收到广播的内容："+content);
        }
    }
}
