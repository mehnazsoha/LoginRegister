package com.example.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity{
    private EditText regemailtxt,regpasstxt;
    private Button registerbtn;
    private TextView logintxt;
    private ProgressBar regprogressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("REGISTER");

        regemailtxt=findViewById(R.id.regemailtxt);
        regpasstxt=findViewById(R.id.regpasstxt);
        registerbtn=findViewById(R.id.registerbtn);
        logintxt=findViewById(R.id.logintxt);
        regprogressBar=findViewById(R.id.regprogressBar);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = regemailtxt.getText().toString().trim();
                String pass = regpasstxt.getText().toString().trim();

                //checking the validity of the email
                if (email.isEmpty()) {
                    regemailtxt.setError("Enter an email address");
                    regemailtxt.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {   //jodi email address match na hoy, @ na deya hoy
                    regemailtxt.setError("Enter a valid email address");
                    regemailtxt.requestFocus();
                    return;
                }
                //checking the validity of the email

                //checking the validity of the password
                if (pass.isEmpty()) {
                    regpasstxt.setError("Enter a password");
                    regpasstxt.requestFocus();
                    return;
                }

                if (pass.length() < 6) {
                    regpasstxt.setError("Enter at least 6 characters");
                    regpasstxt.requestFocus();
                    return;
                }
                //checking the validity of the password

                regprogressBar.setVisibility(View.VISIBLE);

                //signup for new user
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        regprogressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //signup for new usew
            }
        });

        logintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
