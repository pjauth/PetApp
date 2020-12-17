package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

public class JobListings extends Activity {
    TextView description_field1;
    TextView start_field1;
    TextView end_field1;
    TextView sleepover_field1;
    Button b1;

    TextView description_field2;
    TextView start_field2;
    TextView end_field2;
    TextView sleepover_field2;
    Button b2;

    TextView description_field3;
    TextView start_field3;
    TextView end_field3;
    TextView sleepover_field3;
    Button b3;

    TextView description_field4;
    TextView start_field4;
    TextView end_field4;
    TextView sleepover_field4;
    Button b4;

    TextView description_field5;
    TextView start_field5;
    TextView end_field5;
    TextView sleepover_field5;
    Button b5;

    TextView description_field6;
    TextView start_field6;
    TextView end_field6;
    TextView sleepover_field6;
    Button b6;

    TextView description_field7;
    TextView start_field7;
    TextView end_field7;
    TextView sleepover_field7;
    Button b7;

    TextView description_field8;
    TextView start_field8;
    TextView end_field8;
    TextView sleepover_field8;
    Button b8;

    TextView description_field9;
    TextView start_field9;
    TextView end_field9;
    TextView sleepover_field9;
    Button b9;

    TextView description_field10;
    TextView start_field10;
    TextView end_field10;
    TextView sleepover_field10;
    Button b10;

