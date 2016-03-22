package com.uniquedu.myradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private Button mButtonResult;
    private RadioGroup mRadioGroupSex;
    private RadioButton mRadioButtonMale;
    private RadioButton mRadioButtonFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonResult= (Button) findViewById(R.id.button_ok);
        mRadioGroupSex= (RadioGroup) findViewById(R.id.radioGroup);
        mRadioButtonMale= (RadioButton) findViewById(R.id.radiobutton_male);
        mRadioButtonFemale= (RadioButton) findViewById(R.id.radiobutton_female);
        mButtonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方式一通过对radiobutton判断是否选中，得到被选中的

//                if(mRadioButtonMale.isChecked()){
//                    Log.d("radiobutton","你选中的性别"+mRadioButtonMale.getText());
//                }else{
//                    Log.d("radiobutton","你选中的性别"+mRadioButtonFemale.getText());
//                }
                //方式二通过radioGroup得到被选中的RadioButton的id
                int id= mRadioGroupSex.getCheckedRadioButtonId();
                RadioButton checkedRadioButton= (RadioButton) findViewById(id);
                Log.d("radiobutton","你选中的性别"+checkedRadioButton.getText());
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
