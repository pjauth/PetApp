package com.patrickauth.petapp;

public class Listing {
    int listingID;
    int posterID;
    int petID;
    int sitterID;
    String description;
    String startDate;
    String endDate;
    int active;
    Float latitude;
    Float longitude;
    int isSleepover;

    public Listing(int listingID, int posterID, int petID, int sitterID, String description,
            String startDate, String endDate, int active, Float latitude, Float longitude,
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

    public Float getLatitude(){
        return latitude;
    }

    public Float getLongitude(){
        return longitude;
    }
}
