package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;


public class LoginActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;
    Button loginButton;
    TextView responseText;
    final String TAG = "LoginActivity123";

    private void login() {
        if (usernameText.getText().toString().equals("username") && passwordText.getText().toString().equals("password")){
            System.out.println("hi");
            openUserLanding();
        } else if (usernameText.getText().toString().equals("facility") && passwordText.getText().toString().equals("password")) {
            Log.d(TAG, "login: test");
            openFacilityLanding();
        }

        /*URL apiUrl = new URL("http://10.0.2.2:3000/api/auth/login") ;
        HttpURLConnection urlConnection = (HttpURLConnection) apiUrl.openConnection();

        try {
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());

        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("username", usernameText.getText().toString());
        map.put("password", passwordText.getText().toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);

        HttpRequest request = HttpRequest.newBuilder(apiUrl)
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(requestBody))
                .build();

        HttpClient.newHttpClient()
                .sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(System.out::println);*/

        /*Log.d(TAG, "1");
        String apiUrl = "http://10.0.2.2:3000/api/auth/login";
        Log.d(TAG, "2");
        RequestBody requestBody
        Log.d(TAG, "3");
        final Request loginRequest = new Request.Builder()
                .url(apiUrl)
                .post(requestBody)
                .header("Content-Type","application/json")
                .build();
        Log.d(TAG, "4");
        Runnable r = new Runnable() {
            public void run() {
                try {
                    Log.d(TAG, "6");
                    Response response = new OkHttpClient().newCall(loginRequest).execute();
                    Log.d(TAG, response.message() + response.toString());
                    responseText.setText(response.message());
                    Log.d(TAG, "7");
                }
                catch (Exception e){
                    Log.d(TAG,  e.toString());
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
        Log.d(TAG, "5");*/
    }

    private void openUserLanding(){
        Intent intent = new Intent(this, UserLandingActivity.class);
        startActivity(intent);
    }

    private void openFacilityLanding() {
        Intent intent = new Intent(this, FacilityLandingActivity.class);
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
                login();
                loginButton.setEnabled(true);
            }
        });
    }
}
