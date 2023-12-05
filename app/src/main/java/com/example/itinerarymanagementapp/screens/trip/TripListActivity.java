package com.example.itinerarymanagementapp.screens.trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.adapters.EventAdapter;
import com.example.itinerarymanagementapp.models.Event;
import com.example.itinerarymanagementapp.models.Trip;
import com.example.itinerarymanagementapp.models.eventCategory;
import com.example.itinerarymanagementapp.models.tripCategory;
import com.example.itinerarymanagementapp.screens.MainActivity_;
import com.example.itinerarymanagementapp.screens.event.EventListActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class TripListActivity extends AppCompatActivity {

    @ViewById
    TextView tripTitle;
    @ViewById
    RecyclerView tripRecyclerView;
//    @ViewById
//    EditText filterCategory;
    @ViewById
    Button addTripBtn;
    @ViewById
    Button tripListBackBtn;
    @ViewById
    Button applyFilterButton;

    @ViewById
    Spinner filterCategory;

    public static String referenceUUID;
    Realm realm;
    SharedPreferences userPrefs;
    SharedPreferences tripPrefs;
    SharedPreferences.Editor userPrefsEditor;
    SharedPreferences.Editor tripPrefsEditor;

    String UUID;
    public String userUUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);

        applyFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm = Realm.getDefaultInstance();

                if (filterCategory.getSelectedItem() == null){
                    return;
                }

                String queriedCategory = filterCategory.getSelectedItem().toString().trim();

                if (!queriedCategory.equals("All Categories")){
                    Log.d("GaelLogs", queriedCategory);
                    RealmResults<Trip> queriedTrips = realm.where(Trip.class).contains("category", queriedCategory).contains("userUUID", userUUID).findAll();
                    TripAdapter tripAdapter = new TripAdapter(TripListActivity.this, queriedTrips, true);
                    tripRecyclerView.setAdapter(tripAdapter);
                } else {
                    RealmResults<Trip> queriedTrips = realm.where(Trip.class).contains("userUUID", userUUID).findAll();
                    TripAdapter tripAdapter = new TripAdapter(TripListActivity.this, queriedTrips, true);
                    tripRecyclerView.setAdapter(tripAdapter);
                }

            }
        });

    }
    @AfterViews
    public void init(){
        realm = Realm.getDefaultInstance();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        tripRecyclerView.setLayoutManager(mLayoutManager);

        //Spinner
        SharedPreferences store = getSharedPreferences("User", MODE_PRIVATE);
        userUUID = store.getString("UUID", null);
        RealmResults<tripCategory> tripCategories = realm.where(tripCategory.class).findAll();
        ArrayList<String> categories = new ArrayList<>();
        categories.add("All Categories");
        for (tripCategory i : tripCategories){
            Log.d("GaelLogs", i.getName());
            categories.add(i.getName());
        }

        ArrayAdapter list = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);

        if (categories.isEmpty()){
            for (tripCategory i : tripCategories){
                categories.add(i.getName());
            }
            list.addAll(categories);
        }

        list.setNotifyOnChange(true);
        list.notifyDataSetChanged();

        list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterCategory.setAdapter(list);

        userPrefs = getSharedPreferences("User", MODE_PRIVATE);
        userPrefsEditor = userPrefs.edit();

        UUID = userPrefs.getString("UUID", null);

        RealmResults<Trip> calledUUID = realm.where(Trip.class).equalTo("userUUID", UUID).findAll();
        TripAdapter tAdapter = new TripAdapter(this, calledUUID, true);
        tripRecyclerView.setAdapter(tAdapter);
    }

    public void viewTrip(Trip t){
        Intent intent = new Intent(this, ViewTripActivity_.class);

        //Put trip in shared preferences
        tripPrefs = getSharedPreferences("Trip", MODE_PRIVATE);
        tripPrefsEditor = tripPrefs.edit();
        String tripUUID = t.getUuid();
        Log.d("LOGGING", "viewTrip: "+ tripUUID);
        tripPrefsEditor.putString("tripUUID", tripUUID);
        tripPrefsEditor.apply();
        startActivity(intent);
        finish();
    }
    public void delete(Trip t)
    {
        // need to check if previously deleted
        if (t.isValid())
        {
            realm.beginTransaction();
            t.deleteFromRealm();
            realm.commitTransaction();
        }
    }

    @Click
    public void addTripBtn(){
        Intent intent = new Intent(this, CreateTripActivity_.class);
        startActivity(intent);
        finish();
    }

    @Click
    public void tripListBackBtn(){
        Intent intent = new Intent(this, MainActivity_.class);
        startActivity(intent);
        finish();
    }

    public void onDestroy()
    {
        super.onDestroy();

        if (!realm.isClosed())
        {
            realm.close();
        }
    }
}