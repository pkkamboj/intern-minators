package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {
    String name;
    String location;
    Integer eventType;
    String description;

    TextView nameContents;
    TextView locationContents;
    TextView eventTypeContents;
    TextView descriptionContents;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent intent = getIntent();
        name = intent.getExtras().getString("Name");
        description = intent.getExtras().getString("Description");
        location = intent.getExtras().getString("Location");
        eventType = intent.getExtras().getInt("EventType");

        nameContents = findViewById(R.id.contentsName);
        locationContents = findViewById(R.id.contentsLocation);
        eventTypeContents = findViewById(R.id.contentsEventTypes);
        descriptionContents = findViewById(R.id.contentsDescription);

        nameContents.setText(name);
        locationContents.setText(location);
        eventTypeContents.setText(eventType.toString());
        descriptionContents.setText(description);
    }

    public void onBackBtnClicked(View v) {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }

    public void onBookBtnClicked(View v) {
        Event newEvent = new Event(name, description, location, eventType);
        EventListActivity.booked.add(newEvent);

        Intent intent = new Intent(this, UserLandingActivity.class);
        startActivity(intent);
    }

}
