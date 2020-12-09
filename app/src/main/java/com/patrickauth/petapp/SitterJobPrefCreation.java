package com.patrickauth.petapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SitterJobPrefCreation extends AppCompatActivity {
    SeekBar distanceSeekBar;
    SeekBar weightSeekBar;
    String[] petTypes;
    ArrayAdapter<String> petTypeAdaptor;
    ListView petTypeList;
    TextView distanceLabel;
    TextView weightLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_job_pref_registration);

        // Initialize the distance seekbar for miles willing to travel to jobs
        distanceSeekBar = (SeekBar) findViewById(R.id.distance_seekbar);
        distanceSeekBar.setProgress(15);
        distanceSeekBar.incrementProgressBy(1);
        distanceSeekBar.setMax(100);

        // Update the distance label on seekbar changes for the distance
        distanceLabel = findViewById(R.id.distanceInMiles);
        String distanceLabelValue = distanceSeekBar.getProgress() + " miles";
        distanceLabel.setText(distanceLabelValue);

        // Override the listener for the seekbar so the textview is changed with it
        distanceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressValue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String distanceText = progressValue + " miles";
                distanceLabel.setText(distanceText);
            }
        });

        // Initialize the weight seekbar
        weightSeekBar = (SeekBar) findViewById(R.id.pet_weight_slider);
        weightSeekBar.setProgress(40);
        weightSeekBar.incrementProgressBy(5);
        weightSeekBar.setMax(200);

        // Update the distance label on seekbar changes for the distance
        weightLabel = findViewById(R.id.pet_weight_label);
        String weightLabelValue = weightSeekBar.getProgress() + " lbs";
        weightLabel.setText(weightLabelValue);

        // Override the listener for the seekbar so the textview is changed with it
        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Round to the nearest multiple of 5 to make it more standardized
                progressValue = (i + 4) / 5 * 5;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String labelText = progressValue + " lbs";
                weightLabel.setText(labelText);
            }
        });

        // TODO: need to figure out where the pet selection will be stored
        petTypes = getResources().getStringArray(R.array.pet_types);
        petTypeAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, petTypes);
        petTypeList = (ListView) findViewById(R.id.petTypeList);
        petTypeList.setAdapter(petTypeAdaptor);

        for (int i = 0; i < petTypeAdaptor.getCount(); i++) {
            petTypeList.setItemChecked(i, true);
        }
    }

}
