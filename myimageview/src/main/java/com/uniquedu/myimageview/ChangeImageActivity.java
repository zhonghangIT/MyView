package com.uniquedu.myimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by ZhongHang on 2015/10/17.
 */
public class ChangeImageActivity extends Activity implements View.OnClickListener{
    private Button mButtonLogo;
    private Button mButtonChange;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        mButtonLogo= (Button) findViewById(R.id.button_logo);
        mButtonChange= (Button) findViewById(R.id.button_change);
        mImageView= (ImageView) findViewById(R.id.imageview);
        mButtonLogo.setOnClickListener(this);
        mButtonChange.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_logo:
                //在xml文件当时使用android:src="@mipmap/logo"
                mImageView.setImageResource(R.mipmap.logo);
                break;
            case R.id.button_change:
                mImageView.setImageResource(R.mipmap.ic_launcher);
                break;
            case R.id.imageview:
                mImageView.setImageResource(R.mipmap.logo);
                break;
        }
    }
}
