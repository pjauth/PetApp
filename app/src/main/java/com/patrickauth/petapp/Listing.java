package com.patrickauth.petapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import org.json.JSONObject;

import java.net.URL;

/**
 * This class serves as the Model for Listings/Bookings posted by Pet Owners.
 * The default constructor takes in the Listing's ID or the other constructor
 * allows for a Listing object to be created by passing in all of the necessary
 * parameters. Data from the PetPanion server about a listing can be fetched using {@code getListing()}
 *
 * @author Pat Auth, Conor O'Brien
 * @version 1.1
 * @since 2020-12-16
 */
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

    /**
     * Default constructor for creating a listing with only the ID.
     * @param listingID: integer representing the unique identifier of the listing in the system
     */
    public Listing(int listingID) {
        this.listingID = listingID;
    }

    /**
     * Expanded constructor for creating a listing with all of the Listing's
     * expected and necessary parameters
     * @param listingID: integer representing the ID of the listing in the system
     * @param posterID: integer representing account ID of the owner who made the listing
     * @param petID: integer representing the pet ID who belongs to the posterID
     * @param sitterID: integer of the account ID of the sitter who has accepted the listing, empty values are unfilled listings
     * @param description: the owner's description of the listing
     * @param startDate: the date the pet sitting services are requested to begin on by the owner
     * @param endDate: the date the pet sitting services are to finish by
     * @param active: indicates if the listing should be actively shown in the listings, or if hidden by the owner
     * @param latitude: latitude coordinate of the owner's address, or sitter's address if sleepover
     * @param longitude: longitude coordinate of the owner's address, or sitter's address if sleepover
     * @param isSleepover: integer representing a boolean value whether this listing is a sleepover or not
     */
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

    /**
     * Fetches data from the server for this listing. Current application context is passed in
     * @param context: the calling context
     */
    public void getListing(Context context){
        double curLatitude = 39.322945;
        double curLongitude = -76.614172;

        try {
            // Build the API endpoint from the listing ID and current location
            // The current location is used to calculate how far the sitter's
            // phone is from the listing
            String endpoint = "postings/detail.php?id="+listingID+"&lat=39.322945&long=76.614172";
            Log.w("MA", "Calling endpoint " + endpoint);

            // Create the APICall object and send the get request to the system
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            Log.w("MA", "Received response: " + jsonObject);
            // Parse the response back from the system
            JSONObject listingDetail = jsonObject.getJSONObject("listingDetail");

            distance = jsonObject.getInt("distance");

            // Parse the owner's information from the response
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

            // Create an owner object for this listing
            this.owner = new Owner(posterID, ownerFirstName, ownerLastName, street, city, state, zipcode, email, phone);

            // Parse the pet information and create a Pet object for this listing
            int petId = listingDetail.getJSONObject("pet").getInt("petId");
            String petName = listingDetail.getJSONObject("pet").getString("name");
            int petWeight = listingDetail.getJSONObject("pet").getInt("weight");
            String petSize = listingDetail.getJSONObject("pet").getString("size");
            String petBreed = listingDetail.getJSONObject("pet").getString("breed");
            int petOwnerId = listingDetail.getJSONObject("pet").getInt("ownerId");
            this.pet = new Pet(petId, petName, petWeight, petSize, petBreed, petOwnerId);

            // Parse the listing information
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

    /**
     *
     * @param distance: manually set the distance integer
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return the distance from the sitter to the listing
     */
    public int getDistance() {
        return this.distance;
    }

    /**
     * @return the listing's ID number
     */
    public int getListingID(){
        return listingID;
    }

    /**
     * @return the pet owner's (who created the listing) owner ID number
     */
    public int getPosterID(){
        return posterID;
    }

    /**
     * @return the pet's ID number who the listing is created for
     */
    public int getPetID(){
        return petID;
    }

    /**
     * @return the sitter's ID number who has accepted the listing, otherwise 0
     */
    public int getSitterID(){
        return sitterID;
    }

    /**
     * @return the description of the listing set by the pet owner
     */
    public String getDescription(){
        return description;
    }

    /**
     * @return string representing the date when the listing begins
     */
    public String getStartDate(){
        return startDate;
    }

    /**
     * @return string representing the date when the listing ends
     */
    public String getEndDate(){
        return endDate;
    }

    /**
     * @return int representing if the listing should be actively displayed
     */
    public int getActive(){
        return active;
    }

    /**
     * @return latitude of where the pet listing will occur at
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * @return longitude of where the pet listing will occur at
     */
    public double getLongitude(){
        return longitude;
    }
}
