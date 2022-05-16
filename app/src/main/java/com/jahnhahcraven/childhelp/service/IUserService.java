package com.jahnhahcraven.childhelp.service;

import com.jahnhahcraven.childhelp.model.LoginRequest;
import com.jahnhahcraven.childhelp.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUserService {

    @POST("/users")
    Call<LoginResponse> login(@Body LoginRequest auths);
}
