package com.introtoandroid.button_counter_mattox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int counterVar = 0;
    Button buttonPlusOne;
    Button buttonMinusOne;
    Button buttonReset;
    TextView counterDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPlusOne = (Button) findViewById(R.id.buttonPlusOne);
        buttonPlusOne.setOnClickListener(this);
        buttonMinusOne = (Button) findViewById(R.id.buttonMinusOne);
        buttonMinusOne.setOnClickListener(this);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);
        counterDisplay = (TextView) findViewById(R.id.textView);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.buttonPlusOne){
            counterVar++;
            counterDisplay.setText(Integer.toString(counterVar));
        }
        else if(v.getId() == R.id.buttonMinusOne){
            counterVar = counterVar - 1;
            counterDisplay.setText(Integer.toString(counterVar));
        }
        else if(v.getId() == R.id.buttonReset){
            counterVar = 0;
            counterDisplay.setText(Integer.toString(counterVar));
        }

    }

}
