package com.uniquedu.mymenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.button_context);
        registerForContextMenu(mButton);//此处在mButton上绑定了上下文菜单
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //创建ContextMenu
        menu.setHeaderTitle("我是上下文菜单的标题");
        menu.addSubMenu(0, Menu.FIRST, Menu.NONE, "第一条");
        menu.addSubMenu(0,Menu.FIRST+1,Menu.NONE,"第二条");
        menu.addSubMenu(0,Menu.FIRST+2,Menu.NONE,"第三条");
        menu.addSubMenu(0,Menu.FIRST+3,Menu.NONE,"第四条");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //相应ContextMenu事件
        switch (item.getItemId()){
            case Menu.FIRST:
                Toast.makeText(getApplicationContext(),"点击了第一条信息",Toast.LENGTH_SHORT).show();
                return true;
            case Menu.FIRST+1:
                Toast.makeText(getApplicationContext(),"点击了第二条信息",Toast.LENGTH_SHORT).show();
                return true;
            case Menu.FIRST+2:
                Toast.makeText(getApplicationContext(),"点击了第三条信息",Toast.LENGTH_SHORT).show();
                return true;
            case Menu.FIRST+3:
                Toast.makeText(getApplicationContext(),"点击了第四条信息",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
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

       switch (id){
           case R.id.action_setting:
               //设置
               Toast.makeText(getApplicationContext(),"点击了设置",Toast.LENGTH_SHORT).show();
            return true;
           case R.id.action_other:
               Toast.makeText(getApplicationContext(),"点击了其他",Toast.LENGTH_SHORT).show();
               //其他
               return true;
           case R.id.action_more:
               Toast.makeText(getApplicationContext(),"点击了更多",Toast.LENGTH_SHORT).show();
//               更多
               return true;
       }

        return super.onOptionsItemSelected(item);
    }
}
