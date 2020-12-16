package com.patrickauth.petapp;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

public class SitterProfilePage extends Activity{

    SharedPreferences sharedPreferences;
    public static final String SITTER_PREFS = "SitterPrefs";

    TextView sitterName;
    TextView sitterPhone;
    TextView sitterPoints;
    TextView sitterAddress;
    Button matches;
    String first;
    String last;
    String points;
    String rating;
    String street;
    String city;
    String state;

    // private SQLiteHandler db;
    // private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_profile_page);
        String s = getIntent().getStringExtra("sitterEmail");
        Sitter sitter = new Sitter(1,s);
        sharedPreferences = getSharedPreferences(SITTER_PREFS, Context.MODE_PRIVATE);
        /*
        JSONObject jSitter = sitter.getSitter();
        try {
            first = jSitter.getString("firstName");
            last = jSitter.getString("lastName");
            points = jSitter.getString("points");
            rating = jSitter.getString("rating");
            street = jSitter.getString("street");
            city = jSitter.getString("city");
            state = jSitter.getString("state");

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        first = sharedPreferences.getString("firstName", "Conor");
        last = sharedPreferences.getString("lastName", "OBrien");
        points = "0";
        rating = "0";
        street = sharedPreferences.getString("street", "123 Main St");
        city = sharedPreferences.getString("city", "Baltimore");
        state = sharedPreferences.getString("state", "Maryland");

        updateView();
        sitterName.setText(first+" "+last);
        sitterPhone.setText("Number of Points: "+points);
        sitterPoints.setText("Current Rating: "+ rating);
        sitterAddress.setText("Adddress: "+street+" "+city+", "+state);







    }

    private void updateView(){

        sitterName = findViewById(R.id.sitter_name);
        sitterPhone = findViewById(R.id.sitter_phone_number);
        sitterPoints = findViewById(R.id.sitter_points);
        sitterAddress = findViewById(R.id.current_address);
        matches = findViewById(R.id.matches_button);
        ButtonHandler bh =  new ButtonHandler();
        matches.setOnClickListener(bh);
    }

    public void goToMatches(){
        Intent intent = new Intent( this, JobListings.class);

        //Start the new activity with the new animation
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,0);
    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){
            switch(v.getId()) {
                case R.id.matches_button:
                    goToMatches();
                    break;
            }
        }

    }


}
