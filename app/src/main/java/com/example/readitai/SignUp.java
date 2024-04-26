package com.example.readitai;

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

        EditText email = (EditText) findViewById(R.id.usernamesu);
        String emailText = String.valueOf(email.getText());

        EditText password = (EditText) findViewById(R.id.passwordsu);
        String passwordText = String.valueOf(password.getText());

        EditText passwordAgain = (EditText) findViewById(R.id.passwordAgain);
        String passwordAgainText = String.valueOf(passwordAgain.getText());

        Button signUpButton = (Button) findViewById(R.id.signUpButtonTwo);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validator.isValidEmail(emailText) && validator.isValidPassword(passwordText) && passwordText == passwordAgainText){
                    mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                    } else {
                                        Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

}
