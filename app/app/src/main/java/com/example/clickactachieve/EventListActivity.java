package com.example.clickactachieve;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        ArrayList<Event> events = new ArrayList<Event>();

        RecyclerView rvEvents = (RecyclerView) findViewById(R.id.recycler_event_list);
        EventAdapter adapter = new EventAdapter(events);
    }
}
