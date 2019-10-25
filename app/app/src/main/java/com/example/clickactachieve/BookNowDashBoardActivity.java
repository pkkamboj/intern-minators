package com.example.clickactachieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookNowDashBoardActivity extends AppCompatActivity {

    private ViewGroup sideNav;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booknow_dashboard);
        sideNav = findViewById(R.id.side_nav);
    }

    public void onSideNavClicked(View v) {
        sideNav.setVisibility(View.VISIBLE);
    }

    public void onBackgroundClicked(View v) {
        sideNav.setVisibility(View.GONE);
    }

    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onPhysicalBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        intent.putExtra("type", 0);
        startActivity(intent);
    }

    public void onACBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        intent.putExtra("type", 1);
        startActivity(intent);
    }

    public void onLearnBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        intent.putExtra("type", 2);
        startActivity(intent);
    }

    public void onVolunteerBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        intent.putExtra("type", 3);
        startActivity(intent);
    }

    public void allActivitiesBtnClicked(View v) {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }

    public void artsAndCraftBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        startActivity(intent);
    }

    public void learnBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        startActivity(intent);
    }

    public void volunteerBtnClicked(View v) {
        Intent intent = new Intent(this, PickDateActivity.class);
        startActivity(intent);
    }
}
