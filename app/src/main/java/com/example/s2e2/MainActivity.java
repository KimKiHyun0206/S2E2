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

    //현재 내가 헌혈한 횟수
    private static int countBloodDonation = 30;
    //남은 날
    private int lastDay = 365;
    //헌혈한 날로부터 지난 날
    private int passDay = 3;
    //true면 메뉴바가 보이고 false면 보이지 않음
    private boolean menuBarOption = true;

    private String lastBloodDonationDay ="2022.2.6";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView bloodCountTextView = findViewById(R.id.countBloodView);

        String str = String.valueOf(countBloodDonation);
        bloodCountTextView.setText(str);

        Button lastDayButton = findViewById(R.id.lastDayButton);
        lastDayButton.setText(calculateLastDay());

        TextView lastBloodDonationDay = findViewById(R.id.lastBloodDonationDayTextView);
        lastBloodDonationDay.setText(lastBloodDonationDayText());
    }


    //마지막 헌혈한 날짜를 보여주기 위한 메소드
    private String lastBloodDonationDayText(){
        return lastBloodDonationDay;
    }

    //남은 날을 보여주기 위한 메소드
    private String calculateLastDay() {
        if (lastDay - passDay == 0) {
            return "D-Day";
        }
        return (lastDay - passDay) + "-day";
    }

    //화면 이동 메소드 - 지도 페이지
    public void goToMapPage(View view) {
        if(lastDay-passDay<=0){
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        }
    }

    //메뉴바를 보이게 하는 메소드
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

    //헌혈 횟수를 증가시키기 위한 메소드
    static public void increaseCountBloodDonation(){
        countBloodDonation++;
    }
}