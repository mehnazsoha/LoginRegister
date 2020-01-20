package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity{
    private EditText regemailtxt,regpasstxt;
    private Button registerbtn;
    private TextView logintxt;
    private ProgressBar regprogressBar;

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

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = regemailtxt.getText().toString().trim();
                String pass = regpasstxt.getText().toString().trim();

                //checking the validity of the email
                if(email.isEmpty()) {
                    regemailtxt.setError("Enter an email address");
                    regemailtxt.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {   //jodi email address match na hoy, @ na deya hoy
                    regemailtxt.setError("Enter a valid email address");
                    regemailtxt.requestFocus();
                    return;
                }
                //checking the validity of the email

                //checking the validity of the password
                if(pass.isEmpty()) {
                    regpasstxt.setError("Enter a password");
                    regpasstxt.requestFocus();
                    return;
                }

                if(pass.length()<6){
                    regpasstxt.setError("Enter at least 6 characters");
                    regpasstxt.requestFocus();
                    return;
                }
                //checking the validity of the password
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
