package com.uniquedu.mycheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mButton;//得到爱好的按钮
    private LinearLayout mLinearlayout;//包含所有爱好的容器
    private List<String> mList;//存放所有选中的爱好
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.button);
        mLinearlayout= (LinearLayout) findViewById(R.id.linearlayout_hobby);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList=new ArrayList<String>();
                for (int i=0;i<mLinearlayout.getChildCount();i++){
                    //遍历所有的子视图
                    CheckBox checkBox= (CheckBox) mLinearlayout.getChildAt(i);
                    if(checkBox.isChecked()){
                        mList.add(checkBox.getText().toString());
                    }
                }

                for(int i=0;i<mList.size();i++){
                    Log.d("hobby","选中的爱好："+mList.get(i));
                }

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
