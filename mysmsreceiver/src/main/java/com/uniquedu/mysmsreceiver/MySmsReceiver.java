package com.uniquedu.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhongHang on 2015/11/14.
 */
public class MySmsReceiver extends BroadcastReceiver{
    private static final String SMS_ACTION="android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent) {
            if(SMS_ACTION.equals(intent.getAction())){
                //接收到了短信的广播
                //获取intent参数
                Bundle bundle=intent.getExtras();
                if(bundle!=null){
                    Object[] pdus= (Object[]) bundle.get("pdus");
                    //解析为短信
                    SmsMessage[] messages=new SmsMessage[pdus.length];
                    for (int i=0;i<pdus.length;i++){
                        byte[] pdu= (byte[]) pdus[i];
                        messages[i]=SmsMessage.createFromPdu(pdu);
                    }
                    for (SmsMessage msg:messages){
                        String content=msg.getMessageBody();//短信内容
                        String sender=msg.getOriginatingAddress();//发送的手机号
                        long time=msg.getTimestampMillis();//发送的时间的毫秒数
                        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                        String sendTime=format.format(new Date(time));
                        Toast.makeText(context,"收到"+sender+"短信，内容为："+content+"  发送时间为："+sendTime,Toast.LENGTH_SHORT).show();
                    }
                }
            }
    }
}
