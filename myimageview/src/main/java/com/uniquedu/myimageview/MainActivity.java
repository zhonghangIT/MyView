package com.uniquedu.myimageview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonNormal;
    private Button mButtonMatrix;
    private Button mButtonFitXY;
    private Button mButtonFitCenter;
    private Button mButtonFitStart;
    private Button mButtonFitEnd;
    private Button mButtonCenter;
    private Button mButtonCenterCrop;
    private Button mButtonCenterInside;
    private Button mButtonChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonNormal = (Button) findViewById(R.id.button_normal);
        mButtonMatrix = (Button) findViewById(R.id.button_matrix);
        mButtonFitXY = (Button) findViewById(R.id.button_fitXY);
        mButtonFitStart = (Button) findViewById(R.id.button_fitStart);
        mButtonFitCenter = (Button) findViewById(R.id.button_fitCenter);
        mButtonFitEnd = (Button) findViewById(R.id.button_fitEnd);
        mButtonCenter = (Button) findViewById(R.id.button_center);
        mButtonCenterCrop = (Button) findViewById(R.id.button_centerCrop);
        mButtonCenterInside = (Button) findViewById(R.id.button_centerInside);
        mButtonChange= (Button) findViewById(R.id.button_change);
        mButtonChange.setOnClickListener(this);
        mButtonNormal.setOnClickListener(this);
        mButtonMatrix.setOnClickListener(this);
        mButtonFitXY.setOnClickListener(this);
        mButtonFitStart.setOnClickListener(this);
        mButtonFitCenter.setOnClickListener(this);
        mButtonFitEnd.setOnClickListener(this);
        mButtonCenter.setOnClickListener(this);
        mButtonCenterCrop.setOnClickListener(this);
        mButtonCenterInside.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_change:
                Intent intentChange=new Intent(this,ChangeImageActivity.class);
                startActivity(intentChange);
                break;
            case R.id.button_normal:
                //图片的默认为fitCenter
                Intent intentNormal=new Intent(this,NormalActivity.class);
                startActivity(intentNormal);
                break;
            case R.id.button_matrix:
                //按照图片的原有大小，在屏幕的左上方显示
                Intent intentMatrix=new Intent(this,MatrixActivity.class);
                startActivity(intentMatrix);
                break;
            case R.id.button_fitXY:
                //将图片的高度宽度进行拉伸，充满整个ImageView的宽高。会出现图片变形
                Intent intentFitXY=new Intent(this,FitXYActivity.class);
                startActivity(intentFitXY);
                break;
            case R.id.button_fitStart:
                //是对图片进行拉伸，按照图片宽高中大的值拉伸为ImageView的宽高，小的值按比例拉伸，拉伸完的图片的放置位置为开始，横向图片为上方，纵向图片为左边
                Intent intentFitStart=new Intent(this,FitStartActivity.class);
                startActivity(intentFitStart);
                break;
            case R.id.button_fitCenter:
                //对图片按比列拉伸，居中
                Intent intentFitCenter=new Intent(this,FitCenterActivity.class);
                startActivity(intentFitCenter);
                break;
            case R.id.button_fitEnd:
                //对图片进行拉伸，横向图片居于下方，纵向图片居于右方
                Intent intentFitEnd=new Intent(this,FitEndActivity.class);
                startActivity(intentFitEnd);
                break;
            case R.id.button_center:
                //图片不拉伸，居于ImageView的中心
                Intent intentCenter=new Intent(this,CenterActivity.class);
                startActivity(intentCenter);
                break;
            case R.id.button_centerCrop:
                //图片拉伸充满屏幕，拉伸的比例是 ImageView的宽/图片本身的宽 和 ImageView的高/图片本身的高，取大的值作为比列拉伸。居中
                Intent intentCenterCrop=new Intent(this,CenterCropActivity.class);
                startActivity(intentCenterCrop);
                break;
            case R.id.button_centerInside:
                //图片不拉伸，居于ImageView的中心位置
                Intent intentCenterInside=new Intent(this,CenterInsideActivity.class);
                startActivity(intentCenterInside);
                break;
        }
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
