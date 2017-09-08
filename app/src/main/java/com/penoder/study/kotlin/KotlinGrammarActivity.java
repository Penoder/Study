package com.penoder.study.kotlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import com.penoder.study.R;
import com.penoder.study.kotlin.intelligentTransformation.AsOrMayBeNull;
import com.penoder.study.kotlin.loop.ForLoop;
import com.penoder.study.kotlin.loop.WhenLoop;
import com.penoder.study.kotlin.program_1.KotlinDemo_1;

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

    public void onKotlinNpeClick(View view) {

    }

    public void onElvisClick(View view) {
        KotlinDemo_2_AboutNPE npe = new KotlinDemo_2_AboutNPE();
//        Log.i("KotlinGrammarActivity", "onElvisClick: " + npe.elvisMethod(null));
        Log.i("KotlinGrammarActivity", "onElvisClick: " + npe.elvisMethod("no-null "));
        Log.i("KotlinGrammarActivity", "onElvisClick: " + npe.elvisMethod(null, 0));
//        Log.i("KotlinGrammarActivity", "onElvisClick: " + npe.elvisMethod2(null, false));
    }

    public void onLoopClick(View view) {
        ForLoop forLoop = new ForLoop();
        WhenLoop whenLoop = new WhenLoop(1);
        Log.i("KotlinGrammarActivity", "onLoopClick: -----00000------   " +  whenLoop.methodOne(1));
        Log.i("KotlinGrammarActivity", "onLoopClick: -----11111------   " +  whenLoop.methodOne(2));
        Log.i("KotlinGrammarActivity", "onLoopClick: -----22222------   " +  whenLoop.methodOne(3));
        Log.i("KotlinGrammarActivity", "onLoopClick: -----33333------   " +  whenLoop.methodOne(4));
        Log.i("KotlinGrammarActivity", "onLoopClick: -----44444------   " +  whenLoop.methodOne(-1));
        Log.i("KotlinGrammarActivity", "onLoopClick: -----55555------   " +  whenLoop.methodOne(666));
    }

    /**
     * 关于 Kotlin 的 is，as 关键字的对象类型之间的转换
     * @param view
     */
    public void onTransferClick(View view) {
        AsOrMayBeNull asOrMayBeNull = new AsOrMayBeNull();
        Log.i("KotlinGrammarActivity", "onTransferClick: ------    " + asOrMayBeNull.methodOne("233333"));
        Log.i("KotlinGrammarActivity", "onTransferClick: ------    " + asOrMayBeNull.methodOne("中文看你怎么转换成数字"));
    }
}
