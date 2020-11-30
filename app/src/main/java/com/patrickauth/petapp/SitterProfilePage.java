package com.patrickauth.petapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SitterProfilePage extends Activity{

    ImageView sitterPic;
    TextView sitterName;
    TextView sitterPhone;
    TextView sitterPoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_profile_page);


        updateView();
    }

    private void updateView(){
        sitterPic = findViewById(R.id.sitter_pic);
        sitterName = findViewById(R.id.sitter_name);
        sitterPhone = findViewById(R.id.sitter_phone_number);
        sitterPoints = findViewById(R.id.sitter_points);
    }


}
