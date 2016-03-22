package com.uniquedu.mynotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButtonNormal;
    private Button mButtonCancel;
    private Button mButtonDIY;
    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonNormal= (Button) findViewById(R.id.button_normal);
        mButtonCancel= (Button) findViewById(R.id.button_cancel);
        mButtonNormal.setOnClickListener(this);
        mButtonCancel.setOnClickListener(this);
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mButtonDIY= (Button) findViewById(R.id.button_diy);
        mButtonDIY.setOnClickListener(this);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_normal:
                createNormalNotification();
                break;
            case R.id.button_cancel:
                manager.cancel(0x23);
                break;
            case R.id.button_diy:
                createMyNotification();
                break;
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void createMyNotification() {
        //自定义通知，通知上只允许放置RemotView,包含TextView ImageView ImageButton等等
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0x25,intent,PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder builder=new Notification.Builder(getApplicationContext());
        RemoteViews remoteViews=new RemoteViews(getPackageName(), R.layout.my_notification);
        //Android自定义Notification时需要注意，虽然设置了自定义的View，但仍需要设置ContentTitle，ContentInfo,ContentText,Ticker,smallIcon
        builder.setSmallIcon(R.mipmap.ic_launcher)//状态栏显示的图片
                .setTicker("状态栏显示的内容")
                .setContentTitle("通知的标题") //通知栏的标题
                .setContentText("通知的内容")
                .setContentInfo("通知的详细信息")//此处信息会显示在时间下方
                .setContentIntent(pendingIntent)
                .setContent(remoteViews)//设置自定义的View
                .setAutoCancel(true)//是否可以自行关闭
                .setWhen(System.currentTimeMillis());//显示的时间
        Notification notification=builder.build();
        manager.notify(0x23, notification);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void createNormalNotification() {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        //PendingIntent不依赖于应用，归系统进行管理。PendingIntent延时消息，需要一定的触发条件,此处的触发条件为点击通知
        //PendingIntent的功能封装在了Intent中
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0x25,intent,PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder builder=new Notification.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher)//状态栏显示的图片
                .setTicker("状态栏显示的内容")
                .setContentTitle("通知的标题") //通知栏的标题
                .setContentText("通知的内容")
                .setContentInfo("通知的详细信息")//此处信息会显示在时间下方
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)//是否可以自行关闭
                .setWhen(System.currentTimeMillis());//显示的时间
        Notification notification=builder.build();//创建nitification,在15版本以后使用此方法
        manager.notify(0x23, notification);//设置notification在通知管理器中的id，并让其显示
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
