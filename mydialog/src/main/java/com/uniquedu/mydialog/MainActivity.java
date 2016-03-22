package com.uniquedu.mydialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonNormal;
    private Button mButtonSingle1;
    private Button mButtonSingle2;
    private Button mButtonMore;
    private Button mButtonDIY;
    private Button mButtonDate;
    private Button mButtonTime;
    private Calendar mCalendarDate;
    private Calendar mCalendarTime;
    private String[] sexs = {"男", "女"};
    private int select;
    private String[] hobby={"篮球","足球","乒乓球","骑车","阅读","唱歌"};
    private boolean[] isHobbyChecked=new boolean[hobby.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonNormal = (Button) findViewById(R.id.button_normal);
        mButtonNormal.setOnClickListener(this);
        mButtonSingle1 = (Button) findViewById(R.id.button_single1);
        mButtonSingle2 = (Button) findViewById(R.id.button_single2);
        mButtonSingle1.setOnClickListener(this);
        mButtonSingle2.setOnClickListener(this);
        mButtonMore= (Button) findViewById(R.id.button_more);
        mButtonMore.setOnClickListener(this);
        mButtonDIY= (Button) findViewById(R.id.button_diy);
        mButtonDIY.setOnClickListener(this);
        mButtonDate= (Button) findViewById(R.id.button_date);
        mButtonDate.setOnClickListener(this);
        mButtonTime= (Button) findViewById(R.id.button_time);
        mButtonTime.setOnClickListener(this);
        mCalendarDate=Calendar.getInstance();
        mCalendarTime=Calendar.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_normal:
                createNormalDialog();
                break;
            case R.id.button_single1:
                createSingleDialog1();
                break;
            case R.id.button_single2:
                createSingleDialog2();
                break;
            case R.id.button_more:
                createMultiDialog();
                break;
            case R.id.button_diy:
                createDIYDialog();
                break;
            case R.id.button_date:
                createDatePickerDialog();
                break;
            case R.id.button_time:
                createTimePickerDialog();
                break;
        }
    }

    private void createTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat format = new SimpleDateFormat("HH-mm");
                mCalendarTime.set(Calendar.HOUR, hourOfDay);
                mCalendarTime.set(Calendar.MINUTE, minute);
                Toast.makeText(getApplicationContext(), "选中的时间为：" + format.format(mCalendarTime.getTime()), Toast.LENGTH_SHORT).show();
            }
        }, mCalendarTime.get(Calendar.HOUR), mCalendarTime.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private void createDatePickerDialog() {
        DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //java中的月份是从0-11的
//                            Toast.makeText(getApplicationContext(),"选中的年:"+year+"月:"+monthOfYear+"日:"+dayOfMonth,Toast.LENGTH_SHORT).show();
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                mCalendarDate.set(year,monthOfYear,dayOfMonth);
                Toast.makeText(getApplicationContext(), "选中的日期为：" + format.format(mCalendarDate.getTime()), Toast.LENGTH_SHORT).show();
            }
        },mCalendarDate.get(Calendar.YEAR),mCalendarDate.get(Calendar.MONTH),mCalendarDate.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void createDIYDialog() {
        final Dialog dialog=new Dialog(MainActivity.this);
        LayoutInflater inflater=getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.my_dialog, null);
        //此处不能直接使用findViewById,因为该ImageView存在于dialogView上
        ImageView imageView= (ImageView) dialogView.findViewById(R.id.imageview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//关闭dialog
                Toast.makeText(getApplicationContext(), "点击了图片", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉Dialog自带的标题。必须在setContentView之前调用
        dialog.setContentView(dialogView);
        dialog.show();
    }

    private void createMultiDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("请选择您的爱好").setMultiChoiceItems(hobby, isHobbyChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //将点击的which条的状态isChecked赋值给对应爱好的布尔值数组isHobbyCHecked
                    isHobbyChecked[which]=isChecked;
            }
        }).setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String checkedHobby="";
                for (int i=0;i<isHobbyChecked.length;i++){
                    if(isHobbyChecked[i]){
                        checkedHobby+=hobby[i];
                    }
                }
                Toast.makeText(getApplicationContext(), "选中的所有爱好为:" + checkedHobby, Toast.LENGTH_SHORT).show();
            }
        }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //取消所有爱好的选中状态
                isHobbyChecked = new boolean[hobby.length];
            }
        });
        builder.show();
    }

    private void createSingleDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("选择性别")
                .setSingleChoiceItems(sexs, select, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //将选中的性别的游标赋值给select
                        select = which;
                    }
                })
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "选中的性别为:" + sexs[select], Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    private void createSingleDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("选择性别").setItems(sexs, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "选中的性别为：" + sexs[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void createNormalDialog() {
        //Dialog依赖于Activity
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("弹出框的标题").setMessage("弹出框的内容")
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("中间", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "点击了中间按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
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
