package com.patrickauth.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class IntroPage extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    GPSTracker gps;
    double curLatitude;
    double curLongitude;

    Button sign_up;
    Button log_in;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page);
        updateView();

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{mPermission}, REQUEST_CODE_PERMISSION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updateView(){
        gps = new GPSTracker(IntroPage.this);
        if(gps.canGetLocation()) {
            curLatitude = gps.getLatitude();
            curLongitude = gps.getLongitude();
        } else {
            gps.showSettingsAlert();
        }

        ButtonHandler bh = new ButtonHandler();

        sign_up = findViewById(R.id.sign_up);
        welcome = findViewById(R.id.welcome);
        log_in = findViewById(R.id.log_in);

        sign_up.setVisibility(View.VISIBLE);
        log_in.setVisibility(View.VISIBLE);
        log_in.setOnClickListener(bh);
        sign_up.setOnClickListener(bh);

    }

    private void go_to_profile_selection(){

        //Initialize the intent
        Intent intent = new Intent( this, ProfileCreationActivity.class);

        //Start the new activity with the new animation
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,0);

    }

    private void go_to_login(){
        //Initialize the intent
        Intent intent = new Intent( this, LoginActivity.class);
        intent.putExtra("ownerId", 12);

        //Start the new activity with the new animation
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,0);
    }


    protected void onStart( ) {
        super.onStart( );
        Log.w( "MA", "Inside MainActivity::onStart" );
    }

    protected void onRestart( ) {
        super.onRestart( );
        Log.w( "MA", "Inside MainActivity::onRestart" );
    }

    protected void onResume( ) {
        super.onResume( );
        Log.w( "MA", "Inside MainActivity::onResume" );
        updateView();
    }

    protected void onPause( ) {
        super.onPause( );
        Log.w( "MA", "Inside MainActivity::onPause" );
    }

    protected void onStop( ) {
        super.onStop( );
        Log.w( "MA", "Inside MainActivity::onStop" );
    }

    protected void onDestroy( ) {
        super.onDestroy( );
        Log.w( "MA", "Inside MainActivity::onDestroy" );
    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){
            switch(v.getId()) {
                case R.id.sign_up:
                    go_to_profile_selection();
                    break;
                case R.id.log_in:
                    go_to_login();
                    break;
            }
        }

    }
}