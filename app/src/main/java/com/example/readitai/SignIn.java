package com.example.readitai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        FirebaseAuth mAuth;

        mAuth = FirebaseAuth.getInstance();

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = (EditText) findViewById(R.id.username);
                String emailText = String.valueOf(email.getText());

                EditText password = (EditText) findViewById(R.id.password);
                String passwordText = String.valueOf(password.getText());

                Validator validator = new Validator();

                if(validator.isValidEmail(emailText) && validator.isValidPassword(passwordText)){
                    mAuth.signInWithEmailAndPassword(emailText, passwordText)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                                        intent.putExtra("email", emailText);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignIn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(SignIn.this, "Not Valid Input", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}
