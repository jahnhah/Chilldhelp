package com.jahnhahcraven.childhelp.controller;

import android.util.Log;

import com.jahnhahcraven.childhelp.model.Post;
import com.jahnhahcraven.childhelp.service.BaseService;
import com.jahnhahcraven.childhelp.service.IPostService;

import java.util.List;

import retrofit2.Call;

public class PostControl {
    private static PostControl instance;
    private BaseService service=BaseService.getInstance();
    public static PostControl getInstance(){
        if(instance==null){
            PostControl.instance=new PostControl();
        }
        return PostControl.instance;
    }

    /**
     * controller add new level
     */
    public void addLevel(Post niveau){
        Log.i("Info","Call Model function");
//        Niveau.add(niveau);
    }

    public Call<List<Post>> getAllPost(){
        Call<List<Post>> list = service.postService.getAllPost();
        return list;
    }

    public Call<Post> getPost(int id){
        return service.postService.getPost(id);
    }




}
