package com.patrickauth.petapp;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class SitterProfilePage extends Activity{

    ImageView sitterPic;
    TextView sitterName;
    TextView sitterPhone;
    TextView sitterPoints;
    TextView sitterRating;

    // private SQLiteHandler db;
    // private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_profile_page);
        String s = getIntent().getStringExtra("sitterEmail");
        Sitter sitter = new Sitter(1,s);
        sitter.getSitter();
        updateView();
        sitterName.setText(s);







    }

    private void updateView(){

        sitterName = findViewById(R.id.sitter_name);
        sitterPhone = findViewById(R.id.sitter_phone_number);
        sitterPoints = findViewById(R.id.sitter_points);
    }


}
