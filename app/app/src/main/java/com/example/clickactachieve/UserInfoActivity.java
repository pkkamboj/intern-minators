package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        /*public void onFacilityTypeClicked(View v) {
            Intent intent = new Intent(this, FacilityInfoActivity.class);
            startActivity(intent);
        }*/

        //TO DO: create a new user in the user table?

    }

    public void clickNext() {
        Intent intent = new Intent(this, FacilityInfoActivity.class);
        startActivity(intent);
    }
}
