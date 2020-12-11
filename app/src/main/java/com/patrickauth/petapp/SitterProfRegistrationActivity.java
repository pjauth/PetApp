package com.patrickauth.petapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class SitterProfRegistrationActivity extends AppCompatActivity {
    Button back;
    Button submit;
    EditText sitter_first, sitter_last, sitter_phone, sitter_email, street, city, state, zipcode;
    SharedPreferences sharedPreferences;
    public static final String SITTER_PREFS = "SitterPrefs" ;
    ArrayList<String> sitter_info = new ArrayList<String>();


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

    private void get_sitter_info(){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        sitter_first = findViewById(R.id.sitter_first);
        editor.putString("firstName", sitter_first.getText().toString());

        sitter_last = findViewById(R.id.sitter_last);
        editor.putString("lastName", sitter_last.getText().toString());

        sitter_phone = findViewById(R.id.sitter_phone_number);
        editor.putString("phone", sitter_phone.getText().toString());

        sitter_email = findViewById(R.id.sitter_email);
        editor.putString("email", sitter_email.getText().toString());

        street = findViewById(R.id.sitter_street);
        editor.putString("street", street.getText().toString());

        city = findViewById(R.id.sitter_city);
        editor.putString("email", sitter_email.getText().toString());

        state = findViewById(R.id.sitter_state);
        editor.putString("state", state.getText().toString());

        zipcode = findViewById(R.id.zip_code);
        editor.putInt("zipcode", Integer.parseInt(zipcode.getText().toString()));
        editor.apply();

        Log.w("MA", "First: "+sitter_info.get(0)+", Last: "+sitter_info.get(1)+", Phone: "+sitter_info.get(2));

        Intent intent = new Intent(this, SitterProfilePage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);

    }

    private void go_to_preference_registration() {
        Intent intent = new Intent(this, SitterJobPrefCreation.class);
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
                    get_sitter_info();
                    go_to_preference_registration();
                    break;
            }

        }
    }
}
