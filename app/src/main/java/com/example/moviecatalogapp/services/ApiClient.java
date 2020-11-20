package com.example.moviecatalogapp.services;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    public static Retrofit getRetrofit(){
        if (retrofit == null){
            return new Retrofit.Builder()
                    .baseUrl(ApiService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        else {
            return retrofit;
        }
    }

    public static ApiService getApiService(){
        return ApiClient.getRetrofit().create(ApiService.class);
    }
}
