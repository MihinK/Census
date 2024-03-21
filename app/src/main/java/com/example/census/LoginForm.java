package com.example.census;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginForm extends AppCompatActivity {

    private EditText username2;
    private EditText password2;
    private Button button;
    private String usernameStr,passwordStr;
    private int errorCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        button = findViewById(R.id.loginButton);


    }

    public void onButtonClick (View view){
        password2 = findViewById(R.id.editPassword2);
        SharedPreferences sp = getSharedPreferences("MyUserPreferences", MODE_PRIVATE);
        passwordStr = sp.getString("password", "");

        if (passwordStr.equals(password2.getText().toString())) {
            Intent intent = new Intent(LoginForm.this, HomePage.class);
            startActivity(intent);
            finish();
        } else {
            password2.setError("Wrong password");
            errorCount++;
            if (errorCount >= 3) {
                Context context = getApplicationContext();
                CharSequence text = "Wrong password, Closing App";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                LoginForm.this.finish();
                System.exit(0);
            }
        }
    }


}

