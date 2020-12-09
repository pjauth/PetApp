package com.patrickauth.petapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class JobListings extends Activity {

    ListView listingView;
    ArrayList<String> jobIds;
    ArrayAdapter listingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_listings);

        listingView = (ListView) findViewById(R.id.job_search_listings);
    }

    public void displayList(ArrayList<String> items) {
        items.add("Dog1");
        items.add("Dog2");
        items.add("Dog3");
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
