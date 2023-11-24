package com.example.itinerarymanagementapp.screens.trip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Trip;

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
    public void tripSaveBtn(){
        String tripNameInput = tripNameRegisterInput.getText().toString();
        String tripCategoryInput = tripCategoryRegisterInput.getText().toString();
        String tripDescriptionInput = tripDescriptionRegisterInput.getText().toString();
        RealmResults<Trip> tripNameData = realm.where(Trip.class)
                .equalTo("tripName", tripNameInput).findAll();

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
            trip.setCategory(tripCategoryInput);
            trip.setDescription(tripDescriptionInput);
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(trip);
            realm.commitTransaction();

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

}