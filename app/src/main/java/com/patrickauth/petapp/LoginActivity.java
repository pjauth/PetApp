package com.patrickauth.petapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = ProfileCreationActivity.class.getSimpleName();


    String email = "";
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

    private void logIn() throws IOException, JSONException {
        Log.d("MA","Clicking Log In");
        email = username.getText().toString();
        Intent intent = new Intent(this, SitterProfilePage.class);
        String email = username.getText().toString();
        intent.putExtra("sitterEmail",email);
//        Sitter sitter = new Sitter(1, "sitter@gmail.com");
//        sitter.getSitter();
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);

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
                    try {
                        logIn();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
