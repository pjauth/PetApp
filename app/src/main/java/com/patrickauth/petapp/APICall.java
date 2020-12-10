package com.patrickauth.petapp;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

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
        con.setRequestMethod("GET");
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
}
