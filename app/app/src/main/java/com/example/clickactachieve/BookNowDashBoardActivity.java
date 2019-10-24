package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookNowDashBoardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booknow_dashboard);
    }

    public void onPhyscialBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        startActivity(intent);
    }
}
