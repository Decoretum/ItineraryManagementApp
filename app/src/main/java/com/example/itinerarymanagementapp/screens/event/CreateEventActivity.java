package com.example.itinerarymanagementapp.screens.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.itinerarymanagementapp.R;

import org.androidannotations.annotations.EActivity;

@EActivity
public class CreateEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }
}