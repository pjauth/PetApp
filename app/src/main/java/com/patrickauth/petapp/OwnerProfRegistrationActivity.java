package com.patrickauth.petapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class OwnerProfRegistrationActivity extends Activity {
    final int petTypeACThreshold = 1;
    String[] pet_types = {"Dog", "Cat", "Parrot", "Fish", "Snake", "Turtle", "Hamster", "Rabbit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_prof_registration);

        ArrayAdapter<String> petTypeAdaptor = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, pet_types);
        AutoCompleteTextView autoCompletePetType = (AutoCompleteTextView) findViewById(R.id.pet_type_autocomplete);
        autoCompletePetType.setThreshold(petTypeACThreshold);
        autoCompletePetType.setAdapter(petTypeAdaptor);
        autoCompletePetType.setTextColor(Color.BLACK);
    }
}
