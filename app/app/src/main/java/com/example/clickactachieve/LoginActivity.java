package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;


public class LoginActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;
    Button loginButton;
    TextView responseText;

    private void login(){
        String apiUrl = "localhost:3000/api/auth";
        try{
            RequestBody body = new FormBody.Builder()
                    .add("usename",usernameText.getText().toString())
                    .add("password",passwordText.getText().toString())
                    .build();

            Request loginRequest = new Request.Builder()
                    .url(apiUrl)
                    .header("Content-Type","application/json")
                    .method("POST", body)
                    .build();
        }
        catch(Exception e){
            
        }
    }

    private void openUserLanding(){
        Intent intent = new Intent(this, UserLandingActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameText = findViewById(R.id.edit_username);
        passwordText = findViewById(R.id.edit_password);
        responseText = findViewById(R.id.text_error);
        loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.setEnabled(false);
                //Make API call to localhost:3000/api/auth/
                //login();
                loginButton.setEnabled(true);
                openUserLanding();
            }
        });
    }
}
