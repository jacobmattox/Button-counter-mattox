package com.introtoandroid.button_counter_mattox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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
        buttonPlusOne.setOnClickListener(this);
        buttonMinusOne = (Button) findViewById(R.id.buttonMinusOne);
        buttonMinusOne.setOnClickListener(this);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);
        counterDisplay = findViewById(R.id.textView);
        counterVar = Integer.parseInt(counterDisplay.getText().toString());


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
