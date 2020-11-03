package com.jadd.quizmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nameField,emailField,passwordField;
    String name,email,password;
    Button signUpButton;
    Host host;
    FirebaseAuth auth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        nameField = findViewById(R.id.host_name_signup);
        emailField = findViewById(R.id.host_email_signup);
        passwordField = findViewById(R.id.host_password_signup);

        signUpButton = findViewById(R.id.sign_up_activity_button);

        signUpButton.setOnClickListener(this::onClick);

    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_up_activity_button:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        name = nameField.getText().toString();
        password = passwordField.getText().toString();
        email = emailField.getText().toString();
        if(name.isEmpty()){
            nameField.setError("Name cannot be empty!");
            nameField.requestFocus();
            return;
        }
        if(email.isEmpty()){
            emailField.setError("Email cannot be empty!");
            emailField.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailField.setError("Please enter valid Email!");
            emailField.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passwordField.setError("Please enter Password!");
            passwordField.requestFocus();
            return;
        }


        Toast.makeText(this, "In onClick", Toast.LENGTH_SHORT).show();
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Ok", Toast.LENGTH_SHORT).show();


                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUpActivity.this, "Sign up failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



}