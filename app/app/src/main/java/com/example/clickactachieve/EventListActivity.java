package com.example.clickactachieve;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
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
        events.add(new Event("Cooking", "Cooking", "Kitchener", 2));
        events.add(new Event("Cooking", "Cooking", "Kitchener", 2));
        String fileName = "C:\\Polarisfest\\ClickActAchieve\\intern-minators\\app\\app\\src\\main\\res\\fakedata.txt";
        try{
            FileReader f = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(f);
            String s;
            boolean eof = false;
            while(!eof){
                s = buff.readLine();
                if(s == null){
                    eof = true;
                }
                else{
                    String [] splitArray = s.split("~");
                    String name = splitArray[5];
                    String location = splitArray[9];//fix
                    String description = splitArray[7];
                    int eventType = Integer.parseInt(splitArray[10]);//fix
                    events.add(new Event(name,location,description,eventType));
                }
            }
        }
        catch(Exception e){
            Log.e(TAG, e.toString() + (new File(".").getAbsolutePath()));
        }


        RecyclerView rvEvents = findViewById(R.id.recycler_event_list);
        EventAdapter adapter = new EventAdapter(events);
        rvEvents.setAdapter(adapter);

        rvEvents.setLayoutManager(new LinearLayoutManager(this));


    }

    public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
        private ArrayList<Event> dataset;

        public EventAdapter(ArrayList<Event> list){
            dataset = list;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public View view;


            String name;
            String location;
            String description;
            int eventType;

            public ViewHolder(View view) {
                super(view);
                this.view = view;
                this.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EventListActivity.this, LoginActivity.class);
                        //add extra to bundle with event
                        startActivity(intent);
                    }
                });
            }
        }

        @Override
        public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            ((TextView) holder.view.findViewById(R.id.text_event_location)).setText(dataset.get(position).getLocation());
            ((TextView) holder.view.findViewById(R.id.text_event_name)).setText(dataset.get(position).getName());
            //set the fields in holder
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return dataset.size();
        }
    }
}
