package com.example.itinerarymanagementapp.screens.trip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.itinerarymanagementapp.R;

import org.androidannotations.annotations.EActivity;

@EActivity
public class TripListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
    }
}