    ListView listingView;
    ArrayList<String> jobIds;
    ArrayAdapter listingAdapter;
    ArrayList<Listing> a;
    APICall apiCall;
    int poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_listings);
        ButtonHandler bh = new ButtonHandler();

        apiCall = new APICall("");
        ArrayList<Listing> a = apiCall.requestNearbyListings();
        // listingView = (ListView) findViewById(R.id.job_search_listings);
        updateView();
        description_field1.setText(a.get(0).getDescription());
        start_field1.setText(a.get(0).getStartDate());
        end_field1.setText(a.get(0).getEndDate());
        sleepover_field1.setText(a.get(0).getIsSleepover());
        b1.setOnClickListener(bh);

        description_field2.setText(a.get(1).getDescription());
        start_field2.setText(a.get(1).getStartDate());
        end_field2.setText(a.get(1).getEndDate());
        sleepover_field2.setText(a.get(1).getIsSleepover());
        b2.setOnClickListener(bh);

    }

    public void goToListingDetail(int i){
        Intent intent = new Intent( this, ListingDetail.class);

        intent.putExtra("posterID", poster);
        //Start the new activity with the new animation
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,0);
    }

    private class ButtonHandler implements View.OnClickListener {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    poster = 42;
                    goToListingDetail(poster);
                    break;
                case R.id.button2:
                    poster = 55;
                    goToListingDetail(poster);
                    break;
            }
        }
    }

    public void updateView(){

        int numListings = 0;

        if(numListings == 1) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);
        }

        if(numListings == 2) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

        }

        if(numListings == 3) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
        }

        if(numListings == 4) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field4 = findViewById(R.id.description_field4);
            start_field4 = findViewById(R.id.start_field4);
            end_field4 = findViewById(R.id.end_field4);
            sleepover_field4 = findViewById(R.id.sleepover_field4);
            b4 = findViewById(R.id.button4);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);

            description_field4.setVisibility(View.VISIBLE);
            start_field4.setVisibility(View.VISIBLE);
            end_field4.setVisibility(View.VISIBLE);
            sleepover_field4.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);


        }

        if(numListings == 5) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field4 = findViewById(R.id.description_field4);
            start_field4 = findViewById(R.id.start_field4);
            end_field4 = findViewById(R.id.end_field4);
            sleepover_field4 = findViewById(R.id.sleepover_field4);
            b4 = findViewById(R.id.button4);

            description_field5 = findViewById(R.id.description_field5);
            start_field5 = findViewById(R.id.start_field5);
            end_field5 = findViewById(R.id.end_field5);
            sleepover_field5 = findViewById(R.id.sleepover_field5);
            b5 = findViewById(R.id.button5);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);

            description_field4.setVisibility(View.VISIBLE);
            start_field4.setVisibility(View.VISIBLE);
            end_field4.setVisibility(View.VISIBLE);
            sleepover_field4.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

            description_field5.setVisibility(View.VISIBLE);
            start_field5.setVisibility(View.VISIBLE);
            end_field5.setVisibility(View.VISIBLE);
            sleepover_field5.setVisibility(View.VISIBLE);
            b5.setVisibility(View.VISIBLE);


        }

        if(numListings == 6) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field4 = findViewById(R.id.description_field4);
            start_field4 = findViewById(R.id.start_field4);
            end_field4 = findViewById(R.id.end_field4);
            sleepover_field4 = findViewById(R.id.sleepover_field4);
            b4 = findViewById(R.id.button4);

            description_field5 = findViewById(R.id.description_field5);
            start_field5 = findViewById(R.id.start_field5);
            end_field5 = findViewById(R.id.end_field5);
            sleepover_field5 = findViewById(R.id.sleepover_field5);
            b5 = findViewById(R.id.button5);

            description_field6 = findViewById(R.id.description_field6);
            start_field6 = findViewById(R.id.start_field6);
            end_field6 = findViewById(R.id.end_field6);
            sleepover_field6 = findViewById(R.id.sleepover_field6);
            b6 = findViewById(R.id.button6);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);

            description_field4.setVisibility(View.VISIBLE);
            start_field4.setVisibility(View.VISIBLE);
            end_field4.setVisibility(View.VISIBLE);
            sleepover_field4.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

            description_field5.setVisibility(View.VISIBLE);
            start_field5.setVisibility(View.VISIBLE);
            end_field5.setVisibility(View.VISIBLE);
            sleepover_field5.setVisibility(View.VISIBLE);
            b5.setVisibility(View.VISIBLE);

            description_field6.setVisibility(View.VISIBLE);
            start_field6.setVisibility(View.VISIBLE);
            end_field6.setVisibility(View.VISIBLE);
            sleepover_field6.setVisibility(View.VISIBLE);
            b6.setVisibility(View.VISIBLE);


        }

        if(numListings == 7) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field4 = findViewById(R.id.description_field4);
            start_field4 = findViewById(R.id.start_field4);
            end_field4 = findViewById(R.id.end_field4);
            sleepover_field4 = findViewById(R.id.sleepover_field4);
            b4 = findViewById(R.id.button4);

            description_field5 = findViewById(R.id.description_field5);
            start_field5 = findViewById(R.id.start_field5);
            end_field5 = findViewById(R.id.end_field5);
            sleepover_field5 = findViewById(R.id.sleepover_field5);
            b5 = findViewById(R.id.button5);

            description_field6 = findViewById(R.id.description_field6);
            start_field6 = findViewById(R.id.start_field6);
            end_field6 = findViewById(R.id.end_field6);
            sleepover_field6 = findViewById(R.id.sleepover_field6);
            b6 = findViewById(R.id.button6);

            description_field7 = findViewById(R.id.description_field7);
            start_field7 = findViewById(R.id.start_field7);
            end_field7 = findViewById(R.id.end_field7);
            sleepover_field7 = findViewById(R.id.sleepover_field7);
            b7 = findViewById(R.id.button7);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);

            description_field4.setVisibility(View.VISIBLE);
            start_field4.setVisibility(View.VISIBLE);
            end_field4.setVisibility(View.VISIBLE);
            sleepover_field4.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

            description_field5.setVisibility(View.VISIBLE);
            start_field5.setVisibility(View.VISIBLE);
            end_field5.setVisibility(View.VISIBLE);
            sleepover_field5.setVisibility(View.VISIBLE);
            b5.setVisibility(View.VISIBLE);

            description_field6.setVisibility(View.VISIBLE);
            start_field6.setVisibility(View.VISIBLE);
            end_field6.setVisibility(View.VISIBLE);
            sleepover_field6.setVisibility(View.VISIBLE);
            b6.setVisibility(View.VISIBLE);

            description_field7.setVisibility(View.VISIBLE);
            start_field7.setVisibility(View.VISIBLE);
            end_field7.setVisibility(View.VISIBLE);
            sleepover_field7.setVisibility(View.VISIBLE);
            b7.setVisibility(View.VISIBLE);


        }

        if(numListings == 8) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field4 = findViewById(R.id.description_field4);
            start_field4 = findViewById(R.id.start_field4);
            end_field4 = findViewById(R.id.end_field4);
            sleepover_field4 = findViewById(R.id.sleepover_field4);
            b4 = findViewById(R.id.button4);

            description_field5 = findViewById(R.id.description_field5);
            start_field5 = findViewById(R.id.start_field5);
            end_field5 = findViewById(R.id.end_field5);
            sleepover_field5 = findViewById(R.id.sleepover_field5);
            b5 = findViewById(R.id.button5);

            description_field6 = findViewById(R.id.description_field6);
            start_field6 = findViewById(R.id.start_field6);
            end_field6 = findViewById(R.id.end_field6);
            sleepover_field6 = findViewById(R.id.sleepover_field6);
            b6 = findViewById(R.id.button6);

            description_field7 = findViewById(R.id.description_field7);
            start_field7 = findViewById(R.id.start_field7);
            end_field7 = findViewById(R.id.end_field7);
            sleepover_field7 = findViewById(R.id.sleepover_field7);
            b7 = findViewById(R.id.button7);

            description_field8 = findViewById(R.id.description_field8);
            start_field8 = findViewById(R.id.start_field8);
            end_field8 = findViewById(R.id.end_field8);
            sleepover_field8 = findViewById(R.id.sleepover_field8);
            b8 = findViewById(R.id.button8);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);

            description_field4.setVisibility(View.VISIBLE);
            start_field4.setVisibility(View.VISIBLE);
            end_field4.setVisibility(View.VISIBLE);
            sleepover_field4.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

            description_field5.setVisibility(View.VISIBLE);
            start_field5.setVisibility(View.VISIBLE);
            end_field5.setVisibility(View.VISIBLE);
            sleepover_field5.setVisibility(View.VISIBLE);
            b5.setVisibility(View.VISIBLE);

            description_field6.setVisibility(View.VISIBLE);
            start_field6.setVisibility(View.VISIBLE);
            end_field6.setVisibility(View.VISIBLE);
            sleepover_field6.setVisibility(View.VISIBLE);
            b6.setVisibility(View.VISIBLE);

            description_field7.setVisibility(View.VISIBLE);
            start_field7.setVisibility(View.VISIBLE);
            end_field7.setVisibility(View.VISIBLE);
            sleepover_field7.setVisibility(View.VISIBLE);
            b7.setVisibility(View.VISIBLE);

            description_field8.setVisibility(View.VISIBLE);
            start_field8.setVisibility(View.VISIBLE);
            end_field8.setVisibility(View.VISIBLE);
            sleepover_field8.setVisibility(View.VISIBLE);
            b8.setVisibility(View.VISIBLE);


        }

        if(numListings == 9) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field4 = findViewById(R.id.description_field4);
            start_field4 = findViewById(R.id.start_field4);
            end_field4 = findViewById(R.id.end_field4);
            sleepover_field4 = findViewById(R.id.sleepover_field4);
            b4 = findViewById(R.id.button4);

            description_field5 = findViewById(R.id.description_field5);
            start_field5 = findViewById(R.id.start_field5);
            end_field5 = findViewById(R.id.end_field5);
            sleepover_field5 = findViewById(R.id.sleepover_field5);
            b5 = findViewById(R.id.button5);

            description_field6 = findViewById(R.id.description_field6);
            start_field6 = findViewById(R.id.start_field6);
            end_field6 = findViewById(R.id.end_field6);
            sleepover_field6 = findViewById(R.id.sleepover_field6);
            b6 = findViewById(R.id.button6);

            description_field7 = findViewById(R.id.description_field7);
            start_field7 = findViewById(R.id.start_field7);
            end_field7 = findViewById(R.id.end_field7);
            sleepover_field7 = findViewById(R.id.sleepover_field7);
            b7 = findViewById(R.id.button7);

            description_field8 = findViewById(R.id.description_field8);
            start_field8 = findViewById(R.id.start_field8);
            end_field8 = findViewById(R.id.end_field8);
            sleepover_field8 = findViewById(R.id.sleepover_field8);
            b8 = findViewById(R.id.button8);

            description_field9 = findViewById(R.id.description_field9);
            start_field9 = findViewById(R.id.start_field9);
            end_field9 = findViewById(R.id.end_field9);
            sleepover_field9 = findViewById(R.id.sleepover_field9);
            b9 = findViewById(R.id.button9);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);

            description_field4.setVisibility(View.VISIBLE);
            start_field4.setVisibility(View.VISIBLE);
            end_field4.setVisibility(View.VISIBLE);
            sleepover_field4.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

            description_field5.setVisibility(View.VISIBLE);
            start_field5.setVisibility(View.VISIBLE);
            end_field5.setVisibility(View.VISIBLE);
            sleepover_field5.setVisibility(View.VISIBLE);
            b5.setVisibility(View.VISIBLE);

            description_field6.setVisibility(View.VISIBLE);
            start_field6.setVisibility(View.VISIBLE);
            end_field6.setVisibility(View.VISIBLE);
            sleepover_field6.setVisibility(View.VISIBLE);
            b6.setVisibility(View.VISIBLE);

            description_field7.setVisibility(View.VISIBLE);
            start_field7.setVisibility(View.VISIBLE);
            end_field7.setVisibility(View.VISIBLE);
            sleepover_field7.setVisibility(View.VISIBLE);
            b7.setVisibility(View.VISIBLE);

            description_field8.setVisibility(View.VISIBLE);
            start_field8.setVisibility(View.VISIBLE);
            end_field8.setVisibility(View.VISIBLE);
            sleepover_field8.setVisibility(View.VISIBLE);
            b8.setVisibility(View.VISIBLE);

            description_field9.setVisibility(View.VISIBLE);
            start_field9.setVisibility(View.VISIBLE);
            end_field9.setVisibility(View.VISIBLE);
            sleepover_field9.setVisibility(View.VISIBLE);
            b9.setVisibility(View.VISIBLE);


        }

        if(numListings == 10) {
            description_field1 = findViewById(R.id.description_field1);
            start_field1 = findViewById(R.id.start_field1);
            end_field1 = findViewById(R.id.end_field1);
            sleepover_field1 = findViewById(R.id.sleepover_field1);
            b1 = findViewById(R.id.button1);

            description_field2 = findViewById(R.id.description_field2);
            start_field2 = findViewById(R.id.start_field2);
            end_field2 = findViewById(R.id.end_field2);
            sleepover_field2 = findViewById(R.id.sleepover_field2);
            b2 = findViewById(R.id.button2);

            description_field3 = findViewById(R.id.description_field3);
            start_field3 = findViewById(R.id.start_field3);
            end_field3 = findViewById(R.id.end_field3);
            sleepover_field3 = findViewById(R.id.sleepover_field3);
            b3 = findViewById(R.id.button3);

            description_field4 = findViewById(R.id.description_field4);
            start_field4 = findViewById(R.id.start_field4);
            end_field4 = findViewById(R.id.end_field4);
            sleepover_field4 = findViewById(R.id.sleepover_field4);
            b4 = findViewById(R.id.button4);

            description_field5 = findViewById(R.id.description_field5);
            start_field5 = findViewById(R.id.start_field5);
            end_field5 = findViewById(R.id.end_field5);
            sleepover_field5 = findViewById(R.id.sleepover_field5);
            b5 = findViewById(R.id.button5);

            description_field6 = findViewById(R.id.description_field6);
            start_field6 = findViewById(R.id.start_field6);
            end_field6 = findViewById(R.id.end_field6);
            sleepover_field6 = findViewById(R.id.sleepover_field6);
            b6 = findViewById(R.id.button6);

            description_field7 = findViewById(R.id.description_field7);
            start_field7 = findViewById(R.id.start_field7);
            end_field7 = findViewById(R.id.end_field7);
            sleepover_field7 = findViewById(R.id.sleepover_field7);
            b7 = findViewById(R.id.button7);

            description_field8 = findViewById(R.id.description_field8);
            start_field8 = findViewById(R.id.start_field8);
            end_field8 = findViewById(R.id.end_field8);
            sleepover_field8 = findViewById(R.id.sleepover_field8);
            b8 = findViewById(R.id.button8);

            description_field9 = findViewById(R.id.description_field9);
            start_field9 = findViewById(R.id.start_field9);
            end_field9 = findViewById(R.id.end_field9);
            sleepover_field9 = findViewById(R.id.sleepover_field9);
            b9 = findViewById(R.id.button9);

            description_field10 = findViewById(R.id.description_field10);
            start_field10 = findViewById(R.id.start_field10);
            end_field10 = findViewById(R.id.end_field10);
            sleepover_field10 = findViewById(R.id.sleepover_field10);
            b10 = findViewById(R.id.button10);

            description_field1.setVisibility(View.VISIBLE);
            start_field1.setVisibility(View.VISIBLE);
            end_field1.setVisibility(View.VISIBLE);
            sleepover_field1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);

            description_field2.setVisibility(View.VISIBLE);
            start_field2.setVisibility(View.VISIBLE);
            end_field2.setVisibility(View.VISIBLE);
            sleepover_field2.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);

            description_field3.setVisibility(View.VISIBLE);
            start_field3.setVisibility(View.VISIBLE);
            end_field3.setVisibility(View.VISIBLE);
            sleepover_field3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);

            description_field4.setVisibility(View.VISIBLE);
            start_field4.setVisibility(View.VISIBLE);
            end_field4.setVisibility(View.VISIBLE);
            sleepover_field4.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);

            description_field5.setVisibility(View.VISIBLE);
            start_field5.setVisibility(View.VISIBLE);
            end_field5.setVisibility(View.VISIBLE);
            sleepover_field5.setVisibility(View.VISIBLE);
            b5.setVisibility(View.VISIBLE);

            description_field6.setVisibility(View.VISIBLE);
            start_field6.setVisibility(View.VISIBLE);
            end_field6.setVisibility(View.VISIBLE);
            sleepover_field6.setVisibility(View.VISIBLE);
            b6.setVisibility(View.VISIBLE);

            description_field7.setVisibility(View.VISIBLE);
            start_field7.setVisibility(View.VISIBLE);
            end_field7.setVisibility(View.VISIBLE);
            sleepover_field7.setVisibility(View.VISIBLE);
            b7.setVisibility(View.VISIBLE);

            description_field8.setVisibility(View.VISIBLE);
            start_field8.setVisibility(View.VISIBLE);
            end_field8.setVisibility(View.VISIBLE);
            sleepover_field8.setVisibility(View.VISIBLE);
            b8.setVisibility(View.VISIBLE);

            description_field9.setVisibility(View.VISIBLE);
            start_field9.setVisibility(View.VISIBLE);
            end_field9.setVisibility(View.VISIBLE);
            sleepover_field9.setVisibility(View.VISIBLE);
            b9.setVisibility(View.VISIBLE);

            description_field10.setVisibility(View.VISIBLE);
            start_field10.setVisibility(View.VISIBLE);
            end_field10.setVisibility(View.VISIBLE);
            sleepover_field10.setVisibility(View.VISIBLE);
            b10.setVisibility(View.VISIBLE);


        }



    }

    public void displayList(ArrayList<String> items) {
        if(items != null) {
            listingAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            listingView.setAdapter(listingAdapter);
            ListItemHandler listItemHandler = new ListItemHandler();
            listingView.setOnItemClickListener(listItemHandler);
        } else {
            Toast.makeText( this, "Error loading pet sitting listings", Toast.LENGTH_LONG ).show();
        }
    }

    private class ListItemHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.w("MA", "Pet sitting job item clicked");
            String jobId = jobIds.get(i);
            // fetch info to load that listing's detail here
        }
    }
}
