package com.example.s2e2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //현재 내가 헌혈한 횟수
    private int countBloodDonationData = 30;
    //남은 날
    private int lastDayData = 365;
    //헌혈한 날로부터 지난 날
    private int passDayData = 36;
    //true면 메뉴바가 보이고 false면 보이지 않음
    private boolean menuBarOption = true;
    //마지막 헌혈한 날짜가 언제인지 저장하는 변수
    private String lastBloodDonationDayData = "2022.2.6";




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dDayButton = findViewById(R.id.countLastDayButton);

        TextView lastBloodDonationDay = findViewById(R.id.lastBloodDonationDay);

        TextView countBloodDonation = findViewById(R.id.countBloodDonationTextview);

        dDayButton.setText(dDayButtonShow());
        lastBloodDonationDay.setText(getLastBloodDonationDay());
        countBloodDonation.setText(String.valueOf(countBloodDonationData));


    }

    private String dDayButtonShow(){
        if(lastDayData - passDayData <=0){
            return "D-Day";
        }
        return lastDayData - passDayData +"-Day";
    }

    private String getLastBloodDonationDay(){
        return lastBloodDonationDayData;
    }

    public int getCountBloodDonationData() {
        return countBloodDonationData;
    }

    //남은 날을 보여주기 위한 메소드
    private String calculateLastDay() {
        if (lastDayData - passDayData == 0) {
            return "D-Day";
        }
        return (lastDayData - passDayData) + "-day";
    }

    //화면 이동 메소드 - 지도 페이지
    public void goToMapPage(View view) {
        if(lastDayData - passDayData <=0){
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        }
    }

    //메뉴바를 보이게 하는 메소드
    public void showMenuBar(View view) {
        Button lastDayButton = findViewById(R.id.countLastDayButton);
        ScrollView scrollView = findViewById(R.id.scrollBar);
        if (menuBarOption) {
            scrollView.setVisibility(View.VISIBLE);
            lastDayButton.setVisibility(View.GONE);
            menuBarOption = false;
        } else{
            scrollView.setVisibility(View.GONE);
            lastDayButton.setVisibility(View.VISIBLE);
            menuBarOption = true;
        }
    }
}