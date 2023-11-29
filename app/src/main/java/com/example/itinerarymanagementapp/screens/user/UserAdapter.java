package com.example.itinerarymanagementapp.screens.user;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.User;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class UserAdapter extends RealmRecyclerViewAdapter<User, UserAdapter.ViewHolder> {

    
    // defines what views you are filling in
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        // fields
        TextView username;
        TextView password;

        ImageButton delete;
        ImageButton edit;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            // initialize them from the itemView using standard style
            username = itemView.findViewById(R.id.username);
            password = itemView.findViewById(R.id.password);

            // initialize buttons
            delete = itemView.findViewById(R.id.deleteUserButton);
            edit = itemView.findViewById(R.id.editUserButton);
        }
    }

    // constructor
    // the containing activity needs to be passed
    AdminActivity adminActivity;

    public UserAdapter(AdminActivity activity, @Nullable OrderedRealmCollection<User> data, boolean autoUpdate) {
        super(data, autoUpdate);
        this.adminActivity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType)
    {
        View view = adminActivity.getLayoutInflater().inflate(R.layout.user_row_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {

        User user = getItem(position); // gives data object at the given position

        // copy all the values needed to the appropriate views
        holder.username.setText(user.getUsername());
        holder.password.setText(user.getPassword());


        // buttons

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminActivity.delete(user);
            }
        });


        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminActivity.edit(user);
            }
        });
    }

}
