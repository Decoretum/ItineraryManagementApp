package com.example.itinerarymanagementapp.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class tripCategory extends RealmObject {

    @PrimaryKey
    private String uuid;

    private String name;

    public tripCategory(){}

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
