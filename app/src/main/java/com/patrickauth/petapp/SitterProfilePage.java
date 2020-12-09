package com.patrickauth.petapp;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class SitterProfilePage extends Activity{

    ImageView sitterPic;
    TextView sitterName;
    TextView sitterPhone;
    TextView sitterPoints;
    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;

    // private SQLiteHandler db;
    // private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitter_profile_page);


        updateView();

        txtName = (TextView) findViewById(R.id.sitter_name);
        txtEmail = (TextView) findViewById(R.id.sitter_phone_number);

        // SqLite database handler
        // db = new SQLiteHandler(getApplicationContext());

        // session manager
        // session = new SessionManager(getApplicationContext());

        // Fetching user details from sqlite
        // HashMap<String, String> user = db.getUserDetails();

        // String name = user.get("name");
        // String email = user.get("email");

        // Displaying the user details on the screen
        // txtName.setText(name);
        // txtEmail.setText(email);

    }

    private void updateView(){
        sitterPic = findViewById(R.id.sitter_pic);
        sitterName = findViewById(R.id.sitter_name);
        sitterPhone = findViewById(R.id.sitter_phone_number);
        sitterPoints = findViewById(R.id.sitter_points);
    }


}
