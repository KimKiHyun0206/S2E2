package com.example.s2e2.retrofit;

import com.example.s2e2.retrofit.domain.BloodDonation;
import com.example.s2e2.retrofit.domain.BloodDonationHouse;
import com.example.s2e2.retrofit.dto.BloodDonationDTO;
import com.example.s2e2.retrofit.dto.BloodDonationHouseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("헌혈 URL주소")
    Call<BloodDonation> getBloodDonation(@Query("serviceKey") String serviceKey,
                                         @Query("id") Long id);

    @GET("헌혈의집 URL주소")
    Call<BloodDonationHouse> getBloodDonationHouse(@Query("serviceKey") String serviceKey,
                                                   @Query("id") Long id);
}
