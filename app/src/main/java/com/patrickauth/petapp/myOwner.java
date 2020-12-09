package com.patrickauth.petapp;

import android.util.Log;

import org.json.JSONObject;

public class Owner {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    protected Address address;
    protected Pet pet;

    public Owner(int id) {
        this.id = id;
    }

    public void getProfile() {

                try {
                    String endpoint = "owner/get_profile.php?id="+id;
                    Log.w("MA", "***** Calling endpoint:" + endpoint);
                    APICall profileCall = new APICall(endpoint);
                    JSONObject jsonObject = profileCall.sendRequest("GET");
                    Log.w("MA", "Received response:" + jsonObject);
                    firstName = jsonObject.getString("firstName");
                    lastName = jsonObject.getString("lastName");
                    String street = jsonObject.getString("street");
                    String city = jsonObject.getString("city");
                    String state = jsonObject.getString("state");
                    int zipcode = jsonObject.getInt("zipcode");
                    address = new Address(street, city, state, zipcode);
                    email = jsonObject.getString("email");
                    phone = jsonObject.getString("phone");
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
}
