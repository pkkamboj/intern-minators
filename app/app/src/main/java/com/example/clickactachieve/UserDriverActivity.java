package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserDriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_driver);

        Button yes = findViewById(R.id.userDriverYes);
        Button no = findViewById(R.id.userDriverNo);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickYes();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNo();
            }
        });

        //TO DO: create a new user in the user table?

    }

    public void clickYes() {
        Intent intent = new Intent(this, UserVehicleActivity.class);
        startActivity(intent);
    }

    public void clickNo() {
        Intent intent = new Intent(this, UserRegCompleteActivity.class);
        startActivity(intent);
    }
}
