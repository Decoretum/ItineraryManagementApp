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
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class EditEventActivity extends AppCompatActivity {
    @Extra
    String uuid;

    @ViewById
    ImageView imageView5;

    @ViewById
    EditText editEventName2;

    @ViewById
    EditText editEventCategory2;

    @ViewById
    EditText editEventDescription2;

    @ViewById
    EditText editTextDate2;

    @ViewById
    EditText editTextTime2;

    @ViewById
    Button editEvent;

    @ViewById
    Button cancelEditEvent;

    Realm realm;
    public static File ImageFile;
    public static File loadedFile;
    public static int REQUEST_CODE_IMAGE_SCREEN = 0;
    public static Event event;
    public static Boolean imageChanged;

    public static String userName;
    public static Trip trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);
        realm = Realm.getDefaultInstance();

        imageChanged = false;

        //Fetching the trip and User
        SharedPreferences store = getSharedPreferences("User", MODE_PRIVATE);
        userName = store.getString("userName", "");

        SharedPreferences tripStore = getSharedPreferences("Trip", MODE_PRIVATE);
        trip = realm.where(Trip.class).equalTo("uuid", tripStore.getString("tripUUID", "")).findFirst();

        event = realm.where(Event.class).contains("uuid", uuid).findFirst();
        editEventName2.setText(event.getEventName());
        editEventCategory2.setText(event.getCategory());
        editEventDescription2.setText(event.getEventDescription());

        //Parsing Event Date and Event Time
        String eventTimeRange = event.getTimeRange();
        String date = "";
        String time = "";

        //parse the Date
        int counter = 0;
        for (int i = 0; i < eventTimeRange.length(); i++){
            String symb = String.valueOf(eventTimeRange.charAt(i));

            if (symb.equals("|")){
                counter++;
                continue;
            }

            if (counter < 1){
                date = date + symb;
            } else if (counter >= 3){
                time = time + symb;
            }
        }

        editTextDate2.setText(date.trim());
        editTextTime2.setText(time.trim());

        //Loading Existing Event Image
        File dir = getExternalCacheDir();
        File loadImage = new File(dir, event.getUuid() + ".jpeg");
        Picasso.get()
                .load(loadImage)
                .error(android.R.drawable.ic_menu_my_calendar)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(imageView5);

        loadedFile = loadImage;

        cancelEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ImageFile != null){
                    ImageFile.delete();
                }
                finish();
                EventListActivity_.intent(EditEventActivity.this).start();
            }
        });

        editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    edit();
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
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
                        if (report.areAllPermissionsGranted()){
                            init();
                        } else {
                            for (PermissionDeniedResponse a : report.getDeniedPermissionResponses()){
                                Log.d("GaelLogs", a.getRequestedPermission() + " | " + a.getPermissionName().toString());
                            }
                            toastRequirePermissions();
                        }
                    }
                }).check();
    }

    // Will load after @AfterViews or the checkPermissions()
    public void init()
    {
        // check if savedImage.jpeg exists in path
        // load via picasso if exists

        File getImageDir = getExternalCacheDir();
        File savedImage = new File(getImageDir, "savedImage.jpeg");

        if (savedImage.exists()) {
            refreshImageView(savedImage);
        }
    }

    public void toastRequirePermissions()
    {
        Toast.makeText(this, "You must provide permissions for app to run", Toast.LENGTH_LONG).show();
        finish();
    }

    //Start Result
    public void onTouch(View view){
        ImageActivity_.intent(EditEventActivity.this).startForResult(REQUEST_CODE_IMAGE_SCREEN);
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
                    Log.d("GaelLogs", "CHANGED IMAGE FILE");
                    // save rawImage to file
                    ArrayList<Object> rawData = saveFile(jpeg);

                    // load file to the image view via picasso
                    refreshImageView((File) rawData.get(0));
                    imageChanged = true;

                    // Declare variable in global scope
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
                .into(imageView5);
    }

    private void edit() throws IOException {
        realm = Realm.getDefaultInstance();
        String eventName = editEventName2.getText().toString().trim();
        String eventDescription = editEventDescription2.getText().toString().trim();
        String eventTime = editTextTime2.getText().toString().trim();
        String eventDate = editTextDate2.getText().toString().trim();
        String eventCategory = editEventCategory2.getText().toString().toLowerCase().trim();

        HashMap<String, String> eventValues = new HashMap<>();
        eventValues.put("name", eventName);
        eventValues.put("description", eventDescription);
        eventValues.put("time", eventTime);
        eventValues.put("date", eventDate);
        eventValues.put("category", eventCategory);

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
        eventCategory event1 = realm.where(eventCategory.class).contains("name", eventCategory.toLowerCase()).findFirst();
        if (event1 == null){
            String uuid = UUID.randomUUID().toString();
            eventCategory newCategory = new eventCategory();
            newCategory.setName(eventCategory.toLowerCase());
            newCategory.setUuid(uuid);
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(newCategory);
            realm.commitTransaction();
        }

        String sname = event.getEventName();

        SharedPreferences store2 = getSharedPreferences("User", MODE_PRIVATE);
        String userUUID = store2.getString("UUID", null);

        //Event Entity Validation
        RealmResults<Event> results = realm.where(Event.class).equalTo("eventName",
                eventName).equalTo("tripUUID", trip.getUuid()).equalTo("userUUID", userUUID).findAll();

        // Checks if Name is not edited OR Name is new
        if (results.isEmpty()){
            saveEventEditToRealm(trip, eventValues);
            finish();
            EventListActivity_.intent(this).start();
        } else if( results.get(0).getEventName().equals(sname) ){
            saveEventEditToRealm(trip, eventValues);
            finish();
            EventListActivity_.intent(this).start();
        } else if (!results.get(0).getEventName().equals(sname)){
            Toast.makeText(this, "An event with this name already exists", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveEventEditToRealm(Trip trip, HashMap<String, String> eventValues){
        //Edit the Event entity
        realm.beginTransaction();
        event.setEventName( eventValues.get("name") );
        event.setEventDescription( eventValues.get("description") );
        event.setTripUUID(trip.getUuid());
        event.setCategory( eventValues.get("category").toLowerCase() );
        event.setTimeRange( eventValues.get("date") + "|||" + eventValues.get("time"));
        realm.copyToRealmOrUpdate(event);
        realm.commitTransaction();

        //Re-configure the Image File
        File imgDir = getExternalCacheDir();
        File renamedFile = new File(imgDir, event.getUuid() + ".jpeg");

        //Log.d("GaelLogs", "LOADED: " + loadedFile.getPath());
        //Log.d("GaelLogs", "NEW FILE: " + ImageFile.getPath());
        if (imageChanged == false){
            //If no new image, but event information changed
            loadedFile.renameTo(renamedFile);
            Log.d("GaelLogs", "NO CHANGE IN IMAGE");
        } else {
            //If there is a new image with information change or not
            loadedFile.delete();
            ImageFile.renameTo(renamedFile);
            Log.d("GaelLogs", "CHANGE IN IMAGE");
        }

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(event);
        realm.commitTransaction();
        realm.close();
    }

    public void onDestroy(){
        if (!realm.isClosed()){
            realm.close();
        }
        super.onDestroy();
    }
}