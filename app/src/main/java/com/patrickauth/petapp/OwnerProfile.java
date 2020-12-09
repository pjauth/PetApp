package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        try {
            String endpoint = "owner/get_profile.php?id="+ID;
            Log.w("MA", "***** Calling endpoint:" + endpoint);
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            Log.w("MA", "Received response:" + jsonObject);
            firstName1 = jsonObject.getString("firstName");
            lastName1 = jsonObject.getString("lastName");
            address = jsonObject.getString("street");
            city = jsonObject.getString("city");
            state = jsonObject.getString("state");
            zipCode = jsonObject.getInt("zipcode");
            email1 = jsonObject.getString("email");
            phone = jsonObject.getString("phone");
        } catch (Exception e) {
            e.printStackTrace();
        }

        owner = new Owner(ID, firstName1, lastName1, address, city, state, zipCode, email1, phone);
        owner.getProfile();
        firstName = findViewById(R.id.ownerProfileFirstName);
        lastName = findViewById(R.id.ownerProfileLastName);
        email = findViewById(R.id.owner_profile_email);

        firstName.setText(owner.firstName);
        lastName.setText(owner.lastName);
        email.setText(owner.email);
    }
}
