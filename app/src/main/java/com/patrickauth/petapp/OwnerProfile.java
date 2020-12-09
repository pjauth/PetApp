package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OwnerProfile extends Activity {

    protected Owner owner;
    TextView firstName;
    TextView lastName;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_profile_page);
        Intent intent = getIntent();
        int tempId = intent.getIntExtra("ownerId", 12);
        owner = new Owner(tempId);
        owner.getProfile();
        firstName = findViewById(R.id.ownerProfileFirstName);
        lastName = findViewById(R.id.ownerProfileLastName);
        email = findViewById(R.id.owner_profile_email);

        firstName.setText(owner.firstName);
        lastName.setText(owner.lastName);
        email.setText(owner.email);
    }
}
