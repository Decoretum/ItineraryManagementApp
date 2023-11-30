package com.example.itinerarymanagementapp.screens.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Event;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.io.File;

import io.realm.Realm;

@EActivity
public class ViewEventActivity extends AppCompatActivity {

    @Extra
    String uuid;

    Realm realm;

    @ViewById
    TextView viewEventName;

    @ViewById
    TextView viewEventTime;

    @ViewById
    TextView viewEventDescription;

    @ViewById
    TextView viewEventCategory;

    @ViewById
    ImageView imageView2;

    @ViewById
    Button viewEventEditButton;

    @ViewById
    Button viewEventBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        realm = Realm.getDefaultInstance();
        Event event = realm.where(Event.class).contains("uuid", uuid).findFirst();
        viewEventName.setText(event.getEventName());
        viewEventDescription.setText(event.getEventDescription());
        viewEventCategory.setText(event.getCategory());
        viewEventTime.setText(event.getTimeRange());

        viewEventBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewEventEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditEventActivity_.intent(ViewEventActivity.this).uuid(uuid).start();
                finish();
            }
        });

        File imgDir = getExternalCacheDir();
        File eventFile = new File(imgDir, event.getEventName() + ".jpeg");
        Picasso.get()
                .load(eventFile)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(imageView2);

    }

    public void onDestroy(){
        if (!realm.isClosed()){
            realm.close();
        }
        super.onDestroy();
    }
}