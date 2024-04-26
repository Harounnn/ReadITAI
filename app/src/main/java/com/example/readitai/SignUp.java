package com.example.readitai;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        mAuth = FirebaseAuth.getInstance();

        EditText email = (EditText) findViewById(R.id.usernamesu);
        String usernameText = String.valueOf(email.getText());

        EditText password = (EditText) findViewById(R.id.passwordsu);
        String passwordText = String.valueOf(password.getText());

        EditText passwordAgain = (EditText) findViewById(R.id.passwordAgain);
        String passwordAgainText = String.valueOf(passwordAgain.getText());
    }

}
