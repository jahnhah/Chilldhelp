package com.jahnhahcraven.childhelp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {
    private static final BaseService instance = new BaseService();
    public static IPostService postService;
    public static IUserService userService;
    public static IGameService gameService;

    private BaseService(){
        Retrofit retrofit= new Retrofit
                .Builder()
                .baseUrl("http://172.16.224.144:8080")
                .addConverterFactory(GsonConverterFactory.create())
                 .build();
        postService = retrofit.create(IPostService.class);
        userService = retrofit.create(IUserService.class);
        gameService = retrofit.create(IGameService.class);
    }



    public static BaseService getInstance(){
        return instance;
    }

}
