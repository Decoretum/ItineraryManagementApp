package com.example.itinerarymanagementapp;

import android.app.Application;

import io.realm.Realm;

public class RealmApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}