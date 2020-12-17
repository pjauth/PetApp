///**
// * ProfileCreationView
// * This view is for the creation of a user profile (a pet-sitter or pet-owner)
// */
//package com.patrickauth.petapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class ProfileCreationActivity extends AppCompatActivity {
//    Button pet_sitter;
//    Button view_listings;
//    Button back;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.profile_creation_activity);
//
//        ButtonHandler bh = new ButtonHandler();
//        pet_sitter = findViewById(R.id.pet_sitter_profile_select);
//        view_listings = findViewById(R.id.view_listings);
//        back = findViewById(R.id.back_profile_creation);
//
//        view_listings.setOnClickListener(bh);
//        pet_sitter.setOnClickListener(bh);
//        back.setOnClickListener(bh);
//    }
//
//    private void go_back_to_intro(){
//
//        Intent intent = new Intent(this, IntroPage.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_left,0);
//
//    }
//
//    public void selectedSitterProfile() {
//        Intent intent = new Intent(this, SitterProfRegistration.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right,0);
//    }
//
//    public void viewListings() {
//        Intent intent = new Intent(this, JobListings.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right,0);
//    }
//
//    private class ButtonHandler implements View.OnClickListener{
//
//        public void onClick(View v){
//
//            switch(v.getId()){
//                case R.id.view_listings:
//                    viewListings();
//                    break;
//
//                case R.id.pet_sitter_profile_select:
//                    selectedSitterProfile();
//                    break;
//
//                case R.id.back_profile_creation:
//                    go_back_to_intro();
//                    break;
//            }
//        }
//
//    }
//
//    protected void onStart( ) {
//        super.onStart( );
//        Log.w( "MA", "Inside MainActivity::onStart" );
//    }
//
//    protected void onRestart( ) {
//        super.onRestart( );
//        Log.w( "MA", "Inside MainActivity::onRestart" );
//    }
//
//    protected void onResume( ) {
//        super.onResume( );
//        Log.w( "MA", "Inside MainActivity::onResume" );
//    }
//
//    protected void onPause( ) {
//        super.onPause( );
//        Log.w( "MA", "Inside MainActivity::onPause" );
//    }
//
//    protected void onStop( ) {
//        super.onStop( );
//        Log.w( "MA", "Inside MainActivity::onStop" );
//    }
//
//    protected void onDestroy( ) {
//        super.onDestroy( );
//        Log.w( "MA", "Inside MainActivity::onDestroy" );
//    }
//}
