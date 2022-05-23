package com.jahnhahcraven.childhelp.model;

import com.google.gson.annotations.SerializedName;
import com.jahnhahcraven.childhelp.service.IPostService;

import java.util.List;

import retrofit2.Call;

public class Post {
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;
//    CONSTRUCTOR

    public Post(){}
    public Post(int userId, int id, String title, String text) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.text = text;
    }

//    GETTER AND SETTERS

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    LOGICS


}
