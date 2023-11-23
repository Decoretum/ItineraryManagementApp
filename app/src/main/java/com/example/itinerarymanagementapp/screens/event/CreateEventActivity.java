package com.example.itinerarymanagementapp.screens.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.itinerarymanagementapp.R;
import com.karumi.dexter.Dexter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.File;

import io.realm.Realm;

@EActivity
public class CreateEventActivity extends AppCompatActivity {

    @ViewById
    ImageView imageView4;

    @ViewById
    EditText editTripName;

    @ViewById
    EditText editTripCategory;

    @ViewById
    EditText editTripDescription;

    @ViewById
    EditText editTripTime;

    @ViewById
    Button createTrip;

    @ViewById
    Button cancelTrip;

    Realm realm;

    @ViewById
    ImageButton imageButton;

    public static File ImageFile;
    public static byte[] byteArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        cancelTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        imageButton = (ImageButton) findViewById(R.id.imageButton);
    }

    @AfterViews
    public void checkPermissions(){
//        Dexter.withContext(this)
//                .withPermission(
//
//                )
    }

    public void onDestroy(){
        if (!realm.isClosed()){
            realm.close();
        }
        super.onDestroy();
    }
}