package com.example.clickactachieve;

import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<Event> dataset;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public ViewHolder(TextView tvN) {
            super(tvN);
            textViewName = tvN;
        }
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_adapter,parent,false);
        ViewHolder vh = new ViewHolder(textView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textViewName.setText(dataset.get(position).getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}