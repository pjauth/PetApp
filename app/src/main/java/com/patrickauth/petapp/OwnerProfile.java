package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

public class OwnerProfile extends Activity {

    protected Owner owner;
    TextView firstName;
    TextView lastName;
    TextView email;
    int ID;
    String firstName1;
    String lastName1;
    String address;
    String city;
    String state;
    int zipCode;
    String email1;
    String password;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_profile_page);
        Intent intent = getIntent();
        int tempId = intent.getIntExtra("ownerId", 12);

        owner = new Owner(42, firstName1, lastName1, address, city, state, zipCode, email1, phone);
        owner.getProfile();
        firstName = findViewById(R.id.ownerProfileFirstName);
        lastName = findViewById(R.id.ownerProfileLastName);
        email = findViewById(R.id.owner_profile_email);

        firstName.setText(owner.getFirstName());
        firstName.setVisibility(View.VISIBLE);
        lastName.setText(owner.getLastName());
        lastName.setVisibility(View.VISIBLE);
        email.setText(owner.getEmail());
        email.setVisibility(View.VISIBLE);
    }
}
