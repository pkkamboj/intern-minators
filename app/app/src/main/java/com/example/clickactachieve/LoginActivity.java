package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;
    Button loginButton;
    TextView responseText;
    final String TAG = "LoginActivity";

    private void login() {
        if (usernameText.getText().toString().equals("user1") && passwordText.getText().toString().equals("password")){
            System.out.println("hi");
            openUserLanding();
        } else if (usernameText.getText().toString().equals("facility1") && passwordText.getText().toString().equals("password")) {
            Log.d(TAG, "login: test");
            openFacilityLanding();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Your username or password is incorrect!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void openUserLanding(){
        Intent intent = new Intent(this, UserLandingActivity.class);
        intent.putExtra("username", "pcciamsuperuser");
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
        loginButton = findViewById(R.id.sign_in);

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

    public void onBackBtnClicked(View v) {
        finish();
    }
}
