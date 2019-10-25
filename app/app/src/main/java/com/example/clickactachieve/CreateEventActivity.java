package com.example.clickactachieve;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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

                try {
                    writeToFile(getEntry());

//                    Log.d("TAG", readFromFile(getApplicationContext()));
                } catch (Exception e) {
                    Log.d("TAG", e.toString());
                }
                navigateToFacilityLanding();
            }
        });
    }

    private void writeToFile(String data) {

    }

    private String getEntry() {
        int nameIndex = 5;
        int eventTypeIndex = 9;
        int locationIndex = 8;
        int descriptionIndex = 7;

        String retval = "";

        for (int i = 0; i < 10; i++) {
            if (i == nameIndex) {
                retval += name.getText().toString();
            } else if (i == eventTypeIndex) {
                retval += eventType.getText().toString();
            } else if (i == locationIndex) {
                retval += location.getText().toString();
            } else if (i == descriptionIndex) {
                retval += description.getText().toString();
            } else {
                retval += " ";
            }
            if (i != 9) {
                retval += "~";
            }
        }
        return retval;
    }

    private void navigateToFacilityLanding() {
        Intent intent = new Intent(this, FacilityLandingActivity.class);;
        startActivity(intent);
    }


}
