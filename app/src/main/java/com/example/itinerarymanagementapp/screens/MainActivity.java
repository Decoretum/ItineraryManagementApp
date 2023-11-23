package com.example.itinerarymanagementapp.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.itinerarymanagementapp.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity
public class MainActivity extends AppCompatActivity {


    @Click
    public void next()
    {
        //
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}