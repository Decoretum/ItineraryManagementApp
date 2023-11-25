package com.example.itinerarymanagementapp.screens.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.itinerarymanagementapp.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity
public class EditUserActivity extends AppCompatActivity {


    @Click
    public void cancelUserEdit()
    {
        this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
    }
}