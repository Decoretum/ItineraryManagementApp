package com.example.itinerarymanagementapp.screens.user;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Event;
import com.example.itinerarymanagementapp.models.Trip;
import com.example.itinerarymanagementapp.models.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class AdminActivity extends AppCompatActivity {

    @ViewById
    RecyclerView userRecycler;

    @ViewById
    Button adminBackButton;


    @Click
    public void register()
    {
        RegisterActivity_.intent(this).start();
    }

    @Click
    public void clearUserRealm()
    {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    Realm realm;

    public void edit(User user)
    {
        // store the user's uuid for next screen's use
        SharedPreferences uprefs = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor edit = uprefs.edit();

        edit.putString("userEditUuid", user.getUuid());
        edit.apply();

        // go to Edit screen
        EditUserActivity_.intent(this).start();
    }

    public void delete(User user)
    {
        if(user.isValid())    // need to check if previously deleted
        {
            RealmResults<Event> events = realm.where(Event.class).contains("userUUID", user.getUuid()).findAll();
            RealmResults<Trip> trips = realm.where(Trip.class).contains("userUUID", user.getUuid()).findAll();
            realm.beginTransaction();
            user.deleteFromRealm();
            events.deleteAllFromRealm();
            trips.deleteAllFromRealm();
            realm.commitTransaction();
        }
    }


    @AfterViews
    public void init()
    {
        // initialize RecyclerView
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        userRecycler.setLayoutManager(mLayoutManager);

        // pull up the things to display
        realm = Realm.getDefaultInstance();
        RealmResults<User> list = realm.where(User.class).findAll();

        // adapter setup & put in the recycler
        // what's inside (Realm) list gets displayed
        UserAdapter adapter = new UserAdapter(this, list, true);
        userRecycler.setAdapter(adapter);

        adminBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                LoginActivity_.intent(AdminActivity.this).start();
            }
        });
    }


    // close Realm
    public void onDestroy()
    {
        super.onDestroy();
        if (!realm.isClosed())
        {
            realm.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
}