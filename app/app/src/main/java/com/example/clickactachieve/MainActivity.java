package com.example.clickactachieve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final Button BUTTON_LOGIN = findViewById(R.id.loginButton);
    final Button BUTTON_CREATE_ACCOUNT = findViewById(R.id.newAccountButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }
}
