package com.example.itinerarymanagementapp.screens.trip;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Trip;

import org.w3c.dom.Text;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class TripAdapter extends RealmRecyclerViewAdapter<Trip, TripAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Instantiate Trip row UI components
        TextView rowTripName;
        TextView rowTripCategory;
        ImageButton viewTripBtn;
        ImageButton deleteTripBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Find Trip row UI by ID
            rowTripName = itemView.findViewById(R.id.rowTripName);
            rowTripCategory = itemView.findViewById(R.id.rowTripCategory);
            viewTripBtn = itemView.findViewById(R.id.viewTripBtn);
            deleteTripBtn = itemView.findViewById(R.id.deleteTripBtn);

        }
    }

    TripListActivity tripListActivity;

    public TripAdapter(TripListActivity tripListActivity, @Nullable OrderedRealmCollection<Trip> data, boolean autoUpdate) {
        super(data, autoUpdate);
        this.tripListActivity = tripListActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = tripListActivity.getLayoutInflater().inflate(R.layout.trip_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Trip t = getItem(position);


        holder.rowTripName.setText(t.getTripName());
        holder.rowTripCategory.setText(t.getCategory());


        holder.viewTripBtn.setTag(t);
        holder.viewTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripListActivity.viewTrip((Trip) view.getTag());
            }
        });


        holder.deleteTripBtn.setTag(t);
        holder.deleteTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tripListActivity.delete((Trip) view.getTag());
            }
        });
    }
}
