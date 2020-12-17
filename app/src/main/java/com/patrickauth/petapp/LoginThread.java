package com.patrickauth.petapp;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginThread extends Thread {

    private LoginActivity activity;
    String username;
    String password;

    public LoginThread( LoginActivity fromActivity, String username, String password) {
        activity = fromActivity;
        this.username = username;
        this.password = password;
    }


    public void run(){
        Log.d("MA","In the Thread");


        // JSON to store the email and password
        JSONObject credentialsJSON = new JSONObject();
        // JSON to wrap the credentials/indentify that it's a login
        JSONObject loginObject = new JSONObject();

        // String to store the password digest
        String passwordDigestString;
        // Byte array to store the digest after it gets hashed initially
        byte[] passwordDigest = null;

        // Create the password digest
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            passwordDigest = md.digest();
        } catch(NoSuchAlgorithmException e) {
            Log.w("MA", "SHA not supported on this device");
            return;
        }

        // Convert the byte array of the digest to a string for JSON
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : passwordDigest) {
            stringBuffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        passwordDigestString = stringBuffer.toString();

        try {
            // Create the final JSON request
            credentialsJSON.put("email", username).put("password", passwordDigestString);
            loginObject.put("login", credentialsJSON);
        } catch (Exception e){
            Log.d("MA", "Exception" + e);
        }
        // Initialize the API call with the login endpoint
        APICall loginCall = new APICall("sitter/login.php");

        // Send the POST request and capture response
        String response = loginCall.sendJSONPost(loginObject);

        try {
            // Get the boolean out of the response for the registration status
            JSONObject responseObject = new JSONObject(response);
            boolean successfulLogin = responseObject.getBoolean("login");
            activity.goToSitterProfilePage(successfulLogin);
        } catch(Exception e){
            Log.d("MA", "Exception "+ e);
        }

    }
}
