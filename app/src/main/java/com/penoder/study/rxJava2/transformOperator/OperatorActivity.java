package com.penoder.study.rxJava2.transformOperator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.penoder.study.R;

public class OperatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMapOperatorOne;
    private Button btnMapOperatorTwo;
    private Button btnMapOperatorThree;
    private Button btnMapOperatorFour;
    private Button btnMapOperatorFive;
    private Button btnMapOperatorSix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);

        btnMapOperatorOne = (Button) findViewById(R.id.btnMapOperatorOne);
        btnMapOperatorTwo = (Button) findViewById(R.id.btnMapOperatorTwo);
        btnMapOperatorThree = (Button) findViewById(R.id.btnMapOperatorThree);
        btnMapOperatorFour = (Button) findViewById(R.id.btnMapOperatorFour);
        btnMapOperatorFive = (Button) findViewById(R.id.btnMapOperatorFive);
        btnMapOperatorSix = (Button) findViewById(R.id.btnMapOperatorSix);
        btnMapOperatorOne.setOnClickListener(this);
        btnMapOperatorTwo.setOnClickListener(this);
        btnMapOperatorThree.setOnClickListener(this);
        btnMapOperatorFour.setOnClickListener(this);
        btnMapOperatorFive.setOnClickListener(this);
        btnMapOperatorSix.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMapOperatorOne:
                MapOperator mapOperator = new MapOperator();
                mapOperator.methodOne();
                break;
            case R.id.btnMapOperatorTwo:
                FlatMapOperator flatMapOperator = new FlatMapOperator();
                flatMapOperator.method();
                break;
            case R.id.btnMapOperatorThree:
                break;
            case R.id.btnMapOperatorFour:
                break;
            case R.id.btnMapOperatorFive:
                break;
            case R.id.btnMapOperatorSix:
                break;
        }
    }
}
