package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ListingDetail extends Activity {
    protected Listing listing;
    protected Owner owner;
    protected Pet pet;
    protected APICall apiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listing_detail);
        Intent intent = getIntent();
        int requestedListing = intent.getIntExtra("listingId", 12);
        String endpoint = "postings/detail.php?id="+requestedListing+"&lat="
        apiCall = new APICall();
        listing = new Listing();
    }
}
