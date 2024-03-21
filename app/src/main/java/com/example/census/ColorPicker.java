package com.example.census;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import yuku.ambilwarna.AmbilWarnaDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ColorPicker extends AppCompatActivity {

    ConstraintLayout myLayout;
    int myDefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        openColorPicker();

        myLayout = findViewById(R.id.layoutColor);
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPref",MODE_PRIVATE);
        myDefaultColor = sharedPreferences.getInt("color",0);
        if (myDefaultColor ==0)
            myDefaultColor = ContextCompat.getColor(ColorPicker.this ,R.color.white);

        myLayout.setBackgroundColor(myDefaultColor);
    }

    public void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, myDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Intent intent = new Intent(ColorPicker.this,HomePage.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                myDefaultColor = color;
                myLayout.setBackgroundColor(myDefaultColor);
                SharedPreferences sharedPreferences = getSharedPreferences("MyUserPreferences",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("color",myDefaultColor);
                editor.apply();
                Intent intent = new Intent(ColorPicker.this,HomePage.class);
                startActivity(intent);
                finish();
            }
        });
        colorPicker.show();
    }
}