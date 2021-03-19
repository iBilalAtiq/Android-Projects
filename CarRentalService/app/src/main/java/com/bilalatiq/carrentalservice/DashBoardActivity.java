package com.bilalatiq.carrentalservice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DashBoardActivity extends AppCompatActivity {

    TextInputLayout con_name, con_phNo, con_address;
    Button con_save;
    TextView textView;
    ImageView img;

    public static final String TEXT = "com.bilalatiq.carrentalservice.TEXT";

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONENO = "phNo";
    private static final String KEY_ADDRESS = "address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dash_board);

        Intent intent = getIntent();
        String text = intent.getStringExtra(LoginActivity.EXTRA_TEXT);
        textView = (TextView) findViewById(R.id.textViewDash);
        textView.setText("Hello " + text);

        con_name = findViewById(R.id.contact_name);
        con_phNo = findViewById(R.id.contact_phoneNumber);
        con_save = findViewById(R.id.save_btn);
        con_address = findViewById(R.id.contact_address);
        img = findViewById(R.id.dash_img);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askCameraPermission();
            }
        });

        String name = sharedPreferences.getString(KEY_NAME, null);
        if (name != null) {
            Intent itent = new Intent(this, ContactInfoActivity.class);
            startActivity(itent);
            finish();
        }

        con_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, con_name.getEditText().getText().toString().trim());
                editor.putString(KEY_PHONENO, con_phNo.getEditText().getText().toString().trim());
                editor.putString(KEY_ADDRESS, con_address.getEditText().getText().toString().trim());
                editor.apply();
                Intent intent = new Intent(DashBoardActivity.this, ContactInfoActivity.class);
                startActivity(intent);
                //ContactInfo();
            }
        });
    }

    public void ContactInfo() {
        String utext = textView.getEditableText().toString().trim();
        Intent intente = new Intent(this, ContactInfoActivity.class);
        intente.putExtra(TEXT, utext);
        startActivity(intente);
    }

    private void askCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
        } else {
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 101){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera();
            } else {
                Toast.makeText(this, "Camera Permissions Requires to Use Camera.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 102);
        Toast.makeText(this, "Camera Open Request", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(photo);
        }
    }
}