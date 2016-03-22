package com.uniquedu.mysms;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mButtonSend;
    private EditText mEditTextContent;
    private String mPhoneNum="18612117174";
    private static final String SENT_ACTION="SENT_SMS_ACTION";
    private static final String DELIVERED_ACTION="DELIVERED_SMS_ACTION";
    private MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建广播接收器对象
        myReceiver=new MyReceiver();
        //创建过滤器
        IntentFilter filter=new IntentFilter();
        //添加过滤action
        filter.addAction(SENT_ACTION);
        filter.addAction(DELIVERED_ACTION);
        //注册广播
        registerReceiver(myReceiver,filter);
        mEditTextContent= (EditText) findViewById(R.id.edittext_content);
        mButtonSend= (Button) findViewById(R.id.button_send);
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到要发送的短信的内容
                String content=mEditTextContent.getText().toString();
                //发送短息用到SmsManager
                SmsManager manager=SmsManager.getDefault();
                //短信长度受限。对短信内容进行分割
                List<String> messages=manager.divideMessage(content);
                //创建短信发送成功与否的pendingIntent
                Intent intentSent=new Intent(SENT_ACTION);//一个过滤的Action
                PendingIntent pendingIntentSent=PendingIntent.getBroadcast(getApplicationContext(), 0, intentSent, PendingIntent.FLAG_ONE_SHOT);
                Intent intentDelivered=new Intent(DELIVERED_ACTION);//一个过滤的Action
                PendingIntent pendingIntentDelivered=PendingIntent.getBroadcast(getApplicationContext(),0,intentDelivered,PendingIntent.FLAG_ONE_SHOT);
                for(String msg:messages){
                    //发送短信五个参数
                    //1 发送短信目标号码
                    //2 短信中心号码，可以传null
                    //3 短信内容
                    //4 本机是否发送成功反馈的pendingIntent
                    //5 短信中心发送成功与否的反馈 pendingIntent
                    manager.sendTextMessage(mPhoneNum,null,msg,pendingIntentSent,pendingIntentDelivered);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除广播注册
        unregisterReceiver(myReceiver);
    }

    class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (getResultCode()){
                case RESULT_OK:
                    if(SENT_ACTION.equals(intent.getAction())) {
                        Log.d("mysms", "短信已经发送成功到短信中心");
                    }else if(DELIVERED_ACTION.equals(intent.getAction())){
                        Log.d("mysms", "短信已经发送到目标手机");
                    }
                    break;
                default:
                    Log.d("mysms","失败反馈");
                    break;
            }
        }
    }
}
