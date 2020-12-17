package com.patrickauth.petapp;

import android.util.Log;

import org.json.JSONObject;

/**
 * This class serves as the Model for Pet Sitter users. Sitter instances can be created by passing in
 * the Sitter's ID and String email address to the constructor. Accurate and updated data on the Sitter
 * can be fetched from the PetPanion server using {@code getSitter()}.
 *
 * @author Pat Auth, Conor O'Brien
 * @version 1.0
 * @since 2020-12-16
 */
public class Sitter {

    int sitterID;
    String firstName;
    String lastName;
    String preference;
    int jobCount;
    float rating;
    int points;
    String email;
    String phone;
    String address;
    String city;
    String state;
    int zipCode;


    public Sitter(int sitterID, /*String firstName, String lastName, String preference, int jobCount,
            float rating, int points,*/ String email/*, String phone, String address, String city,
            String state, int zipCode*/){
        this.sitterID = sitterID;
        this.firstName =firstName;
        this.lastName = lastName;
        this.preference = preference;
        this.jobCount = jobCount;
        this.preference = preference;
        this.rating = rating;
        this.points = points;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;

    }

    /**
     * Issues an API call to fetch the sitter's profile from the server using an email address
     * and sets this sitter's profile variables to what is fetched from the API
     * @return JSON object containing the Sitter profile
     */
    public JSONObject getSitter(){
        try {
            String endpoint = "sitter/get_profile_email.php?email="+email;
            Log.w("MA", "***** Calling endpoint:" + endpoint);
            APICall profileCall = new APICall(endpoint);
            JSONObject jsonObject = profileCall.sendRequest("GET");
            Log.w("MA", "Received response:" + jsonObject);
            firstName = jsonObject.getString("firstName");
            lastName = jsonObject.getString("lastName");
            address = jsonObject.getString("street");
            city = jsonObject.getString("city");
            state = jsonObject.getString("state");
            zipCode = jsonObject.getInt("zipcode");
            email = jsonObject.getString("email");
            phone = jsonObject.getString("phone");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * @return the Sitter's unique account ID
     */
    public int getSitterID(){
        return sitterID;
    }

    /**
     * @return the Sitter's first name as a String
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * @return the Sitter's last name as a String
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * @deprecated not currently in use
     */
    public String getPreference(){
        return preference;
    }

    /**
     * @return the number of completed jobs done by the sitter
     */
    public int getJobCount(){
        return jobCount;
    }

    /**
     * @deprecated not currently in use
     */
    public float getRating(){
        return rating;
    }

    /**
     * @deprecated not currently in use
     */
    public int getPoints(){
        return points;
    }

    /**
     * @return the Sitter's email address as a String
     */
    public String getEmail(){
        return email;
    }

    /**
     * @return the Sitter's phone number as a String
     */
    public String getPhone(){
        return phone;
    }

    /**
     * @return the Sitter's street address as a string
     */
    public String getAddress(){
        return address;
    }

    /**
     * @return the Sitter's city or town
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the Sitter's state as a 2 character length abbreviated String
     */
    public String getState(){
        return state;
    }

    /**
     * @return the Sitter's postal code as an int
     */
    public int getZipCode(){
        return zipCode;
    }

}
