package com.example.s2e2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int countBloodDonation = 30;
    private int lastDay = 365;
    private int passDay = 365;

    private NotificationHelper notificationHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        TextView bloodCountTextView = findViewById(R.id.countBloodView);

        String str = String.valueOf(countBloodDonation);
        bloodCountTextView.setText(str);

        Button lastDayButton = findViewById(R.id.lastDayButton);
        lastDayButton.setText(calculateLastDay());

        TextView lastBloodDonationDay = findViewById(R.id.lastBloodDonationDayTextView);
        lastBloodDonationDay.setText(lastBloodDonationDayText());

    }

    private String lastBloodDonationDayText(){
        return "2022.2.6";
    }

    private String calculateLastDay() {
        if (lastDay - passDay == 0) {
            return "D-Day";
        }
        return (lastDay - passDay) + "-day";
    }

    public void goToMapPage(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void setCount(int count) {
        this.countBloodDonation = count;
    }

    public void setLastDay(int lastDay) {
        this.lastDay = lastDay;
    }

    private boolean menuBarOption = true;
    public void showMenuBar(View view) {
        Button lastDayButton = findViewById(R.id.lastDayButton);
        RelativeLayout relativeLayout = findViewById(R.id.menuBar);
        if (menuBarOption) {
            relativeLayout.setVisibility(View.VISIBLE);
            lastDayButton.setVisibility(View.GONE);
            menuBarOption = false;
        } else{
            relativeLayout.setVisibility(View.GONE);
            lastDayButton.setVisibility(View.VISIBLE);
            menuBarOption = true;
        }
    }

    static public void increaseCountBloodDonation(){
        countBloodDonation++;
    }

    public int getCountBloodDonation() {
        return countBloodDonation;
    }
}