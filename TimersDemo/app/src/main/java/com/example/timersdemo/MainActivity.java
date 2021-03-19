package com.example.timersdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000){

            public void onTick(long millisecuntildone){
                Log.i("Seconds Left", String.valueOf(millisecuntildone / 1000));
            }
            public void onFinish(){
                Log.i("We are done", "No more countdown");
            }
        } .start();



        /*final Handler handler = new Handler();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey it's Us", "Second Passed");

                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run); */
   }
}