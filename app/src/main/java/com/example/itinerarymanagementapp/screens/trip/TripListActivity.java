package com.example.itinerarymanagementapp.screens.trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Trip;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class TripListActivity extends AppCompatActivity {

    @ViewById
    TextView tripTitle;
    @ViewById
    RecyclerView tripRecyclerView;
    @ViewById
    EditText categoryFilterInput;
    @ViewById
    Button addTripBtn;
    @ViewById
    Button tripListBackBtn;

    Realm realm;
    SharedPreferences userPrefs;
    SharedPreferences tripPrefs;
    SharedPreferences.Editor userPrefsEditor;
    SharedPreferences.Editor tripPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
        realm = Realm.getDefaultInstance();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        tripRecyclerView.setLayoutManager(mLayoutManager);

        userPrefs = getSharedPreferences("User", MODE_PRIVATE);
        userPrefsEditor = userPrefs.edit();

        String UUID = userPrefs.getString("UUID", null);

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

//    @Click
//    public void cancelEditBtn(){
//        Intent intent = new Intent(this, MainActivity_.class);
//        startActivity(intent);
//        finish();
//    }

    public void onDestroy()
    {
        super.onDestroy();

        if (!realm.isClosed())
        {
            realm.close();
        }
    }
}