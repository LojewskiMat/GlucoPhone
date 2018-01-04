package com.example.gosia.glucophone.service;

import com.example.gosia.glucophone.models.Pomiar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PacjentApi {
    @GET("/pomiary/.json")
    Call<List<Pomiar>> getAllPomiar();

    @GET("/pomiary/{id}")
    Call<Pomiar> getPomiar(@Path("id") Long id);

    @POST("/pomiary")
    Call<Pomiar> postPomiar(@Body Pomiar pomiar);

    @PUT("/pomiary/{id}")
    Call<Pomiar> putPomiar(@Path("id") Long id, @Body Pomiar pomiar);

    @DELETE("/pomiary/{id}")
    Call<Pomiar> deletePomiar(@Path("id") Long id);
}
