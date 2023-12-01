package com.example.itinerarymanagementapp.screens.event;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.itinerarymanagementapp.ImageActivity;
import com.example.itinerarymanagementapp.ImageActivity_;
import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.Event;
import com.example.itinerarymanagementapp.models.Trip;
import com.example.itinerarymanagementapp.models.eventCategory;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class CreateEventActivity extends AppCompatActivity {

    @ViewById
    ImageView imageView4;

    @ViewById
    EditText editEventName;

    @ViewById
    EditText editEventCategory;

    @ViewById
    EditText editEventDescription;

    @ViewById
    EditText editTextDate;

    @ViewById
    EditText editTextTime;

    @ViewById
    Button createEvent;

    @ViewById
    Button cancelEvent;

    Realm realm;

    @ViewById
    ImageButton imageButton;

    public static File ImageFile;
    public static int REQUEST_CODE_IMAGE_SCREEN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        cancelEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the File for Image Exists
                if (ImageFile != null){
                    ImageFile.delete();
                }
                finish();
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createEvent();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

//        imageButton = (ImageButton) findViewById(R.id.imageButton);
    }



    @AfterViews
    public void checkPermissions(){
        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.READ_MEDIA_IMAGES,
                        Manifest.permission.READ_MEDIA_VIDEO,
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                ).withListener(new BaseMultiplePermissionsListener(){
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report){
                        if (!report.areAllPermissionsGranted()){
                            for (PermissionDeniedResponse a : report.getDeniedPermissionResponses()){
                                Log.d("GaelLogs", a.getRequestedPermission() + " | " + a.getPermissionName().toString());
                                toastRequirePermissions();
                            }
                        }
                    }
                }).check();
    }


    public void toastRequirePermissions()
    {
        Toast.makeText(this, "You must provide permissions for app to run", Toast.LENGTH_LONG).show();
        finish();
    }

    //Start Result
    public void onTouch(View view){
        ImageActivity_.intent(CreateEventActivity.this).startForResult(REQUEST_CODE_IMAGE_SCREEN);
    }

    //Receive Result Data
    public void onActivityResult(int requestCode, int responseCode, Intent data)
    {
        super.onActivityResult(requestCode, responseCode, data);

        if (requestCode==REQUEST_CODE_IMAGE_SCREEN)
        {
            if (responseCode== ImageActivity.RESULT_CODE_IMAGE_TAKEN)
            {
                // receive the raw JPEG data from ImageActivity
                // this can be saved to a file or save elsewhere like Realm or online
                byte[] jpeg = data.getByteArrayExtra("rawJpeg");

                try {
                    // save rawImage to file
                    ArrayList<Object> rawData = saveFile(jpeg);

                    // load file to the image view via picasso
                    refreshImageView((File) rawData.get(0));

                    // Declare both variables in global scope
                    // byteArray = jpeg;
                    ImageFile = (File) rawData.get(0);
                    Log.d("GaelLogs", "File Name for Pic is " + ImageFile.toString());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }
    }

    private ArrayList<Object> saveFile(byte[] jpeg) throws IOException
    {
        ArrayList<Object> data = new ArrayList<>();

        // this is the root directory for the images
        File getImageDir = getExternalCacheDir();

        // Don't use final name yet for the file
        //String fileName = editEventName.getText().toString().trim();
        File savedImage = new File(getImageDir, "random.jpeg");

        data.add(savedImage);
        // data.add(jpeg);

        //Temporarily save Image File
        FileOutputStream fos = new FileOutputStream(savedImage);
        fos.write(jpeg);
        fos.close();
        return data;
    }



    private void refreshImageView(File savedImage) {
        // this will put the image saved to the file system to the imageview
        Picasso.get()
                .load(savedImage)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(imageView4);
    }

    private void createEvent() throws IOException {
        realm = Realm.getDefaultInstance();
        String eventName = editEventName.getText().toString().trim();
        String eventDescription = editEventDescription.getText().toString().trim();
        String eventTime = editTextTime.getText().toString().trim();
        String eventDate = editTextDate.getText().toString().trim();
        String eventCategory = editEventCategory.getText().toString().trim();

        if (eventName.equals("")){
            Toast.makeText(this, "Event name cannot be blank", Toast.LENGTH_SHORT).show();
            return;
        } else if (eventDescription.equals("")){
            Toast.makeText(this, "Event Description cannot be blank", Toast.LENGTH_SHORT).show();
            return;
        } else if (eventTime.equals("")){
            Toast.makeText(this, "Event Time cannot be blank or must be a valid Time Range", Toast.LENGTH_SHORT).show();
            return;
        } else if (eventDate.equals("")){
            Toast.makeText(this, "Event Date cannot be blank or must be a valid Time Range", Toast.LENGTH_SHORT).show();
            return;
        } else if (eventCategory.equals("")){
            Toast.makeText(this, "Event Category cannot be blank", Toast.LENGTH_SHORT).show();
            return;
        }

        //Event Category Validation
        eventCategory event1 = realm.where(eventCategory.class).contains("name", eventCategory).findFirst();
        if (event1 == null){
            Log.d("GaelLogs", "Not yet existed");
            String uuid = UUID.randomUUID().toString();
            eventCategory newCategory = new eventCategory();
            newCategory.setName(eventCategory.toLowerCase());
            newCategory.setUuid(uuid);
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(newCategory);
            realm.commitTransaction();
        }

        //Event Entity Validation
        RealmResults<Event> results = realm.where(Event.class).equalTo("eventName",
                eventName).findAll();

        if (results.isEmpty()){
            //Get The trip that the event belongs to
            SharedPreferences store = getSharedPreferences("Trip", MODE_PRIVATE);
            String tripUUID = store.getString("tripUUID", "");
            Trip trip = realm.where(Trip.class).contains("uuid", tripUUID).findFirst();

            //Create the Event entity
            String eventUUID = UUID.randomUUID().toString();
            Event newEvent = new Event();
            newEvent.setEventName(eventName);
            newEvent.setEventDescription(eventDescription);
            newEvent.setTripNameReference(trip.getTripName());
            newEvent.setUuid(eventUUID);
            newEvent.setCategory(eventCategory.toLowerCase());
            newEvent.setTimeRange(eventDate + "|||" + eventTime);

            boolean hm = ImageFile == null;
            if (hm == true){
                Log.d("GaelLogs", "NULL");
            }
            //Re-configure the Image File
            if (ImageFile != null){
                File imgDir = getExternalCacheDir();
                File renamedFile = new File(imgDir, eventName + ".jpeg");
                ImageFile.renameTo(renamedFile);
            }


            realm.beginTransaction();
            realm.copyToRealmOrUpdate(newEvent);
            realm.commitTransaction();
            finish();
            EventListActivity_.intent(this).start();

        } else {
            Toast.makeText(this, "Event already exists", Toast.LENGTH_SHORT).show();
        }
        realm.close();
    }
    public void onDestroy(){

        if (realm != null && realm.isClosed()){
            realm.close();
        }
        super.onDestroy();
    }
}