package com.patrickauth.petapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SitterJobPrefCreation extends AppCompatActivity {

    String[] petTypes;
    ArrayAdapter petTypeAdaptor;
    GridView petTypeGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_job_pref_registration);

        petTypes = getResources().getStringArray(R.array.pet_types);
        petTypeAdaptor = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, petTypes);
        petTypeGrid = (GridView) findViewById(R.id.pet_type_grid);
        petTypeGrid.setAdapter(petTypeAdaptor);
        for (int i = 0; i < petTypeAdaptor.getCount(); i++) {
            petTypeGrid.setItemChecked(i, true);
        }
    }
}
