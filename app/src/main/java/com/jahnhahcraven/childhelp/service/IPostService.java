package com.jahnhahcraven.childhelp.service;


import com.jahnhahcraven.childhelp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface  IPostService {
    @GET("Posts")
    Call<List<Post>> getAllPost();
    @GET("Posts/{id}")
    Call<Post> getPost(@Path("id") int zipcode);
}
