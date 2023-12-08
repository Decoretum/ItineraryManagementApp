package com.example.itinerarymanagementapp.screens;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.screens.trip.TripListActivity_;
import com.example.itinerarymanagementapp.screens.user.LoginActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import io.realm.Realm;

@EActivity
public class MainActivity extends AppCompatActivity {


    @Click
    public void next()
    {
        LoginActivity_.intent(this).start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences uprefs = getSharedPreferences("User", MODE_PRIVATE);
        Boolean remember = uprefs.getBoolean("remember", false);

        if (remember){
            TripListActivity_.intent(this).start();
        }
    }
}