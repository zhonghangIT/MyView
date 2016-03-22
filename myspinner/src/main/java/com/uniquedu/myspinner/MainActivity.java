package com.uniquedu.myspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Spinner mSpinnerCity;
    private String[] citys={"北京","上海","广州","深圳","成都","武汉","济南"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.button_city);
        mSpinnerCity= (Spinner) findViewById(R.id.spinner_city);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,citys);
        mSpinnerCity.setAdapter(adapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int position= mSpinnerCity.getSelectedItemPosition();//选中的条目的position
                String city=citys[position];
                Toast.makeText(getApplicationContext(),"选中的城市为："+city,Toast.LENGTH_SHORT).show();
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
