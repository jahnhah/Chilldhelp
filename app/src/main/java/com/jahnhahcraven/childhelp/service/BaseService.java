package com.jahnhahcraven.childhelp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {
    private static BaseService instance=new BaseService();
    public IPostService postService;
    public IUserService userService;

    private BaseService(){
        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build();
        postService=retrofit.create(IPostService.class);
        userService=retrofit.create(IUserService.class);
    }

    public static BaseService getInstance(){
        return instance;
    }

}
