package com.penoder.study.kotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.penoder.study.R;

public class KotlinGrammarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotlin_grammar);
    }

    public void onKotlinDemoOne_A(View view) {
        KotlinDemo_1 kotlinDemo_1 = new KotlinDemo_1();
        kotlinDemo_1.methodTwo("2333333333333");
        kotlinDemo_1.update();
    }
}
