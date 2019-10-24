package com.example.clickactachieve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ((TextView) holder.view.findViewById(R.id.text_event_location)).setText(dataset.get(position).getLocation());
        ((TextView) holder.view.findViewById(R.id.text_event_name)).setText(dataset.get(position).getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}