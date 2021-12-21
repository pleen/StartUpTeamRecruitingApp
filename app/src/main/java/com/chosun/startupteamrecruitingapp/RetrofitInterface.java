package com.chosun.startupteamrecruitingapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("startup/member")
    Call<Member> register(@Body Member member);

    @GET("startup/university")
    Call<List<University>> getUnivs();
}
