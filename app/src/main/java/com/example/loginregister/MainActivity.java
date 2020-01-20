package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity{
    private EditText loginemailtxt,loginpasstxt;
    private Button loginbtn;
    private TextView registertxt;
    private ProgressBar loginprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("LOG IN");

        loginemailtxt=findViewById(R.id.loginemailtxt);
        loginpasstxt=findViewById(R.id.loginpasstxt);
        loginbtn=findViewById(R.id.loginbtn);
        registertxt=findViewById(R.id.registertxt);
        loginprogressBar=findViewById(R.id.loginprogressBar);

        loginbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        registertxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
