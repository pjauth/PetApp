package com.patrickauth.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button sign_up;
    TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        updateView();



    }

    private void updateView(){

        ButtonHandler bh = new ButtonHandler();

        sign_up = findViewById(R.id.sign_up);
        welcome = findViewById(R.id.welcome);

        sign_up.setVisibility(View.VISIBLE);

        sign_up.setOnClickListener(bh);

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
        updateView();
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

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){

            welcome.setVisibility(View.INVISIBLE);

        }

    }
}