package com.introtoandroid.button_counter_mattox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        buttonMinusOne = (Button) findViewById(R.id.buttonMinusOne);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        counterDisplay = (TextView) findViewById(R.id.textView);
    }
}
