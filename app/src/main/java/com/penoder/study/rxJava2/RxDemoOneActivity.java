package com.penoder.study.rxJava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.penoder.study.R;

public class RxDemoOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_demo_one);
    }

    public void onRxDemoOne_A(View view) {
        RxDemo_1 rxDemo1 = new RxDemo_1();
    }
}
