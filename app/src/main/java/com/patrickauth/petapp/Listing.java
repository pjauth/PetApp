package com.patrickauth.petapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import org.json.JSONObject;

import java.net.URL;

public class Listing {
    int listingID;
    int posterID;
    int petID;
    int sitterID;
    String description;
    String startDate;
    String endDate;
    int active;
    double latitude;
    double longitude;
    int isSleepover;
    int distance;

    public Owner owner;
    public Sitter sitter;
    public Pet pet;

    public Listing(int listingID) {
        this.listingID = listingID;
    }

    public Listing(int listingID, int posterID, int petID, int sitterID, String description,
            String startDate, String endDate, int active, double latitude, double longitude,
            int isSleepover){
        this.listingID = listingID;
        this.posterID = posterID;
        this.petID = petID;
        this.sitterID = sitterID;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isSleepover = isSleepover;

    }

    public void getListing(Context context){
        GPSTracker gps;
        double curLatitude = 39.322945;
        double curLongitude = -76.614172;

        try {
            gps = new GPSTracker(context);
            if(gps.canGetLocation()) {
                curLatitude = gps.getLatitude();
                curLongitude = gps.getLongitude();
                Log.w("MA", "Location LAT: " + curLatitude + " LONG: " + curLongitude);
            } else {
                gps.showSettingsAlert();
            }
            String endpoint = "postings/detail.php?id="+listingID+"&lat=39.322945&long=76.614172";
            Log.w("MA", "***** Calling endpoint:" + endpoint);
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            Log.w("MA", "Received response:" + jsonObject);
            JSONObject listingDetail = jsonObject.getJSONObject("listingDetail");

            posterID = listingDetail.getJSONObject("owner").getInt("id");
            String ownerFirstName = listingDetail.getJSONObject("owner").getString("firstName");
            String ownerLastName  = listingDetail.getJSONObject("owner").getString("lastName");
            String ownerStreet = listingDetail.getJSONObject("owner").getString("firstName");

            listingID = jsonObject.getInt("listingID");
            posterID = jsonObject.getInt("posterID");
            petID = jsonObject.getInt("petID");
            sitterID = jsonObject.getInt("sitterID");
            description = jsonObject.getString("description");
            startDate = jsonObject.getString("startDate");
            endDate = jsonObject.getString("endDate");
            latitude = jsonObject.getDouble("latitude");
            longitude = jsonObject.getDouble("longitude");
            isSleepover = jsonObject.getInt("isSleepover");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getListingID(){
        return listingID;
    }

    public int getPosterID(){
        return posterID;
    }

    public int getPetID(){
        return petID;
    }

    public int getSitterID(){
        return sitterID;
    }

    public String getDescription(){
        return description;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public int getActive(){
        return active;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }
}
