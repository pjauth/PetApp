package com.patrickauth.petapp;

import android.util.Log;

import org.json.JSONObject;

public class SitterProfileRegistrationThread extends Thread{

    private SitterProfRegistration activity;
    public JSONObject j;

    public SitterProfileRegistrationThread(SitterProfRegistration fromActivity, JSONObject j) {
        activity = fromActivity;
        this.j = j;
    }

    public void run(){
        try {
            // Create the JSON object necessary for the PHP registration API
            JSONObject jsonString = new JSONObject().put("newSitter", j);
            // Send the JSON and receive response about status of registration
            APICall registrationCall = new APICall("sitter/registration.php");

            String response = registrationCall.sendJSONPost(jsonString);

            // Get the boolean out of the response for the registration status
            JSONObject responseObject = new JSONObject(response);
            boolean successfulRegistration = responseObject.getBoolean("registration");

            activity.goToSitterProf(successfulRegistration);
        } catch(Exception e){
            Log.d("MA", "Excepption"+e);
        }
    }
}
