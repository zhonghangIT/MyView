package com.uniquedu.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ZhongHang on 2015/11/14.
 */
public class MySystemReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收到系统的广播",Toast.LENGTH_SHORT).show();
    }
}
