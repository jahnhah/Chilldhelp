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

    @POST("/users")
    Call<LoginResponse> login(@Body LoginRequest auths);

    @FormUrlEncoded
    @POST("/auth/user/inscription")
    Call<ReponseAPI> sign1User(@Field("body") User utilisateur);
}
