package com.example.clickactachieve;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<Event> dataset;

    public EventAdapter(ArrayList<Event> list){
        dataset = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
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