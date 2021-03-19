package com.bilalatiq.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activeplayer = 0;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winPos = {{0,1,2} , {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    public  void playerTap (View view){

        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if (gameState [tappedimage] == 2){
            gameState[tappedimage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0){
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
            }
            else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
            }
            img.animate().translationYBy(1000).setDuration(300);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}