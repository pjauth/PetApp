package com.patrickauth.petapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    // private static final String TAG = ProfileCreationActivity.class.getSimpleName();
    private EditText username;
    private EditText password;
    String email, rawPassword;
    private Button forgotPass;
    private Button loginSubmit;
    ArrayList<String> sitter_info = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButtonHandler bh = new ButtonHandler();
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.username_field);
        password = (EditText) findViewById(R.id.password_field);
        forgotPass = findViewById(R.id.forgot_password);
        forgotPass.setOnClickListener(bh);
        loginSubmit = findViewById(R.id.login_submit);
        loginSubmit.setOnClickListener(bh);


        try {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
            }
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            Log.w("MA", "PHONE LOCATION IS " + latitude + " LONG: " + longitude);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void logIn() throws IOException, JSONException {
        Log.d("MA","Clicking Log In");
        email = username.getText().toString();
        rawPassword = password.getText().toString();

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
            md.update(rawPassword.getBytes());
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

        // Create the final JSON request
        credentialsJSON.put("email", email).put("password", passwordDigestString);
        loginObject.put("login", credentialsJSON);

        // Initialize the API call with the login endpoint
        APICall loginCall = new APICall("sitter/login.php");

        // Send the POST request and capture response
        String response = loginCall.sendJSONPost(loginObject);

        // Get the boolean out of the response for the registration status
        JSONObject responseObject = new JSONObject(response);
        boolean successfulLogin = responseObject.getBoolean("login");

        if(successfulLogin) {
            Intent intent = new Intent(this, SitterProfilePage.class);
            String email = username.getText().toString();
            intent.putExtra("sitterEmail", email);
            //        Sitter sitter = new Sitter(1, "sitter@gmail.com");
            //        sitter.getSitter();
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, 0);
        }

        Toast.makeText(this, "There was an error logging you in, please try again.", Toast.LENGTH_LONG).show();
    }




    private void go_to_password_change(){
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    public class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){
            switch(v.getId()) {
                case R.id.login_submit:
                    try {
                        logIn();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.forgot_password:
                    go_to_password_change();
                    break;
            }
        }

    }

    protected void onStart( ) {
        super.onStart( );
        Log.w( "MA", "Inside MainActivity::onStart" );
    }

    protected void onRestart( ) {
        super.onRestart( );
        Log.w( "MA", "Inside MainActivity::onRestart" );
    }

    protected void onResume( ) {
        super.onResume( );
        Log.w( "MA", "Inside MainActivity::onResume" );
    }

    protected void onPause( ) {
        super.onPause( );
        Log.w( "MA", "Inside MainActivity::onPause" );
    }

    protected void onStop( ) {
        super.onStop( );
        Log.w( "MA", "Inside MainActivity::onStop" );
    }

    protected void onDestroy( ) {
        super.onDestroy( );
        Log.w( "MA", "Inside MainActivity::onDestroy" );
    }
}
