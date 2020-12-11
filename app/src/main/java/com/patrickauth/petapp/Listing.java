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
        double curLatitude = 39.322945;
        double curLongitude = -76.614172;

        try {
            String endpoint = "postings/detail.php?id="+listingID+"&lat=39.322945&long=76.614172";
            Log.w("MA", "***** Calling endpoint:" + endpoint);
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            Log.w("MA", "Received response:" + jsonObject);
            JSONObject listingDetail = jsonObject.getJSONObject("listingDetail");

            distance = jsonObject.getInt("distance");

            posterID = listingDetail.getJSONObject("owner").getInt("id");
            String ownerFirstName = listingDetail.getJSONObject("owner").getString("firstName");
            Log.w("MA", "first name is " + ownerFirstName);
            String ownerLastName  = listingDetail.getJSONObject("owner").getString("lastName");
            String street = listingDetail.getJSONObject("owner").getString("street");
            String city = listingDetail.getJSONObject("owner").getString("city");
            String state = listingDetail.getJSONObject("owner").getString("state");
            int zipcode = listingDetail.getJSONObject("owner").getInt("zipcode");
            String email = listingDetail.getJSONObject("owner").getString("email");
            String phone = listingDetail.getJSONObject("owner").getString("phone");

            this.owner = new Owner(posterID, ownerFirstName, ownerLastName, street, city, state, zipcode, email, phone);

            int petId = listingDetail.getJSONObject("pet").getInt("petId");
            String petName = listingDetail.getJSONObject("pet").getString("name");
            int petWeight = listingDetail.getJSONObject("pet").getInt("weight");
            String petSize = listingDetail.getJSONObject("pet").getString("size");
            String petBreed = listingDetail.getJSONObject("pet").getString("breed");
            int petOwnerId = listingDetail.getJSONObject("pet").getInt("ownerId");
            this.pet = new Pet(petId, petName, petWeight, petSize, petBreed, petOwnerId);

            listingID = listingDetail.getJSONObject("listingDetails").getInt("listingID");
            petID = listingDetail.getJSONObject("listingDetails").getInt("petID");
            sitterID = listingDetail.getJSONObject("listingDetails").getInt("sitterID");
            description = listingDetail.getJSONObject("listingDetails").getString("description");
            startDate = listingDetail.getJSONObject("listingDetails").getString("startDate");
            endDate = listingDetail.getJSONObject("listingDetails").getString("endDate");
            latitude = listingDetail.getJSONObject("listingDetails").getDouble("latitude");
            longitude = listingDetail.getJSONObject("listingDetails").getDouble("longitude");
            isSleepover = listingDetail.getJSONObject("listingDetails").getInt("isSleepover");
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
