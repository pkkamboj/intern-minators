package com.example.clickactachieve;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PickDateActivity extends AppCompatActivity {

    //TextView title;
    Button pickDate;
    Calendar calendar;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_date);

        //title = findViewById(R.id.dateTitle);
        pickDate = findViewById(R.id.pickDateButton);

        pickDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                dpd = new DatePickerDialog(PickDateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    //@Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        pickDate.setText(mDay + "/" + mMonth + "/" + mYear);
                    }

                }, day, month, year);

                dpd.show();

                //datePicked();
            }
        });

    }

    public void datePicked() {
        Intent intent = new Intent(this, PickTimeActivity.class);
        startActivity(intent);
    }
}
