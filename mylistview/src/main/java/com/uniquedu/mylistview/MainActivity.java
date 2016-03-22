package com.uniquedu.mylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButtonArray;
    private Button mButtonSimple;
    private Button mButtonBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonArray= (Button) findViewById(R.id.button_array);
        mButtonArray.setOnClickListener(this);
        mButtonSimple= (Button) findViewById(R.id.button_simple);
        mButtonSimple.setOnClickListener(this);
        mButtonBase= (Button) findViewById(R.id.button_base);
        mButtonBase.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_array:
                Intent intentArray=new Intent(getApplicationContext(),ArrayActivity.class);
                startActivity(intentArray);
                break;
            case R.id.button_simple:
                Intent intentSimple=new Intent(getApplicationContext(),SimpleActivity.class);
                startActivity(intentSimple);
                break;
            case R.id.button_base:
                Intent intentBase=new Intent(getApplicationContext(),UseBaseAdapterActivity.class);
                startActivity(intentBase);
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
