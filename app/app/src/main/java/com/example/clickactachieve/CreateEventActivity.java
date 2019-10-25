package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateEventActivity extends AppCompatActivity {
    EditText name;
    EditText eventType;
    EditText location;
    EditText description;
    Button buttonSubmit;
    Button buttonCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        name = findViewById(R.id.editEventName);
        eventType = findViewById(R.id.editEventType);
        location = findViewById(R.id.editLocation);
        description = findViewById(R.id.editDescription);
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

                addEventToList();
                navigateToFacilityLanding();
            }
        });
    }

    private void addEventToList() {
        Event newEvent = new Event(name.getText().toString(), description.getText().toString(),
                location.getText().toString(), Integer.parseInt(eventType.getText().toString()));

        EventListActivity.events.add(newEvent);
    }

    private void navigateToFacilityLanding() {
        Intent intent = new Intent(this, FacilityLandingActivity.class);;
        startActivity(intent);
    }
}
