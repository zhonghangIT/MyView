package com.uniquedu.myalarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextTime;
    private Button mButtonStart;
    private AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextTime= (EditText) findViewById(R.id.edittext_time);
        mButtonStart= (Button) findViewById(R.id.button_start);
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int seconds=  Integer.parseInt(mEditTextTime.getText().toString());
                //延时的PendingIntent
                Intent data=new Intent(getApplicationContext(),MyService.class);
                PendingIntent pendingIntent=PendingIntent.getService(getApplicationContext(),0,data,PendingIntent.FLAG_ONE_SHOT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+seconds,pendingIntent);
                //闹钟使用精确闹钟会加大电量的消耗，这里可以自行选择
            }
        });
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
