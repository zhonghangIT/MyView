package com.uniquedu.myappupdate;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
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
        switch (id) {
            case R.id.action_about:
                Toast toast = new Toast(getApplicationContext());
                toast.setView(getLayoutInflater().inflate(R.layout.toast_about, null));
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.action_update:
                //立刻更新，稍后更新
                createUpdateDialog();
                return true;
            case R.id.action_quit:
                MainActivity.this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("更新提示").setMessage("我们更新了新的版本，新版本优化了界面的加载，优化了一些基础数据。")
                .setNegativeButton("立刻更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        createNotification();
                    }
                }).setPositiveButton("稍后更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                createTimePickerDialog();

            }
        });
        builder.show();
    }

    private void createTimePickerDialog() {
        //稍后更新，弹出一个延后时间长度的选择。
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(), "我们会在" + hourOfDay + "小时" + minute + "分后进行更新", Toast.LENGTH_SHORT).show();
            }
        }, 0, 0, true);
        timePickerDialog.show();
    }

    private void createNotification() {
        //点击立刻更新，通知栏弹出消息通知更新完成
        //1 创建Intent 2使用Intent创建PendingIntent 3 使用PendingIntent创建Notification Builder
        //4 使用builder创建Notification 5 使用manager显示notification
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0x25, intent, PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder notificationBuilder = new Notification.Builder(getApplicationContext());
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher).setTicker("已经更新完成").setContentTitle("更新信息")
                .setContentText("更新完成").setContentInfo("优化了界面，优化了基础数据")
                .setContentIntent(pendingIntent).setAutoCancel(true).setWhen(System.currentTimeMillis());
        Notification notification = notificationBuilder.getNotification();
        manager.notify(0x23, notification);
    }
}
