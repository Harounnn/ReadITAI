package com.example.readitai;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        EditText email = (EditText) findViewById(R.id.username);
        String emailText = String.valueOf(email.getText());

        EditText password = (EditText) findViewById(R.id.password);
        String passwordText = String.valueOf(password.getText());
    }
}
