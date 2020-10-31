package com.jadd.quizmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    EditText nameField,emailField,passwordField;
    String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameField = findViewById(R.id.host_name_signup);
        emailField = findViewById(R.id.host_email_signup);
        passwordField = findViewById(R.id.host_password_signup);
        
    }
}