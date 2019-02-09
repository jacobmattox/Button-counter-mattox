package com.introtoandroid.button_counter_mattox;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity{

    private int counterVar;
    private Button buttonPlusOne;
    private Button buttonMinusOne;
    private Button buttonReset;
    private TextView counterDisplay;
    private LinearLayout linearLayout;
    private String currBackgroundColor;
    private String currNumberColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlusOne = (Button) findViewById(R.id.buttonPlusOne);
        buttonMinusOne = (Button) findViewById(R.id.buttonMinusOne);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        counterDisplay = (TextView) findViewById(R.id.textView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);


        //can create setOnClickListener either way
        //buttonPlusOne.setOnClickListener(this);
        buttonPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVar++;
                counterDisplay.setText(Integer.toString(counterVar));
                currNumberColor = newColorString(counterVar);
                counterDisplay.setTextColor(Color.parseColor(currNumberColor));
                currBackgroundColor = newColorString(counterVar -1);
                linearLayout.setBackgroundColor(Color.parseColor((currBackgroundColor)));

            }
        });

        //can create setOnClickListener either way
        //buttonMinusOne.setOnClickListener(this);
        buttonMinusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVar = counterVar - 1;
                counterDisplay.setText(Integer.toString(counterVar));
                currNumberColor = newColorString(counterVar);
                counterDisplay.setTextColor(Color.parseColor(currNumberColor));
                currBackgroundColor = newColorString(counterVar -1);
                linearLayout.setBackgroundColor(Color.parseColor((currBackgroundColor)));
            }
        });

        //can create setOnClickListener either way
        //buttonReset.setOnClickListener(this);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterVar = 0;
                counterDisplay.setText(Integer.toString(counterVar));
                currNumberColor = "Black";
                counterDisplay.setTextColor(Color.parseColor(currNumberColor));
                currBackgroundColor = "White";
                linearLayout.setBackgroundColor(Color.parseColor(currBackgroundColor));
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
        outState.putString("background", currBackgroundColor);
        outState.putString("numberColor", currNumberColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counterVar = Integer.parseInt(savedInstanceState.getString("counter"));
        currNumberColor = savedInstanceState.getString("numberColor");
        currBackgroundColor = savedInstanceState.getString("background");
        counterDisplay.setText(Integer.toString(counterVar));
        linearLayout.setBackgroundColor(Color.parseColor(currBackgroundColor));
        counterDisplay.setTextColor(Color.parseColor(currNumberColor));

    }
    public String newColorString(double counter){
        //takes counter and mods it into a new color
        String[] colors = {"Black", "White", "Blue", "Red"};

        return colors[(int)Math.sqrt((counter * counter)) % 4];

    }
}
