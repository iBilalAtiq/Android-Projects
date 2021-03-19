package com.bilalatiq.carrentalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ContactInfoActivity extends AppCompatActivity {

    TextView info_name, info_phoneNo, info_address;
    Button con_logout;
    TextView textView;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONENO = "phNo";
    private static final String KEY_ADDRESS = "address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        info_name = findViewById(R.id.coninfo_name);
        info_phoneNo = findViewById(R.id.coninfo_phoneNo);
        info_address = findViewById(R.id.coninfo_address);
        con_logout = findViewById(R.id.logout_btn);

        Intent intent = getIntent();
        String texte = intent.getStringExtra(DashBoardActivity.TEXT);
        textView = (TextView) findViewById(R.id.textViewCon);
        textView.setText("Hello Bilal");

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        String phoneNo = sharedPreferences.getString(KEY_PHONENO, null);
        String address = sharedPreferences.getString(KEY_ADDRESS, null);

        if (name != null || phoneNo != null || address != null){
            info_name.setText("Your Name: " +name);
            info_phoneNo.setText("Your Phone Number: " +phoneNo);
            info_address.setText("Your Address: " +address);
        }

        con_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myPrefs = getSharedPreferences("MY", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(ContactInfoActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                Toast.makeText(ContactInfoActivity.this, "Logout successfully !!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}