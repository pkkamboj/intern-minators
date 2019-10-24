package com.example.clickactachieve;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    private static final String TAG = "EventListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        ArrayList<Event> events = new ArrayList<Event>();
        String fileName = "/app/src/main/res/fakedata.txt";
        try{
            FileReader f = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(f);
            String s;
            boolean eof = false;
            while(eof){
                s = buff.readLine();
                if(s == null){
                    eof = true;
                }
                else{
                    String [] splitArray = s.split("~");
                    String name = splitArray[4];
                    String location = splitArray[6];
                    String description = splitArray[7];
                    int eventType = Integer.parseInt(splitArray[8]);
                    events.add(new Event(name,location,description,eventType));
                }
            }
        }
        catch(Exception e){
            Log.e(TAG, e.toString());
        }


        RecyclerView rvEvents = findViewById(R.id.recycler_event_list);
        EventAdapter adapter = new EventAdapter(events);
        rvEvents.setAdapter(adapter);

        rvEvents.setLayoutManager(new LinearLayoutManager(this));


    }
}
