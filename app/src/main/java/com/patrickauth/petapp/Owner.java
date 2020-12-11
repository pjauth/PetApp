package com.patrickauth.petapp;

import android.util.Log;

import org.json.JSONObject;

public class Owner {
    int ID;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zipCode;
    String email;
    // String password;
    String phone;

    public Owner(int ID) {
        this.ID = ID;
    }

    public Owner(int ID, String firstName, String lastName, String address, String city,
            String state, int zipCode, String email, String phone){

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        // this.password = password;
        this.phone = phone;

    }

    public void getProfile() {

        try {
            String endpoint = "owner/get_profile.php?id="+ID;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getID(){
        return ID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getEmail(){
        return email;
    }

    // public String getPassword(){
    //    return password;
    //}

    public String getPhone(){
        return phone;
    }



}
