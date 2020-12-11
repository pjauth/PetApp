package com.patrickauth.petapp;

import android.util.Log;

import org.json.JSONObject;

public class Listing {
    int listingID;
    int posterID;
    int petID;
    int sitterID;
    String description;
    String startDate;
    String endDate;
    int active;
    Double latitude;
    Double longitude;
    int isSleepover;

    public Listing(int listingID, int posterID, int petID, int sitterID, String description,
            String startDate, String endDate, int active, Double latitude, Double longitude,
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

    public void getListing(){

        try {
            String endpoint = "owner/get_listing.php?id="+listingID+"?lat="+"?long=";
            Log.w("MA", "***** Calling endpoint:" + endpoint);
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            Log.w("MA", "Received response:" + jsonObject);
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

    public Double getLatitude(){
        return latitude;
    }

    public Double getLongitude(){
        return longitude;
    }
}
