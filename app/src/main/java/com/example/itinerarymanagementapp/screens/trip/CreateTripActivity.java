package com.example.itinerarymanagementapp.screens.trip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Trip;
import com.example.itinerarymanagementapp.models.eventCategory;
import com.example.itinerarymanagementapp.models.tripCategory;
import com.example.itinerarymanagementapp.screens.event.EventListActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class CreateTripActivity extends AppCompatActivity {

    @ViewById
    TextView createTripTitle;
    @ViewById
    TextView tripNameRegisterTitle;
    @ViewById
    EditText tripNameRegisterInput;
    @ViewById
    TextView tripCategoryRegisterTitle;
    @ViewById
    EditText tripCategoryRegisterInput;
    @ViewById
    TextView tripDescriptionRegisterTitle;
    @ViewById
    EditText tripDescriptionRegisterInput;
    @ViewById
    Button tripSaveBtn;
    @ViewById
    Button tripRegisterCancelBtn;
    Realm realm;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String userUUID;

    @AfterViews
    public void init(){
        realm = Realm.getDefaultInstance();
        prefs = getSharedPreferences("User", MODE_PRIVATE);
        editor = prefs.edit();
        userUUID = prefs.getString("UUID", null);
    }

    @Click
    public void tripRegisterCancelBtn(){
        finish();
        TripListActivity_.intent(this).start();
    }

    @Click
    public void tripSaveBtn(){
        String tripNameInput = tripNameRegisterInput.getText().toString();
        String tripCategoryInput = tripCategoryRegisterInput.getText().toString().toLowerCase();
        String tripDescriptionInput = tripDescriptionRegisterInput.getText().toString();
        RealmResults<Trip> tripNameData = realm.where(Trip.class)
                .contains("tripName", tripNameInput).contains("userUUID", userUUID).findAll();

        if(tripNameInput.equals("")) {
            blankInputToast("Name");
        }
        else if(tripCategoryInput.equals("")) {
            blankInputToast("Category");
        }
        // IDK if this is necessary
        else if(tripDescriptionInput.equals("")){
            blankInputToast("Description");
        }
        else if(tripNameData.size() > 0){
            tripNameRegisterInput.setText("");
            tripExistsToast();
        }
        else {
            Trip trip = new Trip();
            trip.setUuid(UUID.randomUUID().toString());
            trip.setUserUUID(userUUID);
            trip.setTripName(tripNameInput);
            trip.setCategory(tripCategoryInput.toLowerCase());
            trip.setDescription(tripDescriptionInput);
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(trip);
            realm.commitTransaction();

            tripCategory trip1 = realm.where(tripCategory.class).contains("name", tripCategoryInput).findFirst();
            if (trip1 == null){
                String uuid = UUID.randomUUID().toString();
                tripCategory newCategory = new tripCategory();
                newCategory.setName(tripCategoryInput.toLowerCase());
                newCategory.setUuid(uuid);
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(newCategory);
                realm.commitTransaction();
            }

            newTripSavedToast();
            Intent intent = new Intent(this, TripListActivity_.class);
            startActivity(intent);
            finish();
        }

    }

    private void blankInputToast(String input){
        Toast blankInput;
        blankInput = Toast.makeText(this, input.concat(" must not be blank"), Toast.LENGTH_SHORT);
        blankInput.show();
    }

    private void tripExistsToast(){
        Toast tripExists;
        tripExists = Toast.makeText(this, "Trip Already Exists", Toast.LENGTH_SHORT);
        tripExists.show();
    }

    private void newTripSavedToast(){
        Toast newTripSaved;
        Long totalTrips = realm.where(Trip.class).count();
        String addedTripMsg = "New Trip saved. Total: ";
        newTripSaved = Toast.makeText(this, addedTripMsg.concat(totalTrips.toString()), Toast.LENGTH_SHORT);
        newTripSaved.show();
    }
    public void onDestroy() {
        super.onDestroy();

        if (!realm.isClosed())
        {
            realm.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);
    }


}