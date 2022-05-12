package com.jahnhahcraven.childhelp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {
    private static BaseService instance=new BaseService();
    public IPostService postService;
<<<<<<< Updated upstream
=======
    public IUserService userService;
>>>>>>> Stashed changes

    private BaseService(){
        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build();
        postService=retrofit.create(IPostService.class);
<<<<<<< Updated upstream
=======
        userService=retrofit.create(IUserService.class);
>>>>>>> Stashed changes
    }

    public static BaseService getInstance(){
        return instance;
    }

}
