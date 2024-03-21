package com.example.census;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterForm extends AppCompatActivity {

    private EditText username,email,password;
    private Button button;
    private SharedPreferences sp;
    private String usernameStr,emailStr,passwordStr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form);

        username = findViewById(R.id.editUsername);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        button = findViewById(R.id.registerButton);

        sp = getSharedPreferences("MyUserPreferences", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameStr = username.getText().toString();
                emailStr = email.getText().toString();
                passwordStr = password.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                if(usernameStr.isEmpty() ){
                    username.setError("Username field can't be empty");
                }else if(emailStr.isEmpty()){
                    email.setError("E mail field can't be empty");
                }else if(passwordStr.isEmpty()) {
                    password.setError("Password field can't be empty");
                }else if(passwordStr.length()<=5){
                    password.setError("Password should be more than 5 characters");
                }else {
                    password.setError(null);
                    editor.putString("username", usernameStr);
                    editor.putString("email", emailStr);
                    editor.putString("password", passwordStr);
                    editor.putBoolean("Registered", true);
                    editor.apply();
                    Toast.makeText(RegisterForm.this, "Registration Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterForm.this, LoginForm.class);
                    startActivity(intent);
                }



            }
        });



    }
}