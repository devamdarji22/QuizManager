package com.jadd.quizmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class SignUpActivity extends AppCompatActivity {

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

        signUpButton.setOnClickListener(view -> {
            name = nameField.getText().toString();
            password = passwordField.getText().toString();
            email = emailField.getText().toString();
            host = new Host(email,name);
            auth.createUserWithEmailAndPassword(host.geteMail(),password)
                    .addOnCompleteListener(SignUpActivity.this, task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Ok", Toast.LENGTH_SHORT).show();


                        }
                        else {
                            // If sign in fails, display a message to the user.

                        }
                    });
        });

    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();

    }

}