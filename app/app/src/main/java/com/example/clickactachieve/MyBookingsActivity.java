package com.example.clickactachieve;

import android.os.Bundle;
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

            }
        });

        existingBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAccountPage();
            }
        });


    }
}
