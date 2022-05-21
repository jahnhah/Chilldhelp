package com.jahnhahcraven.childhelp.service;

import com.jahnhahcraven.childhelp.model.LoginRequest;
import com.jahnhahcraven.childhelp.model.LoginResponse;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUserService {
    @POST("/auth/user/inscription")
    Call<ReponseAPI> sign1User(@Body User utilisateur);

    @POST("/auth/user/check")
    Call<ReponseAPI> sign2User(@Body User utilisateur);

    @POST("/auth/user/login")
    Call<ReponseAPI> login(@Body User utilisateur);
}
