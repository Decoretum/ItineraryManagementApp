package com.example.itinerarymanagementapp.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Event;
import com.example.itinerarymanagementapp.screens.event.EventListActivity;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class EventAdapter extends RealmRecyclerViewAdapter<Event, EventAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        TextView category;
        TextView timeRange;
        ImageView imageView;
        Button viewEventButton;
        Button deleteEventButton;

        public ViewHolder(@NonNull View view) {
            super(view);
            eventName = view.findViewById(R.id.eventName);
            category = view.findViewById(R.id.category);
            timeRange = view.findViewById(R.id.timeRange);
            imageView = view.findViewById(R.id.imageView);
            viewEventButton = view.findViewById(R.id.viewEventButton);
            deleteEventButton = view.findViewById(R.id.deleteEventButton);
            }

        }
        EventListActivity eventListActivity;

        public EventAdapter(EventListActivity eventListActivity, OrderedRealmCollection<Event> events, boolean autoUpdate){
            super(events, autoUpdate);
            this.eventListActivity = eventListActivity;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewParent, int viewType){
            View view = eventListActivity.getLayoutInflater().inflate(R.layout.event_row_layout, viewParent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position){
            Event event = getItem(position);

            //Get Image File
            File imageDir = eventListActivity.getExternalCacheDir();
            File eventFile = new File(imageDir, event.getEventName() + ".jpeg");
            Picasso.get()
                    .load(eventFile)
                    .placeholder(android.R.drawable.ic_menu_my_calendar)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .into(viewHolder.imageView);

            viewHolder.eventName.setText(event.getEventName());
            viewHolder.category.setText(event.getCategory());

            String timeRange = event.getTimeRange();
            String newRange = timeRange.replace("|||", ", ");
            viewHolder.timeRange.setText(newRange);

            viewHolder.deleteEventButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListActivity.deleteEvent(event);
                }
            });

            viewHolder.viewEventButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventListActivity.viewEvent(event.getUuid());
                }
            });

        }




}
