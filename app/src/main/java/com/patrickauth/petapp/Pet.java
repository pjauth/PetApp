package com.patrickauth.petapp;

import android.util.Log;

import org.json.JSONObject;

/**
 * This class serves as the Model for Pets. Pets belong to a Pet owner and are constructed
 * by passing in all of the class's instance variables.
 *
 * @author Pat Auth, Conor O'Brien
 * @version 1.0
 * @since 2020-12-16
 */
public class Pet {

    int petID;
    String name;
    int weight;
    String size;
    String breed;
    int ownerID;

    public Pet(int petId){
        this.petID = petID;
    }
    public Pet(int petID, String name, int weight, String size, String breed, int ownerID){
        this.petID = petID;
        this.name = name;
        this.weight = weight;
        this.size = size;
        this.breed = breed;
        this.ownerID = ownerID;
    }

    public void getPet(){
        try {
            String endpoint = "pet/get_profile.php?id="+petID;
            Log.w("MA", "***** Calling endpoint:" + endpoint);
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            Log.w("MA", "Received response:" + jsonObject);
            petID = jsonObject.getInt("petID");
            name = jsonObject.getString("name");
            weight = jsonObject.getInt("weight");
            size = jsonObject.getString("size");
            breed = jsonObject.getString("breed");
            ownerID = jsonObject.getInt("ownerID");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPetID(){
        return petID;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    public String getSize(){
        return size;
    }

    public String getBreed(){
        return breed;
    }

    public int getOwnerID(){
        return ownerID;
    }
}
