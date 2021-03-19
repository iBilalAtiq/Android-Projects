package com.bilalatiq.recvieweg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String arr[] = {"HONDA", "BMW", "Mercedes", "Ferrari", "Tesla", "HONDA", "BMW", "Mercedes", "Ferrari", "Tesla"};
        recyclerView.setAdapter(new myAdapter(arr));
    }
}