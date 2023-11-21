package com.example.itinerarymanagementapp.screens.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itinerarymanagementapp.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.example.itinerarymanagementapp.adapters.EventAdapter;
import com.example.itinerarymanagementapp.models.Event;

import io.realm.Realm;
import io.realm.RealmResults;

import java.io.File;

@EActivity
public class EventListActivity extends AppCompatActivity {

    Realm realm;
    @ViewById
    RecyclerView recyclerView;

    @ViewById
    Button newEventButton;

    @ViewById
    Button backButton;

    @ViewById
    Button applyFilterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        newEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateEventActivity_.intent(EventListActivity.this).start();
                finish();
            }
        });
    }

    @AfterViews
    public void initialize(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        realm = Realm.getDefaultInstance();
        RealmResults<Event> events = realm.where(Event.class).findAll();

        EventAdapter eventAdapter = new EventAdapter(this, events, true);
        recyclerView.setAdapter(eventAdapter);
    }

    public void deleteEvent(Event event){
        if (event.isValid()){
            realm.beginTransaction();
            File imgDir = getExternalCacheDir();
            File eventFile = new File(imgDir, event.getEventName() + ".jpeg");
            eventFile.delete();
            event.deleteFromRealm();
            realm.commitTransaction();
        }
    }

    public void viewEvent(String eventUUID){
        ViewEventActivity_.intent(this).start();
        finish();
    }

    public void onDestroy(){
        if (!realm.isClosed()){
            realm.close();
        }
        super.onDestroy();
    }


}