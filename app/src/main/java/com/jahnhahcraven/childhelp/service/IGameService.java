package com.jahnhahcraven.childhelp.service;

import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface IGameService {
    @GET("/game/gametype")
    Call<ReponseAPI> getAllGameType(@Header("token") String token);
}
