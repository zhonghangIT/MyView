package com.uniquedu.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ZhongHang on 2015/11/1.
 */
public class MyBindService extends Service{
    class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyBindService","运行到onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyBindService","运行到onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyBindService", "运行到onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("MyBindService","运行到onUnbind");
        return super.onUnbind(intent);

    }

    public void myPrint(String msg){
        Log.d("MyBindService",msg);
    }
}
