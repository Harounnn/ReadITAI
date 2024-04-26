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

public class SignUp extends AppCompatActivity {

    FirebaseAuth mAuth;
    Validator validator = new Validator();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        mAuth = FirebaseAuth.getInstance();

        Button signUpButton = (Button) findViewById(R.id.SignUpButtonTwo);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = (EditText) findViewById(R.id.usernamesu);
                String emailText = String.valueOf(email.getText());

                EditText password = (EditText) findViewById(R.id.passwordsu);
                String passwordText = String.valueOf(password.getText());

                EditText passwordAgain = (EditText) findViewById(R.id.passwordAgain);
                String passwordAgainText = String.valueOf(passwordAgain.getText());

                if(validator.isValidEmail(emailText) && validator.isValidPassword(passwordText) && passwordText.equals(passwordAgainText)){
                    mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        email.setText("");
                                        password.setText("");
                                        passwordAgain.setText("");
                                        Intent intent = new Intent(SignUp.this, SignIn.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignUp.this, "You have an Account", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}
