package com.example.s2e2.retrofit;

import com.example.s2e2.retrofit.Service.RetrofitService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private static RetrofitService retrofitService;

    private final static String BASE_URL = "http://43.200.85.14:8086/";

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RetrofitService getRetrofitService(){
        return retrofitService;
    }

}
