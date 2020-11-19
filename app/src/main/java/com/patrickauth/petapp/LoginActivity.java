package com.patrickauth.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Button forgotPass;
    ArrayList<String> sitter_info = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButtonHandler bh = new ButtonHandler();
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login);
        username = (TextView) findViewById(R.id.username_field);
        password = (TextView) findViewById(R.id.password_field);
        forgotPass = findViewById(R.id.forgot_password);
        forgotPass.setOnClickListener(bh);
    }

    private void go_to_password_change(){
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){
            switch(v.getId()) {
                case R.id.login_submit:
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
