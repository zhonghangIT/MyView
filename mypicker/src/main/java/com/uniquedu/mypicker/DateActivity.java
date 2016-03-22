package com.uniquedu.mypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ZhongHang on 2015/10/18.
 */
public class DateActivity extends AppCompatActivity {
    private Button mButtonGetTime;
    private DatePicker mDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        mButtonGetTime = (Button) findViewById(R.id.button_get_time);
        mDatePicker = (DatePicker) findViewById(R.id.date_picker);
        mButtonGetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到Picker上的时间
                Calendar calendar = Calendar.getInstance();
                calendar.set(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                Log.d("datepicker", "当前选择的时间为:" + format.format(calendar.getTime()));
            }
        });
    }
}
