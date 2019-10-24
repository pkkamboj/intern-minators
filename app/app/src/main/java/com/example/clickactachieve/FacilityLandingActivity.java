package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FacilityLandingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_landing);
    }

    public void clickCreateActivity(View v) {
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }

    public void clickMyEvents(View v) {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }

}
