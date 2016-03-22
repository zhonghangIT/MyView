package com.uniquedu.myintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonComponent;
    private Button mButtonExtra;
    private Button mButtonCamera;
    private Button mButtonPhone;
    private Button mButtonUrl;
    private Button mButtonCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonComponent = (Button) findViewById(R.id.button_component);
        mButtonComponent.setOnClickListener(this);
        mButtonExtra = (Button) findViewById(R.id.button_extra);
        mButtonExtra.setOnClickListener(this);
        mButtonCamera = (Button) findViewById(R.id.button_camera);
        mButtonCamera.setOnClickListener(this);
        mButtonPhone = (Button) findViewById(R.id.button_phone);
        mButtonPhone.setOnClickListener(this);
        mButtonUrl = (Button) findViewById(R.id.button_url);
        mButtonUrl.setOnClickListener(this);
        mButtonCategory = (Button) findViewById(R.id.button_category);
        mButtonCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_component:
                useIntentComponent();
                break;
            case R.id.button_extra:
                useIntentExtra();
                break;
            case R.id.button_camera:
                startCamera();
                break;
            case R.id.button_phone:
                startDial();
                break;
            case R.id.button_url:
                startWeb(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                break;
            case R.id.button_category:
                startHideActivty();
                break;
        }
    }

    private void startHideActivty() {
        //                Intent intent=new Intent(MainActivity.this,CategoryActivity.class);//显示启动
        Intent intent = new Intent();
        intent.setAction("com.uniquedu.category");
        startActivity(intent);
    }

    private void startWeb(String actionView, Uri parse) {
        Intent intent = new Intent();
        intent.setAction(actionView);
        intent.setData(parse);
        startActivity(intent);
    }

    private void startDial() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);//启动拨号界面
        intent.setData(Uri.parse("tel:18612117174"));
        startActivity(intent);
    }

    private void startCamera() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    private void useIntentExtra() {
        Intent intent = new Intent(MainActivity.this, ExtraActivity.class);
        intent.putExtra("com.uniquedu.content", "我是使用extra传递的内容");
        startActivity(intent);
    }

    /**
     * 是用了Intent的属性Component
     */
    private void useIntentComponent() {
        //                Intent intent=new Intent(MainActivity.this,ComponentActivity.class);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this, ComponentActivity.class));
        startActivity(intent);
    }
}
