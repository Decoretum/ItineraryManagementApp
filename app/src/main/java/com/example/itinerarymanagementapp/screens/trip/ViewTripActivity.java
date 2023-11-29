package com.example.itinerarymanagementapp.screens.trip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Trip;
import com.example.itinerarymanagementapp.screens.event.EventListActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class ViewTripActivity extends AppCompatActivity {

    @ViewById
    TextView viewTripTitle;
    @ViewById
    TextView viewTripCategory;
    @ViewById
    TextView tripDescriptionTitle;
    @ViewById
    TextView tripDescriptionField;
    @ViewById
    Button checkTripEventsBtn;
    @ViewById
    Button editTripBtn;
    @ViewById
    Button backBtn;
    Realm realm;
    SharedPreferences tripPrefs;
    SharedPreferences.Editor tripPrefsEditor;
    @AfterViews
    public void init(){
        realm = Realm.getDefaultInstance();
        tripPrefs = getSharedPreferences("Trip", MODE_PRIVATE);
        tripPrefsEditor = tripPrefs.edit();
        String tripUUID = tripPrefs.getString("tripUUID", null);
        Log.d("LOGGING2", "viewTrip: "+ tripUUID);
        Trip t = realm.where(Trip.class).equalTo("uuid", tripUUID).findFirst();

        viewTripTitle.setText(t.getTripName());
        viewTripCategory.setText(t.getCategory());
        tripDescriptionField.setText(t.getDescription());
    }

    @Click
    public void checkTripEventsBtn(){
        Intent intent = new Intent(this, EventListActivity_.class);
        startActivity(intent);
        finish();
    }

    @Click
    public void editTripBtn(){
        Intent intent = new Intent(this, EditTripActivity_.class);
        startActivity(intent);
        finish();
    }

    @Click
    public void backBtn(){
        Intent intent = new Intent(this, TripListActivity_.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trip);
    }
}