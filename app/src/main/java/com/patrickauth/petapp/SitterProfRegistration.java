package com.patrickauth.petapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SitterProfRegistration extends AppCompatActivity {
    Button submit;
    EditText editFirstName, editLastName, editPhone, editEmail, editStreet, editCity, editState, editZipCode, editPassword1, editPassword2;
    String firstName, lastName, phone, email, street, city, state, password1, password2;
    int zipcode;
    SharedPreferences sharedPreferences;
    public static final String SITTER_PREFS = "SitterPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_prof_registration);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        sharedPreferences = getSharedPreferences(SITTER_PREFS, Context.MODE_PRIVATE);

        ButtonHandler bh = new ButtonHandler();

        submit = findViewById(R.id.next_sitter_registration_page);
        submit.setOnClickListener(bh);

    }

    private void sendRegistration(){




        editFirstName = findViewById(R.id.sitter_first);
        firstName = editFirstName.getText().toString();

        editLastName = findViewById(R.id.sitter_last);
        lastName = editLastName.getText().toString();

        editPhone = findViewById(R.id.sitter_phone);
        phone = editPhone.getText().toString();

        editEmail = findViewById(R.id.sitter_email);
        email = editEmail.getText().toString();

        editStreet = findViewById(R.id.sitter_street);
        street = editStreet.getText().toString();

        editCity = findViewById(R.id.sitter_city);
        city = editCity.getText().toString();

        editState = findViewById(R.id.sitter_state);
        state = editState.getText().toString();

        editZipCode = findViewById(R.id.sitter_zipcode);
        zipcode = Integer.parseInt(editZipCode.getText().toString());

        editPassword1 = findViewById(R.id.sitter_password);
        password1 = editPassword1.getText().toString();

        editPassword2 = findViewById(R.id.sitter_confirm_password);
        password2 = editPassword2.getText().toString();

        // Create an empty byte array to store the password digest
        byte[] passwordDigest = null;

        try {
            // Check that the passwords are equal
            if (password1.equals(password2)) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(password1.getBytes());
                passwordDigest = md.digest();
            } else {
                Toast.makeText(this, "Please enter passwords that match", Toast.LENGTH_LONG).show();
                return;
            }
        } catch(NoSuchAlgorithmException e) {
            Log.w("MA", "SHA not supported on this device");
            return;
        }


        Log.w("MA", "Password Digest: " + passwordDigest);
        try {
            // Convert the digest's byte array to a string for the database
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : passwordDigest) {
                stringBuffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            String passwordDigestString = stringBuffer.toString();

            JSONObject sitterJSON = new JSONObject().put("firstName", firstName)
                    .put("lastName", lastName)
                    .put("email", email)
                    .put("phone", phone)
                    .put("address", street)
                    .put("city", city)
                    .put("state", state)
                    .put("zipcode", zipcode)
                    .put("password", passwordDigestString);

            SitterProfileRegistrationThread task = new SitterProfileRegistrationThread( this , sitterJSON);
            Log.w( "MA", "Start thread" );
            task.start( );
            Log.w( "MA", "Inside onCreate, Thread started" );

//            // Create the JSON object necessary for the PHP registration API
//            JSONObject jsonString = new JSONObject().put("newSitter", sitterJSON);
//            // Send the JSON and receive response about status of registration
//            APICall registrationCall = new APICall("sitter/registration.php");
//
//            String response = registrationCall.sendJSONPost(jsonString);
//
//            // Get the boolean out of the response for the registration status
//            JSONObject responseObject = new JSONObject(response);
//            boolean successfulRegistration = responseObject.getBoolean("registration");


        } catch(Exception e) {
            Log.d("MA", "Exception" + e);
        }
    }

    public void goToSitterProf(Boolean successfulRegistration){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(successfulRegistration) {
            // Only save the registered profile if the response is valid
            editor.putString("firstName", firstName);
            editor.putString("lastName", lastName);
            editor.putString("phone", phone);
            editor.putString("email", email);
            editor.putString("street", street);
            editor.putString("email", city);
            editor.putString("state", state);
            editor.putInt("zipcode", zipcode);
            editor.apply();

            Intent intent = new Intent(this, SitterProfilePage.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, 0);
        } else {
            Toast.makeText(this, "There was an error creating your account. Please try again.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SitterProfilePage.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, 0);
        }
    }

    private void go_to_preference_registration() {
        Intent intent = new Intent(this, SitterProfilePage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    private void go_back_to_intro() {

        Intent intent = new Intent(this, IntroPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, 0);

    }

    private class ButtonHandler implements View.OnClickListener {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.next_sitter_registration_page:
                    sendRegistration();
                    break;
            }

        }
    }
}
