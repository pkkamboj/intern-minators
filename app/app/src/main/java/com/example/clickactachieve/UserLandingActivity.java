package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserLandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        setContentView(R.layout.activity_user_landing);
        TextView usernameView = (TextView) findViewById(R.id.hello_usern);
        usernameView.setText("Hello, \n".concat(username));
    }

    public void clickBookActivity(View v) {
        Intent intent = new Intent(this, BookNowDashBoardActivity.class);
        startActivity(intent);
    }

    public void clickMyBookings(View v) {
        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("Booked",true);
        startActivity(intent);
    }
}
