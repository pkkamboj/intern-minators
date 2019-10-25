package com.example.clickactachieve;

import android.content.Intent;
import android.content.res.AssetManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    public static ArrayList<Event> events = new ArrayList<Event>();
    public static ArrayList<Event> booked = new ArrayList<Event>();
    public static boolean init = false;

    public void initArray(){
        if(!init){
            events.add(new Event("Meditate and Relax", "Meditate with others around you!connecting your own mind can benefit you physically and mentally. Come join us on October 28, 2019 at Meditate and Relax from 8AM - 10AM1! See you there!", "Mississauga", 0));
            events.add(new Event("Cook the Pasta", "have a passion for cooking or eating? come join us at kitchenly to make some delicious pasta! Ingredients will be provided. See you there on December 10, 2019 from 9PM -12 PM!", "Mississauga", 1));
            events.add(new Event("Knit a Scarf", "join us at knitability on December 19, 2019 from 3PM-5PM to learn how to knit a scarf! All levels of experience is welcome! Coffee, tea, and water will be provided.", "Oshawa", 2));
            events.add(new Event("Co-opCon volunteer", "Co-opCon is in PCC this year! Feel free to come by and learn proper co-op techniques! Save the date: November 29, 2019 from 11AM-12PM!", "Mississauga", 3));
            events.add(new Event("GamesCon volunteer", "GamesCon is also in PCC this year! Feel free to come by and learn proper gaming techniques! Save the date: November 1, 2019 from 11AM-12PM!", "Mississauga", 3));
            events.add(new Event("Stir Up the Soup", "have a passion for cooking or eating? come join us at cookza on November 14, 2019 10pm-12pm to learn how to make some soup", "Toronto", 1));
            events.add(new Event("Bake the Cake", "have a passion for baking? our instructor will walk you through step by step the process of baking a beautiful delicious cake. it'll be on December 3, 2019 from 1PM - 3PM. See you there!", "Etobicoke", 1));
            events.add(new Event("Knit a Hat", "winter is coming which means YOU should keep yourself or your loved ones warm with a self-knitted hat! Come out and join us at Knittingbox on November 10, 2019 from 2PM-5PM", "Punjab", 2));
            events.add(new Event("Show off some Art", "Do you have a passion for art? Well, come out on November 5, 2019 form 3pm-6pm and show off your art skills!", "Cali", 1));
            events.add(new Event("Do a Painting", "Did you ever feel like an artist? Wait no more, come out and make yourself a painting on November 3, 2019 from 1pm-3pm", "Lahore", 2));
            events.add(new Event("Chat and Chill", "Do you want to meet and mingle with other seniors in your community? Come out for a nice chat and chill on October 31, 2019", "Pind", 2));
            events.add(new Event("Play some Golf", "Want to have a relaxing day on a picturesque city run course? If you answered \"yes\", come out and join us at Golftown on October 26, 2019 from 10AM - 2PM!", "Zimbabwe", 0));
            events.add(new Event("Stretch it out", "Here at StretchIt, we believe that stretching plays a huge role in increasing flexibility and helping the prevention of muscle soreness. Feel free to come by and learn proper stretching techniques! Save the date: November 19, 2019 from 11AM-12PM!", "Toronto", 0));
            init = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        initArray();



        /*AssetManager assetManager = this.getAssets();
        String fileName = "\\mnt\\sdcard\\fakedata.txt";
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
                    String location = splitArray[8];//fix
                    String description = splitArray[7];
                    int eventType = Integer.parseInt(splitArray[9]);//fix
                    events.add(new Event(name,location,description,eventType));
                }
            }
        }
        catch(Exception e){
            Log.e(TAG, e.toString() + (new File(".").getAbsolutePath()));
        }*/

        EventAdapter adapter = null;
        RecyclerView rvEvents = findViewById(R.id.recycler_event_list);
        if(getIntent().getExtras() != null){
            adapter = new EventAdapter(booked);
        }
        else{
            adapter = new EventAdapter(events);
        }
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
            }
        }

        @Override
        public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            ((TextView) holder.view.findViewById(R.id.text_event_location)).setText(dataset.get(position).getLocation());
            ((TextView) holder.view.findViewById(R.id.text_event_name)).setText(dataset.get(position).getName());
            ((TextView) holder.view.findViewById(R.id.text_event_description)).setText(dataset.get(position).getDescription());

            int resource;
            switch (dataset.get(position).getEventType()) {
                case 1:
                    resource = R.drawable.purple_box_rectangle;
                    break;
                case 2:
                    resource = R.drawable.green_box_rectangle;
                    break;
                case 3:
                    resource = R.drawable.orange_box_rectangle;
                    break;
                case 0:
                default:
                    resource = R.drawable.blue_box_rectangle;
            }
            holder.view.findViewById(R.id.event_container).setBackgroundResource(resource);

            //set the fields in holder
            final Event event = dataset.get(position);
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(EventListActivity.this, EventDetailsActivity.class);
                    intent.putExtra("Name",event.getName());
                    intent.putExtra("Description",event.getDescription());
                    intent.putExtra("Location",event.getLocation());
                    intent.putExtra("EventType",event.getEventType());

                    startActivity(intent);
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return dataset.size();
        }
    }

    public void onBackBtnClicked(View v) {
        finish();
    }
}
