package com.example.itinerarymanagementapp.screens.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;

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
                SharedPreferences uprefs = getSharedPreferences("uprefs", MODE_PRIVATE);
                SharedPreferences.Editor edit = uprefs.edit();

                edit.putString("uuid", userSaved.getUuid());
                edit.putBoolean("remember", rememberMe.isChecked());
                edit.apply();

                /* go to Trips screen */
                Toast.makeText(this, un + "'s Trips  \n" + pw, Toast.LENGTH_LONG).show();
                    // edit this line
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
        SharedPreferences uprefs = getSharedPreferences("uprefs", MODE_PRIVATE);

        uprefs.edit().clear().apply();

        Toast.makeText(this, "Preferences cleared", Toast.LENGTH_LONG).show();
    }


    @AfterViews
    public void init()
    {
        realm = Realm.getDefaultInstance();
        SharedPreferences uprefs = getSharedPreferences("uprefs", MODE_PRIVATE);

        Boolean remember = uprefs.getBoolean("remember", rememberMe.isChecked());
        if (remember)
        {
            // retrieve user from Realm
            // pre-fill

            String userUuid = uprefs.getString("uuid", "");
            User userLogin = realm.where(User.class).equalTo("uuid", userUuid)
                    .findFirst();

            loginUsername.setText(userLogin.getUsername());
            loginPassword.setText(userLogin.getPassword());
            rememberMe.setChecked(true);
        }
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