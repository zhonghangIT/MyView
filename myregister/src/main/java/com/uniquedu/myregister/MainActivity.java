package com.uniquedu.myregister;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextName;//注册时的姓名
    private RadioGroup mRadioGroupSex;//性别
    private LinearLayout mLinearLayoutHobby;//爱好
    private DatePicker mDatePicker;//出生日期
    private RatingBar mRatingBar;//自我评分
    private TextView mTextViewBody;
    private SeekBar mSeekBarBody;
    private Button mButtonCommit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextName= (EditText) findViewById(R.id.edittext_name);

        mRadioGroupSex= (RadioGroup) findViewById(R.id.radiogroup);
        mLinearLayoutHobby= (LinearLayout) findViewById(R.id.linearlayout_hobbys);
        mDatePicker= (DatePicker) findViewById(R.id.datepicker);
        mRatingBar= (RatingBar) findViewById(R.id.ratingbar);
        mTextViewBody= (TextView) findViewById(R.id.textview_body);
        mSeekBarBody= (SeekBar) findViewById(R.id.seekbar);
        mButtonCommit= (Button) findViewById(R.id.button_commit);
        mSeekBarBody.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    mTextViewBody.setText("体重"+progress+"kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mButtonCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("register", "姓名:" + mEditTextName.getText().toString());
               int id= mRadioGroupSex.getCheckedRadioButtonId();
                RadioButton checked= (RadioButton) findViewById(id);
                Log.d("register", "性别:" + checked.getText());
                for(int i=0;i<mLinearLayoutHobby.getChildCount();i++){
                    CheckBox checkBox= (CheckBox) mLinearLayoutHobby.getChildAt(i);
                    if(checkBox.isChecked()){
                        Log.d("register","爱好:"+checkBox.getText().toString());
                    }
                }
                Calendar calendar=Calendar.getInstance();
                calendar.set(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                Log.d("register", "出生日期:"+format.format(calendar.getTime()));
                Log.d("register","自我评分:"+mRatingBar.getRating()+"分");
                Log.d("register","体重:"+mSeekBarBody.getProgress()+"kg");
                Log.d("register","提交完毕");
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
