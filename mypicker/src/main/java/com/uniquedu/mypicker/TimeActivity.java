package com.uniquedu.mypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by ZhongHang on 2015/10/18.
 */
public class TimeActivity extends AppCompatActivity{
    private Button mButtonTime;
    private TimePicker mTimePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        mButtonTime= (Button) findViewById(R.id.button_get_time);
        mTimePicker= (TimePicker) findViewById(R.id.time_picker);
        mButtonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("timepicker","当前时间为:"+mTimePicker.getCurrentHour()+":"+mTimePicker.getCurrentMinute());
            }
        });
    }
}
