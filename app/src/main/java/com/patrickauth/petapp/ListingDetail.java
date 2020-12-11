package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

public class ListingDetail extends Activity {
    protected Listing listing;
    TextView ownerFirstLast, petName, weight, distance, sizeValue, breedValue, address1, address2, email, phone;
    Button applyToListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listing_detail);
        Intent intent = getIntent();
        int requestedListing = intent.getIntExtra("listingId", 42);
        listing = new Listing(requestedListing);
        listing.getListing(this);

        updateView();
    }

    protected void updateView() {
        ButtonHandler bh = new ButtonHandler();
        applyToListing = findViewById(R.id.apply_to_listing_btn);
        applyToListing.setOnClickListener(bh);

        ownerFirstLast = findViewById(R.id.listing_info_owner_name);
        String ownerName = listing.owner.getFirstName() + " " + listing.owner.getLastName();
        ownerFirstLast.setText(ownerName);
        ownerFirstLast.setVisibility(View.VISIBLE);

        petName = findViewById(R.id.listing_info_pet_name);
        petName.setText(listing.pet.getName());
        petName.setVisibility(View.VISIBLE);

        weight = findViewById(R.id.listing_weight);
        weight.setText(String.valueOf(listing.pet.getWeight()));
        weight.setVisibility(View.VISIBLE);

        distance = findViewById(R.id.distance_value);
        distance.setText(String.valueOf(listing.getDistance()));
        distance.setVisibility(View.VISIBLE);

        sizeValue = findViewById(R.id.pet_size_value);
        sizeValue.setText(listing.pet.getSize());
        sizeValue.setVisibility(View.VISIBLE);

        breedValue = findViewById(R.id.pet_breed_value);
        breedValue.setText(listing.pet.getBreed());
        breedValue.setVisibility(View.VISIBLE);

        address1 = findViewById(R.id.listing_street);
        address1.setText(listing.owner.address);
        address1.setVisibility(View.VISIBLE);

        address2 = findViewById(R.id.listing_city_state_zip);
        String secondAddrLine = listing.owner.city + ", " + listing.owner.state + " " + listing.owner.zipCode;
        address2.setText(secondAddrLine);
        address2.setVisibility(View.VISIBLE);

        email = findViewById(R.id.owner_email);
        email.setText(listing.owner.getEmail());
        email.setVisibility(View.VISIBLE);

        phone = findViewById(R.id.owner_phone);
        phone.setText(listing.owner.getPhone());
        phone.setVisibility(View.VISIBLE);
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            String sitterEmail = "sitter@gmail.com";
            String endpoint = "postings/apply.php?sitterEmail=" + sitterEmail + "&listingId=" + listing.getListingID() + "";
            APICall apiCall = new APICall(endpoint);
            try {
                Log.w("MA", "API: " + apiCall.sendRequest("GET"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
