package com.example.clickactachieve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BUTTON_LOGIN;
    Button BUTTON_CREATE_ACCOUNT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BUTTON_LOGIN = findViewById(R.id.loginButton);
        BUTTON_CREATE_ACCOUNT = findViewById(R.id.newUserButton);


        BUTTON_LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });

        BUTTON_CREATE_ACCOUNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAccountPage();
            }
        });
    }

    public void openLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openNewAccountPage() {
        Intent intent = new Intent(this, UserTypeActivity.class);
        startActivity(intent);
    }
}
