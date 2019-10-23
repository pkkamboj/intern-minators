package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {
    EditText usernameText = findViewById(R.id.edit_username);
    EditText passwordText = findViewById(R.id.edit_password);
    Button loginButton = findViewById(R.id.button_login);
    TextView responseText = findViewById(R.id.text_error);
    RequestQueue queue = Volley.newRequestQueue(this);
    Intent userLandingIntent = new Intent(this, UserLandingActivity.class);

    private void login(){
        String url = "localhost:3000/api/auth";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                responseText.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseText.setText(error.getMessage());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.setEnabled(false);
                //Make API call to localhost:3000/api/auth/
                //login();
                loginButton.setEnabled(true);
                startActivity(userLandingIntent);
            }
        });
    }
}
