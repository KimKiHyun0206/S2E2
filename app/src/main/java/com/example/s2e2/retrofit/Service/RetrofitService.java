package com.example.s2e2.retrofit.Service;

import com.example.s2e2.retrofit.domain.BloodDonation;
import com.example.s2e2.retrofit.domain.BloodDonationHouse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("/{id}")
    Call<BloodDonation> getBloodDonation(@Query("id") Long id);

    @GET("헌혈의집 URL주소")
    Call<BloodDonationHouse> getBloodDonationHouse(@Query("serviceKey") String serviceKey,
                                                   @Query("id") Long id);
}