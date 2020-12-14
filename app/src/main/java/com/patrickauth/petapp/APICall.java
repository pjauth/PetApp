package com.patrickauth.petapp;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class APICall {
    protected String endpoint = "";
    protected URL urlEndpoint;
    protected final String baseURL = "http://paac.cs.loyola.edu/android/";
    protected String responseString = "";

    public APICall(String endpoint) {
        this.endpoint = baseURL + endpoint /*"sitter/get_profile_email.php?email=sitter@gmail.com"*/;
    }

    public JSONObject sendRequest(String requestType) throws IOException, JSONException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        this.urlEndpoint = new URL(this.endpoint);
        Log.w("MA", "***** FULL ENDPOINT " + urlEndpoint);
        HttpURLConnection con = (HttpURLConnection) urlEndpoint.openConnection();
        Log.w("MA", "***** Connection " + con);
        // optional default is GET
        con.setRequestMethod(requestType);
        con.setRequestProperty("Accept", "application/json");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        Log.w("MA", "***** Response code " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            responseString += inputLine;
            Log.w("MA", "***** Input line " + inputLine);
        }
        in.close();

        //print in String
        System.out.println(responseString);

        //Read JSON response and print
        return new JSONObject(responseString);
    }

    public void sendJSONPost(JSONObject jsonToSend) {
        try {
            this.urlEndpoint = new URL(this.endpoint);
            HttpURLConnection con = (HttpURLConnection) urlEndpoint.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            Log.w("MA", "*** Sending: " + jsonToSend.toString());
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonToSend.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = "";
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                Log.w("MA", "Response: " + response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Listing> requestNearbyListings() {
        ArrayList<Listing> listingsArr = new ArrayList<>();
        try {
            String endpoint = "postings/list.php?lat=39.322920&long=-76.614330&weight=150";
            Log.w("MA", "***** Calling endpoint:" + endpoint);
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            JSONArray nearbyListings = jsonObject.getJSONArray("nearbyListings");

            for(int i = 0; i < nearbyListings.length(); i++) {
                Owner owner;
                Pet pet;
                Listing listing;
                JSONObject itemJSON = nearbyListings.getJSONObject(i).getJSONObject("listing");
                JSONObject ownerJSON = itemJSON.getJSONObject("owner");
                JSONObject petJSON = itemJSON.getJSONObject("pet");
                JSONObject listingJSON = itemJSON.getJSONObject("listingDetails");

                int ownerId = ownerJSON.getInt("id");
                String ownerFirstName = ownerJSON.getString("firstName");
                String ownerLastName = ownerJSON.getString("lastName");
                String street = ownerJSON.getString("street");
                String city = ownerJSON.getString("city");
                String state = ownerJSON.getString("state");
                int zipcode = ownerJSON.getInt("zipcode");
                String email = ownerJSON.getString("email");
                String phone = ownerJSON.getString("phone");

                int petId = petJSON.getInt("petId");
                String petName = petJSON.getString("name");
                int petWeight = petJSON.getInt("weight");
                String petSize = petJSON.getString("size");
                String petBreed = petJSON.getString("breed");
                int petOwnerId = petJSON.getInt("ownerId");

                int listingId = listingJSON.getInt("id");
                int listingPosterId = listingJSON.getInt("posterId");
                int listingPetId = listingJSON.getInt("petId");
                String listingDesc = listingJSON.getString("description");
                String listingSD = listingJSON.getString("startDate");
                String listingED = listingJSON.getString("endDate");
                int listingActive = listingJSON.getInt("active");
                double listingLatitude = listingJSON.getDouble("latitude");
                double listingLongitude = listingJSON.getDouble("longitude");
                int listingIsSleepover = listingJSON.getInt("isSleepover");

                owner = new Owner(ownerId, ownerFirstName, ownerLastName, street, city, state, zipcode, email, phone);
                pet = new Pet(petId, petName, petWeight, petSize, petBreed, petOwnerId);
                listing = new Listing(listingId, listingPosterId, listingPetId, 0, listingDesc, listingSD, listingED, listingActive, listingLatitude, listingLongitude, listingIsSleepover);
                listing.owner = owner;
                listing.pet = pet;
                Log.w("MA", "Listing: " + listing.owner.getAddress());
                listingsArr.add(listing);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listingsArr;
    }
}
