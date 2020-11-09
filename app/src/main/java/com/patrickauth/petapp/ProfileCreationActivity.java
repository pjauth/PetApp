/**
 * ProfileCreationView
 * This view is for the creation of a user profile (a pet-sitter or pet-owner)
 */
package com.patrickauth.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileCreationActivity extends AppCompatActivity {
    Button pet_sitter;
    Button pet_owner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_creation_activity);

        ButtonHandler bh = new ButtonHandler();
        pet_sitter = findViewById(R.id.pet_sitter_profile_select);
        pet_owner = findViewById(R.id.pet_owner_profile_select);
    }

    public void selectedSitterProfile() {
        Intent intent = new Intent(this, SitterProfRegistrationActivity.class);
        startActivity(intent);
    }

    public void selectedOwnerProfile() {
        Intent intent = new Intent(this, OwnerProfRegistrationActivity.class);
        startActivity(intent);
    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){

            switch(v.getId()){
                case R.id.pet_owner_profile_select:
                    selectedOwnerProfile();
                    break;

                case R.id.pet_sitter_profile_select:
                    selectedSitterProfile();
                    break;
            }
        }

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
}
