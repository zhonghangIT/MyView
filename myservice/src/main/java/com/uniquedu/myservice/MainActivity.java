package com.uniquedu.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButtonStartService;
    private Button mButtonStopService;
    private Button mButtonBindService;
    private Button mButtonUnbindService;
    private MyBindService myBindService;
    private Button mButtonMethod;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
                //成功连接时回调
            Log.d("MainActivity", "连接成功");
            if(service instanceof MyBindService.MyBinder){
                myBindService=((MyBindService.MyBinder) service).getService();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //连接失败，例如内存不足时将此Service回收
            Log.d("MainActivity","连接失败");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonStartService= (Button) findViewById(R.id.button_start);
        mButtonStopService= (Button) findViewById(R.id.button_stop);
        mButtonBindService= (Button) findViewById(R.id.button_bind);
        mButtonUnbindService= (Button) findViewById(R.id.button_unbind);
        mButtonMethod= (Button) findViewById(R.id.button_method);
        mButtonStartService.setOnClickListener(this);
        mButtonStopService.setOnClickListener(this);
        mButtonBindService.setOnClickListener(this);
        mButtonUnbindService.setOnClickListener(this);
        mButtonMethod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_start:
                    Intent intentStart=new Intent(MainActivity.this,MyStartService.class);
                    startService(intentStart);
                    break;
                case R.id.button_stop:
                    Intent intentStop=new Intent(MainActivity.this,MyStartService.class);
                    stopService(intentStop);
                    break;
                case R.id.button_bind:
                    Intent intentBind=new Intent(MainActivity.this,MyBindService.class);
                    bindService(intentBind,connection,BIND_AUTO_CREATE);//三个参数。1 Intent制定要绑定的服务 2 ServiceConnection 和Serice连接成功(成功绑定)和连接失败(意外回收)时会调用 3启动的方式
                    break;
                case R.id.button_unbind:
                    unbindService(connection);
                    break;
                case R.id.button_method:
                    myBindService.myPrint("调用绑定服务的方法");
                    break;
            }
    }
}
