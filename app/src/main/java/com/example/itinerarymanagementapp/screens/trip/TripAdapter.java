package com.example.itinerarymanagementapp.screens.trip;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itinerarymanagementapp.models.Trip;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class TripAdapter extends RealmRecyclerViewAdapter<Trip, TripAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Instantiate Trip row UI components
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Find Trip row UI by ID
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
//        User u = getItem(position);
//
//
//        holder.rowUserName.setText(u.getName());
//        holder.userPassword.setText(u.getPassword());
//
//
//        holder.editUserBtn.setTag(u);
//        holder.editUserBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                adminScreen.editUser((User) view.getTag());
//            }
//        });
//
//
//        holder.deleteUserBtn.setTag(u);
//        holder.deleteUserBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                adminScreen.delete((User) view.getTag());
//            }
//        });
    }
}
