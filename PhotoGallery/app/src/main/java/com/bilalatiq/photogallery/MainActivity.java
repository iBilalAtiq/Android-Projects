package com.bilalatiq.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    int flag = 0;
    ImageView img;
    public void changePicture(View view){

        img = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.nextButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag == 0) {
                    img.setImageResource(R.drawable.a);
                    flag = 1;
                } else if (flag == 1) {
                    img.setImageResource(R.drawable.b);
                    flag = 2;
                } else if (flag == 2) {
                    img.setImageResource(R.drawable.c);
                    flag = 3;
                } else if (flag == 3) {
                    img.setImageResource(R.drawable.d);
                    flag = 4;
                } else if (flag == 4){
                    img.setImageResource(R.drawable.e);
                    flag =0;
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}