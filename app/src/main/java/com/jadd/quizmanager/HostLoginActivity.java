package com.jadd.quizmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HostLoginActivity extends AppCompatActivity {
    EditText emailField,passwordField;
    String email,password;
    Button loginButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_login);
        emailField = findViewById(R.id.email_input);
        passwordField = findViewById(R.id.password_input);
        email = emailField.getText().toString();
        password = passwordField.getText().toString();
        loginButton = findViewById(R.id.login_button);
        signUpButton = findViewById(R.id.sign_up_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HostLoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });

    }
}