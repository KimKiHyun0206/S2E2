package com.example.s2e2.retrofit.Service;

import com.example.s2e2.retrofit.domain.BloodDonation;
import com.example.s2e2.retrofit.domain.BloodDonationHouse;
import com.example.s2e2.retrofit.domain.BloodDonationHouses;
import com.example.s2e2.retrofit.domain.Status;
import com.example.s2e2.retrofit.dto.BloodDonationHouseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("bloodDonation/{id}")
    Call<BloodDonation> getInfo(@Path("id") Long id);

    //ViewResoler 처럼 감싸서 보내는 과정
    //
    @POST("bloodDonation/day")
    Call<Status> updateInfo(@Body Status status);

    //매개값을 하나
    @GET("bloodDonation/findAll")
    Call<List<BloodDonationHouse>> getBloodDonationHouse();
}

