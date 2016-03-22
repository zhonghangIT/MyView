package com.uniquedu.mycookbookdemo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.uniquedu.mycookbookdemo.bean.Cook;
import com.uniquedu.mycookbookdemo.bean.CookType;
import com.uniquedu.mycookbookdemo.db.CookDbManager;

import java.util.List;

/**
 * Created by ZhongHang on 2015/11/15.
 */
public class AddCookActivity extends AppCompatActivity {
    private EditText mEditTextName;
    private EditText mEditTextOriginal;
    private EditText mEditTextDoing;
    private Spinner mSpinnerType;
    private ImageView mImageView;
    private Button mButtonCommit;
    private List<CookType> types;
    private static final int MY_REQUEST_CODE=0x23;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cook);
        mEditTextName= (EditText) findViewById(R.id.edittext_name);
        mEditTextOriginal= (EditText) findViewById(R.id.edittext_original);
        mEditTextDoing= (EditText) findViewById(R.id.edittext_method);
        mSpinnerType= (Spinner) findViewById(R.id.spinner_type);
        mImageView= (ImageView) findViewById(R.id.imageview_cook);
        mButtonCommit= (Button) findViewById(R.id.button_commit);
        //设置下拉框的数据
        types= CookDbManager.newInstance(getApplicationContext()).getCookTypes();
        ArrayAdapter<CookType> adapter=new ArrayAdapter<CookType>(AddCookActivity.this,android.R.layout.simple_spinner_dropdown_item,types);
        mSpinnerType.setAdapter(adapter);
        //添加图片的方法
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用系统相册返回图片信息
                Intent intent=new Intent(Intent.ACTION_PICK,null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,MY_REQUEST_CODE);
            }
        });
        mButtonCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cook cook=new Cook();
                String name=mEditTextName.getText().toString();
                if(name!=null&&!name.equals("")) {
                    cook.setName(mEditTextName.getText().toString());
                }else{
                    //弹出提示
                    Toast.makeText(getApplicationContext(),"菜名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                cook.setOriginal(mEditTextOriginal.getText().toString());
                cook.setDoing(mEditTextDoing.getText().toString());
                int position=mSpinnerType.getSelectedItemPosition();
                cook.setType(types.get(position).getId());
                if(path!=null) {
                    cook.setImgPath(path);

                }
                Log.d("cook",cook.toString());
                CookDbManager.newInstance(getApplicationContext()).insertCook(cook);
                AddCookActivity.this.finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&requestCode==MY_REQUEST_CODE){
            //正确返回的值
            Uri selectImage=data.getData();
            Cursor cursor=getContentResolver().query(selectImage, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
            cursor.moveToFirst();
            path= cursor.getString(0);
            Log.d("imgPath","得到的图片路径"+path);
            mImageView.setImageBitmap(BitmapFactory.decodeFile(path));
            cursor.close();
        }
    }
}
