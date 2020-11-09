/**
 * ProfileCreationView
 * This view is for the creation of a user profile (a pet-sitter or pet-owner)
 */
package com.patrickauth.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_creation_activity);
    }

    public void selectedSitterProfile(View v) {
        Intent intent = new Intent(this, SitterProfRegistrationActivity.class);
        startActivity(intent);
    }

    public void selectedOwnerProfile(View v) {
        Intent intent = new Intent(this, OwnerProfRegistrationActivity.class);
        startActivity(intent);
    }
}
