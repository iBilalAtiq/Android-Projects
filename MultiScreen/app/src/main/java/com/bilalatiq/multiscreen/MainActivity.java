package com.bilalatiq.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String order = "com.bilalatiq.multiscreen.order";
    public void PlaceOrder (View view){

        Intent intent = new Intent(this, OrderActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.editTextItem1);
        EditText editText2 = (EditText) findViewById(R.id.editTextItem2);
        EditText editText3 = (EditText) findViewById(R.id.editTextItem3);
        String message = "Your order " + editText1.getText().toString() + " , " + editText2.getText().toString() + " & " + editText3.getText().toString() + " has been placed !!";
        intent.putExtra(order, message);
        startActivity(intent);
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}