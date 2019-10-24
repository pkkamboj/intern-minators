package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyBookingsActivity extends AppCompatActivity {

    Button bookActivity;
    Button existingBookings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        bookActivity = findViewById(R.id.bookActivityButton);
        existingBookings = findViewById(R.id.viewBookingsButton);

        bookActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBookActivity();
            }
        });

        existingBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMyBookings();
            }
        });
    }

    public void clickBookActivity() {
        Intent intent = new Intent(this, BookNowDashBoardActivity.class);
        startActivity(intent);
    }

    public void clickMyBookings() {
        Intent intent = new Intent(this, MyBookingsActivity.class);
        startActivity(intent);
    }
}
