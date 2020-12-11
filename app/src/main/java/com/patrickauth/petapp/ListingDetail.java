package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ListingDetail extends Activity {
    protected Listing listing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listing_detail);
        Intent intent = getIntent();
        int requestedListing = intent.getIntExtra("listingId", 42);
        listing = new Listing(requestedListing);
        listing.getListing(this);

    }

}
