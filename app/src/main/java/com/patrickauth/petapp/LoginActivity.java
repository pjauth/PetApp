package com.patrickauth.petapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = ProfileCreationActivity.class.getSimpleName();


    private EditText username;
    private EditText password;
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






    }

    private void logIn(){
        Log.d("MA","Clicking Log In");
        String user = username.getText().toString();
        String pass = password.getText().toString();


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
                    logIn();
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
