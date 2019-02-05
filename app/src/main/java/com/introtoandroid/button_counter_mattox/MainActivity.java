package com.introtoandroid.button_counter_mattox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private int counterVar;
    private Button buttonPlusOne;
    private Button buttonMinusOne;
    private Button buttonReset;
    private TextView counterDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlusOne = (Button) findViewById(R.id.buttonPlusOne);
        buttonMinusOne = (Button) findViewById(R.id.buttonMinusOne);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        counterDisplay = (TextView) findViewById(R.id.textView);

        //can create setOnClickListener either way
        //buttonPlusOne.setOnClickListener(this);
        buttonPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVar++;
                counterDisplay.setText(Integer.toString(counterVar));
            }
        });

        //can create setOnClickListener either way
        //buttonMinusOne.setOnClickListener(this);
        buttonMinusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVar = counterVar - 1;
                counterDisplay.setText(Integer.toString(counterVar));
            }
        });

        //can create setOnClickListener either way
        //buttonReset.setOnClickListener(this);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVar = 0;
                counterDisplay.setText(Integer.toString(counterVar));
            }
        });
    }
    //if implementing View.setOnClickListener then you need to define onClick as below
//
//    @Override
//    public void onClick(View v) {
//
//        if(v.getId() == R.id.buttonPlusOne){
//            counterVar++;
//            counterDisplay.setText(Integer.toString(counterVar));
//        }
//        else if(v.getId() == R.id.buttonMinusOne){
//            counterVar = counterVar - 1;
//            counterDisplay.setText(Integer.toString(counterVar));
//        }
//        else if(v.getId() == R.id.buttonReset){
//            counterVar = 0;
//            counterDisplay.setText(Integer.toString(counterVar));
//        }
//
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("counter", counterDisplay.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counterVar = Integer.parseInt(savedInstanceState.getString("counter"));
        counterDisplay.setText(Integer.toString(counterVar));
    }
}
