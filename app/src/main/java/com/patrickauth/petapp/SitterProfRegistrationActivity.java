package com.patrickauth.petapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SitterProfRegistrationActivity extends AppCompatActivity {
    Button back;
    Button submit;
    EditText editFirstName, editLastName, editPhone, editEmail, editStreet, editCity, editState, editZipCode;
    String firstName, lastName, phone, email, street, city, state;
    int zipcode;
    SharedPreferences sharedPreferences;
    public static final String SITTER_PREFS = "SitterPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_prof_registration);

        sharedPreferences = getSharedPreferences(SITTER_PREFS, Context.MODE_PRIVATE);

        ButtonHandler bh = new ButtonHandler();

        back = findViewById(R.id.back);
        back.setOnClickListener(bh);

        submit = findViewById(R.id.next_sitter_registration_page);
        submit.setOnClickListener(bh);

    }

    private void sendRegistration(){

        APICall registrationCall = new APICall("sitter/registration.php");

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editFirstName = findViewById(R.id.sitter_first);
        firstName = editFirstName.getText().toString();
        editor.putString("firstName", firstName);

        editLastName = findViewById(R.id.sitter_last);
        lastName = editLastName.getText().toString();
        editor.putString("lastName", lastName);

        editPhone = findViewById(R.id.sitter_phone);
        phone = editPhone.getText().toString();
        editor.putString("phone", phone);

        editEmail = findViewById(R.id.sitter_email);
        email = editEmail.getText().toString();
        editor.putString("email", email);

        editStreet = findViewById(R.id.sitter_street);
        street = editStreet.getText().toString();
        editor.putString("street", street);

        editCity = findViewById(R.id.sitter_city);
        city = editCity.getText().toString();
        editor.putString("email", city);

        editState = findViewById(R.id.sitter_state);
        state = editState.getText().toString();
        editor.putString("state", state);

        editZipCode = findViewById(R.id.sitter_zipcode);
        zipcode = Integer.parseInt(editZipCode.getText().toString());
        editor.putInt("zipcode", zipcode);
        editor.apply();

        try {
            JSONObject sitterJSON = new JSONObject().put("firstName", firstName)
                    .put("lastName", lastName)
                    .put("email", email)
                    .put("phone", phone)
                    .put("address", street)
                    .put("city", city)
                    .put("state", state)
                    .put("zipcode", zipcode);
            JSONObject jsonString = new JSONObject().put("newSitter", sitterJSON);
            registrationCall.sendJSONPost(jsonString);

            // Log.w("MA", "First: "+ sitter_info.get(0)+", Last: "+sitter_info.get(1)+", Phone: "+sitter_info.get(2));

            Intent intent = new Intent(this, SitterProfilePage.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, 0);
        } catch(JSONException e) {

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

                case R.id.back:
                    go_back_to_intro();
                    break;

                case R.id.next_sitter_registration_page:
                    sendRegistration();
                    break;
            }

        }
    }
}
