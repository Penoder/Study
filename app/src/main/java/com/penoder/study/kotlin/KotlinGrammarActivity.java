package com.penoder.study.kotlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import com.penoder.study.R;

public class KotlinGrammarActivity extends AppCompatActivity {

    private ScrollView svKotlinDemoOne;
    private EditText edKotlinDemoOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotlin_grammar);

        svKotlinDemoOne = (ScrollView) findViewById(R.id.sv_kotlinDemoOne);
        edKotlinDemoOne = (EditText) findViewById(R.id.ed_kotlinDemoOne);

        // 避免 EditText 中内容可以滑动时，与 外层嵌套的 ScrollView 的滑动冲突
        edKotlinDemoOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    edKotlinDemoOne.getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    edKotlinDemoOne.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
    }

    public void onKotlinDemoOne_A(View view) {
        KotlinDemo_1 kotlinDemo_1 = new KotlinDemo_1(2);
        kotlinDemo_1.methodTwo("2333333333333");
        kotlinDemo_1.update();
        Log.i("KotlinGrammarActivity", "onKotlinDemoOne_A: --------- " + kotlinDemo_1.maxValue(6, 8));
    }

    public void onElvisClick(View v) {
        KotlinDemo_2_AboutNPE npe = new KotlinDemo_2_AboutNPE();
    }
}
