package com.jahnhahcraven.childhelp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {
    private static final BaseService instance = new BaseService();
    public static IPostService postService;
    public static IUserService userService;

    private BaseService(){
        Retrofit retrofit= new Retrofit
                .Builder()
                .baseUrl("http://172.20.10.3:8080")
                .addConverterFactory(GsonConverterFactory.create())
                 .build();
        postService=retrofit.create(IPostService.class);
        userService=retrofit.create(IUserService.class);
    }



    public static BaseService getInstance(){
        return instance;
    }

}
