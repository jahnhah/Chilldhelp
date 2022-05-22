package com.jahnhahcraven.childhelp.service;

import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IGameService {
    @GET("/game/gametype")
    Call<ReponseAPI> getAllGameType(@Header("token") String token);

    @POST("/game/gameLevel")
    Call<ReponseAPI> getAllGameLevel(@Header("token") String token, @Body() Game game);

    @POST("/game/gameStart")
    Call<ReponseAPI> getGame(@Header("token") String token, @Body() Game game);

}
