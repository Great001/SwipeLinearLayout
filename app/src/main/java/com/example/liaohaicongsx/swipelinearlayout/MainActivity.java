package com.example.liaohaicongsx.swipelinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeLinearLayout.OnSwipeListener{

    private ListView mLvTest;
    private LvAdapter mAdapter;
    private String[] mNums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLvTest = (ListView) findViewById(R.id.lv_test);
        mNums = new String[20];
        for(int i = 0;i<20;i++){
            mNums[i] = String.valueOf(i+1);
        }
        mAdapter = new LvAdapter(this,mNums);
        mLvTest.setAdapter(mAdapter);

        mLvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            int childCount = mLvTest.getChildCount();
            for(int i = 0;i< childCount;i++){
                ((SwipeLinearLayout)mLvTest.getChildAt(i)).setOnSwipeListener(this);
            }
        }
    }

    @Override
    public void onSwipe(SwipeLinearLayout swipeLinearLayout,int direction) {
        int childCount = mLvTest.getChildCount();
        for(int i = 0;i<childCount;i++){
            SwipeLinearLayout view = (SwipeLinearLayout) mLvTest.getChildAt(i);
            if(view == swipeLinearLayout){
                swipeLinearLayout.autoScroll(direction);
            }else{
                if(direction == SwipeLinearLayout.DIRECTION_EXPAND) {
                    view.autoScroll(SwipeLinearLayout.DIRECTION_SHINK);
                }
            }
        }
    }
}
