package com.example.itinerarymanagementapp.screens.user;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.User;
import com.example.itinerarymanagementapp.screens.trip.TripListActivity_;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity
public class LoginActivity extends AppCompatActivity {

    @ViewById
    EditText loginUsername;

    @ViewById
    EditText loginPassword;

    @ViewById
    CheckBox rememberMe;


    Realm realm;


    @Click
    public void signIn()
    {
        String un = loginUsername.getText().toString();
        String pw = loginPassword.getText().toString();


        // check if user exists
        User userSaved = realm.where(User.class).equalTo("username", un).findFirst();
        if (userSaved==null)
        {
            Toast.makeText(this, "No user found", Toast.LENGTH_LONG).show();
        }
        // user exists, check if password matches
        else 
        {
            if (userSaved.getPassword().equals(pw)) {
                SharedPreferences uprefs = getSharedPreferences("User", MODE_PRIVATE);
                SharedPreferences.Editor edit = uprefs.edit();

                edit.putString("uuid", userSaved.getUuid());
                edit.putBoolean("remember", rememberMe.isChecked());
                edit.putString("userName", userSaved.getUsername());
                edit.apply();

                /* go to Trips screen */
                Toast.makeText(this, un + "'s Trips  \n" + pw, Toast.LENGTH_LONG).show();

                // Sign In Functionality
                RealmResults<User> UUID = realm.where(User.class)
                        .equalTo("username", un)
                        .and()
                        .equalTo("password", pw)
                        .findAll();
                User u = UUID.get(0);
                edit.putString("UUID", u.getUuid());
                edit.commit();
                Intent intent = new Intent(this, TripListActivity_.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Click
    public void admin()
    {
        AdminActivity_.intent(this).start();
    }


    @Click
    public void clearUserPrefs()
    {
        SharedPreferences uprefs = getSharedPreferences("User", MODE_PRIVATE);

        uprefs.edit().clear().apply();

        Toast.makeText(this, "Preferences cleared", Toast.LENGTH_LONG).show();
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

    public void init()
    {
        realm = Realm.getDefaultInstance();
        SharedPreferences uprefs = getSharedPreferences("User", MODE_PRIVATE);

        Boolean remember = uprefs.getBoolean("remember", rememberMe.isChecked());
        if (remember)
        {
            // retrieve user from Realm
            // pre-fill

            String userUuid = uprefs.getString("uuid", "");
            User userLogin = realm.where(User.class).equalTo("uuid", userUuid)
                    .findFirst();

            if (userLogin != null){
                loginUsername.setText(userLogin.getUsername());
                loginPassword.setText(userLogin.getPassword());
            }

            rememberMe.setChecked(true);
        }
    }

    public void toastRequirePermissions()
    {
        Toast.makeText(this, "You must provide permissions for app to run", Toast.LENGTH_LONG).show();
        finish();
    }


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
        setContentView(R.layout.activity_login);
    }
}