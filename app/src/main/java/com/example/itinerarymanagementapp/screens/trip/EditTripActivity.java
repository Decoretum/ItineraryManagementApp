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

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class EditTripActivity extends AppCompatActivity {
    @ViewById
    TextView editTripTitle;
    @ViewById
    TextView editTripNameTitle;
    @ViewById
    EditText editTripNameInput;
    @ViewById
    TextView editTripCategoryTitle;
    @ViewById
    EditText editTripCategoryInput;
    @ViewById
    TextView editTripDescriptionTitle;
    @ViewById
    EditText editTripDescriptionInput;
    @ViewById
    Button saveTripEditBtn;
    @ViewById
    Button cancelTripEditBtn;

    Realm realm;
    SharedPreferences tripPrefs;
    SharedPreferences.Editor tripPrefsEditor;
    Trip trip;

    @AfterViews
    public void init(){
        realm = Realm.getDefaultInstance();
        tripPrefs = getSharedPreferences("Trip", MODE_PRIVATE);
        tripPrefsEditor = tripPrefs.edit();
        String tripUUID = tripPrefs.getString("tripUUID", null);

        trip = realm.where(Trip.class).equalTo("uuid", tripUUID).findFirst();
        if(trip != null){
            editTripNameInput.setText(trip.getTripName());
            editTripCategoryInput.setText(trip.getCategory());
            editTripDescriptionInput.setText(trip.getDescription());
        }
    }

    @Click
    public void saveTripEditBtn(){
        String tripName = editTripNameInput.getText().toString();
        String tripCategory = editTripCategoryInput.getText().toString();
        String tripDescription = editTripDescriptionInput.getText().toString();
        RealmResults<Trip> tripNamesData = realm.where(Trip.class)
                .equalTo("tripName", tripName).findAll();
        if(tripName.equals("")){
            editTripNameInput.setText(trip.getTripName());
            blankInputToast("Name");
        }
        else if(tripCategory.equals("")){
            editTripCategoryInput.setText(trip.getCategory());
            blankInputToast("Category");
        }
        else if(tripDescription.equals("")){
            editTripDescriptionInput.setText(trip.getDescription());
            blankInputToast("Description");
        }
        else if(tripNamesData.size() > 0 && !tripName.equals(editTripNameInput.getText().toString())){
            tripExistsToast();
        }
        else{
            realm.beginTransaction();
            trip.setTripName(tripName);
            trip.setCategory(tripCategory);
            trip.setDescription(tripDescription);
            realm.commitTransaction();

            tripEditSavedToast();

            Intent intent = new Intent(this, ViewTripActivity.class);
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
        tripExists = Toast.makeText(this, "Trip Name Already Exists", Toast.LENGTH_SHORT);
        tripExists.show();
    }

    private void tripEditSavedToast(){
        Toast newTripEditSaved;
        String edditedTripMsg = "Trip edit saved";
        newTripEditSaved = Toast.makeText(this, edditedTripMsg, Toast.LENGTH_SHORT);
        newTripEditSaved.show();
    }
    @Click
    public void cancelTripEditBtn(){
        Intent intent = new Intent(this, ViewTripActivity_.class);
        startActivity(intent);
        finish();
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
        setContentView(R.layout.activity_edit_trip);
    }
}