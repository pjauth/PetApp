package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


public class OwnerProfRegistrationActivity extends Activity {
    final int petTypeACThreshold = 1;
    Button back;
    String[] pet_types = {"Dog", "Cat", "Parrot", "Fish", "Snake", "Turtle", "Hamster", "Rabbit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_prof_registration);
        ButtonHandler bh =  new ButtonHandler();

        back = findViewById(R.id.pet_creation_form_back);
        back.setOnClickListener(bh);

        ArrayAdapter<String> petTypeAdaptor = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, pet_types);
        AutoCompleteTextView autoCompletePetType = (AutoCompleteTextView) findViewById(R.id.pet_type_autocomplete);
        autoCompletePetType.setThreshold(petTypeACThreshold);
        autoCompletePetType.setAdapter(petTypeAdaptor);
        autoCompletePetType.setTextColor(Color.BLACK);
    }

    private void go_back_to_intro(){

        Intent intent = new Intent(this, IntroPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,0);

    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){

            switch(v.getId()){

                case R.id.back:
                    go_back_to_intro();
                    break;
            }
        }

    }
}
