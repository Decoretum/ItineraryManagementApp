package com.example.itinerarymanagementapp.screens.user;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itinerarymanagementapp.R;
import com.example.itinerarymanagementapp.models.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import io.realm.Realm;

@EActivity
public class RegisterActivity extends AppCompatActivity {

    @ViewById
    EditText firstName;

    @ViewById
    EditText lastName;

    @ViewById
    EditText birthday;

    @ViewById
    EditText username;

    @ViewById
    EditText password;

    @ViewById
    EditText confirmPassword;


    Realm realm;

    @Click
    public void saveRegister()
    {
        String uname = username.getText().toString();
        String pword1 = password.getText().toString();
        String pword2 = confirmPassword.getText().toString();
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String bday = birthday.getText().toString();

        SharedPreferences prefs = getSharedPreferences("logins", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();


        if (uname.isEmpty())
        {
            Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_LONG).show();
        }
        else // username is not empty
        {
            // check if username's already registered
            User userSaved = realm.where(User.class).equalTo("username", uname).findFirst();
            if (userSaved==null)
            {
                if (pword1.equals(pword2)) // passwords match
                {
                    if (fname.isEmpty() || lname.isEmpty() || bday.isEmpty())
                    {
                        Toast.makeText(this, "Fields cannot be blank", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        // add new user to Realm
                        User unew = new User();
                        unew.setUuid(UUID.randomUUID().toString());
                        unew.setFirstName(fname);
                        unew.setLastName(lname);
                        unew.setBirthday(bday);
                        unew.setUsername(uname);
                        unew.setPassword(pword2);

                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(unew);
                        realm.commitTransaction();

                        long userCount = realm.where(User.class).count();
                        Toast.makeText(this, "User saved  Total: " + Long.toString(userCount), Toast.LENGTH_LONG).show();

                        this.finish();
                    }
                }
                else
                {
                    Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(this, "User already exists", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Click
    public void cancelRegister()
    {
        this.finish();
    }


    @AfterViews
    public void init()
    {
        // initialize Realm
        realm = Realm.getDefaultInstance();
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
        setContentView(R.layout.activity_register);
    }
}