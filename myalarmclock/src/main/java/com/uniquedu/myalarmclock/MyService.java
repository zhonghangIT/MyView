package com.uniquedu.myalarmclock;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ZhongHang on 2015/11/1.
 */
public class MyService  extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("myAlarmClock","闹钟启动");
        Toast.makeText(getApplicationContext(),"闹钟启动",Toast.LENGTH_SHORT).show();
        createNormalNotification();
        return super.onStartCommand(intent, flags, startId);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void createNormalNotification() {
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent=new Intent(getApplicationContext(),WeakupActivty.class);
        //PendingIntent不依赖于应用，归系统进行管理。PendingIntent延时消息，需要一定的触发条件,此处的触发条件为点击通知
        //PendingIntent的功能封装在了Intent中
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0x25,intent,PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder builder=new Notification.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher)//状态栏显示的图片
                .setTicker("闹钟")
                .setContentTitle("到时间了") //通知栏的标题
                .setContentText("起床")
                .setContentInfo("起床时间到了，抓紧时间")//此处信息会显示在时间下方
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)//是否可以自行关闭
                .setWhen(System.currentTimeMillis());//显示的时间
        Notification notification=builder.build();//创建nitification,在15版本以后使用此方法
        manager.notify(0x23, notification);//设置notification在通知管理器中的id，并让其显示
    }
}
