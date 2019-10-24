package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateEventActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText dateOfBirth;
    EditText time;
    EditText location;
    EditText eventType;
    Button buttonSubmit;
    Button buttonCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        dateOfBirth = findViewById(R.id.editDateOfBirth);
        time = findViewById(R.id.editTime);
        location = findViewById(R.id.editLocation);
        eventType = findViewById(R.id.editEventType);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFacilityLanding();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigateToFacilityLanding();
            }
        });
    }

    private void navigateToFacilityLanding() {
        Intent intent = new Intent(this, FacilityLandingActivity.class);;
        startActivity(intent);
    }


}
