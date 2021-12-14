package com.chosun.startupteamrecruitingapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface univInterface {
    @GET("startup/university")
    Call<List<University>> getUnivs();
}
