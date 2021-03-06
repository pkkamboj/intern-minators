package com.example.clickactachieve;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;


public class PickTimeActivity extends AppCompatActivity {
    Button done;
    Button pickTime;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        pickTime = findViewById(R.id.pickTimeButton);
        done = findViewById(R.id.doneButton);
        done.setVisibility(View.GONE);
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {

                timePickerDialog = new TimePickerDialog(PickTimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        pickTime.setText(hourOfDay + ":" + minute);
                    }
                }, 0, 0, false);

                timePickerDialog.show();
                done.setVisibility(View.VISIBLE);
            }

        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicked();
            }
        });
    }

    public void timePicked() {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }

}
