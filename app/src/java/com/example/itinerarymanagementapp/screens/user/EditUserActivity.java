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

import io.realm.Realm;

@EActivity
public class EditUserActivity extends AppCompatActivity {

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
    public void saveUserEdit()
    {
        String uname = username.getText().toString();
        String pword1 = password.getText().toString();
        String pword2 = confirmPassword.getText().toString();
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String bday = birthday.getText().toString();

        SharedPreferences uprefs = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor edit = uprefs.edit();


        // fields should be filled out
        if (uname.isEmpty())
        {
            Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_LONG).show();
        }
        else
        {
            // check if passwords match
            if (pword1.equals(pword2))
            {
                if (fname.isEmpty() || lname.isEmpty() || bday.isEmpty())
                {
                    Toast.makeText(this, "Fields cannot be blank", Toast.LENGTH_LONG).show();
                }
                else
                {

                    // pull up the user to edit based on uuid
                    String userUuid = uprefs.getString("userEditUuid", "");
                    User uedit = realm.where(User.class).equalTo("uuid", userUuid)
                            .findFirst();


                    // save field changes to Realm
                    realm.beginTransaction();

                    uedit.setFirstName(fname);
                    uedit.setLastName(lname);
                    uedit.setBirthday(bday);
                    uedit.setUsername(uname);
                    uedit.setPassword(pword2);

                    realm.copyToRealmOrUpdate(uedit);
                    realm.commitTransaction();

                    Toast.makeText(this, "User edited", Toast.LENGTH_LONG).show();

                    this.finish();
                }
            }
            else
            {
                Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_LONG).show();
            }

        }
    }


    @Click
    public void cancelUserEdit()
    {
        this.finish();
    }


    @AfterViews
    public void init()
    {
        // initialize Realm
        realm = Realm.getDefaultInstance();


        // pull up the user to edit based on uuid
        // and pre-fill the fields

        SharedPreferences uprefs = getSharedPreferences("User", MODE_PRIVATE);
        String userUuid = uprefs.getString("userEditUuid", "");
        User uedit = realm.where(User.class).equalTo("uuid", userUuid)
                .findFirst();

        firstName.setText(uedit.getFirstName());
        lastName.setText(uedit.getLastName());
        birthday.setText(uedit.getBirthday());
        username.setText(uedit.getUsername());
        password.setText(uedit.getPassword());
        confirmPassword.setText(uedit.getPassword());
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
        setContentView(R.layout.activity_edit_user);
    }
}