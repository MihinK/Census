package com.example.census;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private boolean registered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Starting Census", Toast.LENGTH_LONG).show();

        //Checking Registration
        SharedPreferences sp = getSharedPreferences("MyUserPreferences", Context.MODE_PRIVATE);
        registered = sp.getBoolean("Registered",false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if(registered){
                    intent = new Intent(MainActivity.this, LoginForm.class);
                }else{
                    intent = new Intent(MainActivity.this, RegisterForm.class);
                }
                startActivity(intent);
                finish();
            }
        },4000);
    }
}