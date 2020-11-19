package com.patrickauth.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ChangePassword extends AppCompatActivity{

    EditText old;
    EditText new1;
    EditText new2;
    TextView warning;
    Button submit;

    ArrayList<String> passChange = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_change);

        submit = findViewById(R.id.submit_forgot);
        warning = findViewById(R.id.warning);
        warning.setVisibility(View.INVISIBLE);
        ButtonHandler bh = new ButtonHandler();
        submit.setOnClickListener(bh);


        updateView();



    }

    private void updateView(){

        old = (EditText) findViewById(R.id.old_password);
        String old_s = old.getText().toString();
        passChange.add(old_s);

        new1 = (EditText) findViewById(R.id.new_password1);
        String new1_s = new1.getText().toString();
        passChange.add(new1_s);

        new2 = (EditText) findViewById(R.id.new_password2);
        String new2_s = new2.getText().toString();
        passChange.add(new2_s);

        Log.d("MA","Old Password: "+passChange.get(0)+" New Password: "+passChange.get(1)+ " New Password Again: "+passChange.get(2));

    }

    private void checkPasswords(){
        if(passChange.get(1) != passChange.get(2)){
            warning.setVisibility(View.VISIBLE);
        }
        else{
            warning.setVisibility(View.INVISIBLE);
        }
    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){
            checkPasswords();

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
