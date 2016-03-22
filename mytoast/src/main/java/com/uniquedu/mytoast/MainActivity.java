package com.uniquedu.mytoast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButtonNormal;
    private Button mButtonGravity;
    private Button mButtonDIY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonNormal= (Button) findViewById(R.id.button_normal);
        mButtonGravity= (Button) findViewById(R.id.button_gravity);
        mButtonDIY= (Button) findViewById(R.id.button_diy);
        mButtonNormal.setOnClickListener(this);
        mButtonGravity.setOnClickListener(this);
        mButtonDIY.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_normal:
                //Toast不依赖于界面，不响应事件。
                Toast.makeText(getApplication(),"普通的显示样式",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_gravity:
                Toast toast=Toast.makeText(getApplication(),"显示在上方",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,100);//三个参数代表的意义，Toast显示的位置，X轴偏移的距离，Y轴偏移的距离
                toast.show();
                break;
            case R.id.button_diy:
                showMyToast();

                break;
        }
    }

    /**
     * 显示自定义Toast的方法
     */
    private void showMyToast() {
        //得到layout当中的xml文件需要用到LayoutInflater
        LayoutInflater inflater=getLayoutInflater();
//                LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View toastView=inflater.inflate(R.layout.my_toast,null);
        Toast toast=new Toast(getApplicationContext());
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT|Gravity.TOP,0,0);//显示在左上角
        toast.show();
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
