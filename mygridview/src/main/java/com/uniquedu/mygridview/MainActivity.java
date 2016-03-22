package com.uniquedu.mygridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView mGridView;
    private List<Fruit> mFruits;
    private FruitAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridView= (GridView) findViewById(R.id.gridview);
        mFruits=new ArrayList<>();
        mFruits.add(new Fruit("苹果",R.mipmap.apple));
        mFruits.add(new Fruit("香蕉",R.mipmap.banana));
        mFruits.add(new Fruit("草莓",R.mipmap.berry));
        mFruits.add(new Fruit("樱桃",R.mipmap.cherry));
        mFruits.add(new Fruit("猕猴桃",R.mipmap.kiwi));
        mFruits.add(new Fruit("柠檬",R.mipmap.lemon));
        mFruits.add(new Fruit("芒果",R.mipmap.mango));
        mFruits.add(new Fruit("橘子",R.mipmap.orange));
        mFruits.add(new Fruit("桃",R.mipmap.peach));
        mFruits.add(new Fruit("梨",R.mipmap.pear));
        mFruits.add(new Fruit("西红柿",R.mipmap.tomatoes));
        mAdapter=new FruitAdapter(mFruits,getLayoutInflater());
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"选中的水果名称："+mFruits.get(position).getName(),Toast.LENGTH_SHORT).show();
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
