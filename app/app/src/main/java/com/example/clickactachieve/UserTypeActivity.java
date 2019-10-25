package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class UserTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        ImageButton facilityType = findViewById(R.id.facTypeButton);
        ImageButton userType = findViewById(R.id.userTypeButton);

        facilityType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFacilityType();
            }
        });

        userType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickUserType();
            }
        });
        //TO DO: create a new user in the user table?

    }

    public void clickFacilityType() {
        Intent intent = new Intent(this, FacilityInfoActivity.class);
        startActivity(intent);
    }

    public void clickUserType() {
        Intent intent = new Intent(this, UserInfoActivity.class);
        startActivity(intent);
    }

    public void onBackBtnClicked(View v) {
        finish();
    }
}
