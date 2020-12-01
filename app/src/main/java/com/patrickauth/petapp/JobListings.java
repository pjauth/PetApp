package com.patrickauth.petapp;

import android.app.Activity;
import android.os.Bundle;

public class JobListings extends Activity {

    // Decided to wait on implementation until after we figure out the API/how jobs are going to be stored within the app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_listings);

    }
}
