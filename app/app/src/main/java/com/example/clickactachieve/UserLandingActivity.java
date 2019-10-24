package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserLandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_landing);
    }

    public void clickBookActivity(View v) {
        Intent intent = new Intent(this, BookNowDashBoardActivity.class);
        startActivity(intent);
    }

    public void clickMyBookings(View v) {
        Intent intent = new Intent(this, MyBookingsActivity.class);
        startActivity(intent);
    }
}
