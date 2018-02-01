package com.vmust.biggernumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int rand1;
    private int rand2;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //when app loads up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = 0;
        pickRandomNumbers();
    }

    private void pickRandomNumbers() {
        //picks random numbers
        Random nums = new Random();
        rand1 = nums.nextInt(10);
        while(true) {
            rand2 = nums.nextInt(10);
            if (rand2 != rand1) {
                break;
            }
        }

        Button lbut = (Button) findViewById(R.id.left_button);
        lbut.setText(Integer.toString(rand1));
        Button rbut = (Button) findViewById(R.id.right_button);
        rbut.setText(Integer.toString(rand2));
    }

    public void leftButtonClick(View view) {
        if(rand1 > rand2) {
            //correct
            points++;
        }
        else {
            //incorrect
            points--;
        }

        //update display of points
        TextView tv = (TextView) findViewById(R.id.points_field);
        tv.setText("Points: " + points);

        pickRandomNumbers();

    }

    public void rightButtonClick(View view) {
        if(rand2 > rand1) {
            //correct
            points++;
        }
        else {
            //incorrect
            points--;
        }

        //update display of points
        TextView tv = (TextView) findViewById(R.id.points_field);
        tv.setText("Points: " + points);

        pickRandomNumbers();
    }
}
