package com.example.s2e2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.s2e2.retrofit.Service.RetrofitService;
import com.example.s2e2.retrofit.RetrofitClient;
import com.example.s2e2.retrofit.domain.BloodDonation;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //현재 내가 헌혈한 횟수
    private int blood_Donation_Count;
    //헌혈 가능일까지 남은 날짜
    private int blood_Donation_Available_Date;
    //true면 메뉴바가 보이고 false면 보이지 않음
    private boolean menuBarOption = true;
    //마지막 헌혈한 날짜가 언제인지 저장하는 변수
    private LocalDateTime blood_Donation_Date;

    private RetrofitClient retrofitClient;
    private RetrofitService retrofitService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitClient = RetrofitClient.getInstance();
        retrofitService = retrofitClient.getRetrofitService();
        
        Call<BloodDonation> call = retrofitService.getBloodDonation(1L);
        
        call.enqueue(new Callback<BloodDonation>() {
            @Override
            public void onResponse(@NotNull Call<BloodDonation> call, @NotNull Response<BloodDonation> response) {
                if (response.isSuccessful()) {
                    BloodDonation body = response.body();
                    Log.d("TEST","GET 성공성공");
                    Log.d("TEST", body.toString());
                    blood_Donation_Count = body.getBlood_Donation_Count();
                    blood_Donation_Date = body.getBlood_Donation_Date();
                    blood_Donation_Available_Date = body.getBlood_Donation_Available_Date();
                }
            }
            @Override
            public void onFailure(Call<BloodDonation> call, Throwable t) {
                t.printStackTrace();
            }
        });

        Button dDayButton = findViewById(R.id.countLastDayButton);

        TextView lastBloodDonationDay = findViewById(R.id.lastBloodDonationDay);

        TextView countBloodDonation = findViewById(R.id.countBloodDonationTextview);

        dDayButton.setText(dDayButtonShow());
        lastBloodDonationDay.setText(getLastBloodDonationDay());
        countBloodDonation.setText(String.valueOf(blood_Donation_Count));

    }

    private String dDayButtonShow(){
        if(blood_Donation_Available_Date <=0){
            return "D-Day";
        }
        return blood_Donation_Available_Date +"-Day";
    }

    private String getLastBloodDonationDay(){
        return String.valueOf(blood_Donation_Date);
    }

    public int getBlood_Donation_Count() {
        return blood_Donation_Count;
    }


    //화면 이동 메소드 - 지도 페이지
    public void goToMapPage(View view) {
        if(blood_Donation_Available_Date <=0){
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