package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserRegCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg_complete);

        Button done = findViewById(R.id.userRegCompleteButton);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDone();
            }
        });

        //TO DO: create a new user in the user table?

    }

    public void clickDone() {
        Intent intent = new Intent(this, UserLandingActivity.class);
        startActivity(intent);
    }
}
