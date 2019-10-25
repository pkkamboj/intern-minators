package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FacilityInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_info);

        Button next = findViewById(R.id.facInfoButton);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDone();
            }
        });

        //TO DO: create a new user in the user table?

    }

    public void clickDone() {
        Intent intent = new Intent(this, FacRegCompleteActivity.class);
        startActivity(intent);
    }
}
