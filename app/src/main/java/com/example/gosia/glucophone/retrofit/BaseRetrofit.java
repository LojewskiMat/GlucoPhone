package com.example.gosia.glucophone.retrofit;

import android.support.annotation.NonNull;

import com.example.gosia.glucophone.service.PomiaryApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRetrofit {

    private static String ENDPOINT = "http://10.0.2.2:3000/";

    private final Retrofit retrofit;
    private final PomiaryApi pomiaryApi;

    public BaseRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build();

        pomiaryApi = retrofit.create(PomiaryApi.class);
    }

    @NonNull
    private Gson getGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setLenient()
                .create();
    }

    public PomiaryApi getPomiarApi() {
        return pomiaryApi;
    }
}