package com.jahnhahcraven.childhelp.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.internal.LinkedTreeMap;
import com.jahnhahcraven.childhelp.model.LoginRequest;
import com.jahnhahcraven.childhelp.model.LoginResponse;
import com.jahnhahcraven.childhelp.model.Post;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.service.BaseService;
import com.jahnhahcraven.childhelp.service.IUserService;
import com.jahnhahcraven.childhelp.view.MainActivity;
import com.jahnhahcraven.childhelp.view.SplashActivity;
import com.jahnhahcraven.childhelp.view.auth.LoginActivity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.gson.Gson;

public class UserControl {
    private static UserControl instance;
    private static BaseService service = BaseService.getInstance();
    private SessionManager sessionManager;

    public static UserControl getInstance(){
        if(instance==null){
            UserControl.instance=new UserControl();
        }
        return UserControl.instance;
    }

    public void sign1Feature(Button ciblé, TextView message , Activity pageRecent, Class redirection, User object){
        Call<ReponseAPI> reponse = service.userService.sign1User(object);
        Intent intent = null;
        reponse.enqueue(new Callback<ReponseAPI>() {
            @Override
            public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                Log.e("body",response.body().toString());
                if(response.body().getStatus() == 200){
                    Intent intent  = new Intent(pageRecent, redirection);
                    SessionManager session = new SessionManager(pageRecent);
                    session.setEmail(object.getEmail());
                    pageRecent.startActivity(intent);
                }else{
                    Log.e("Line Code :","Line 54 -- User Control.java");
                    Log.e("Message Error", response.body().getStatus().toString());
                    message.setText("intern Server Error");
                    message.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ReponseAPI> call, Throwable t) {
                Log.e("Line Code :","Line 54 -- User Control.java");
                Log.e("Message Error",t.getMessage());
                message.setText("intern Server Error");
                message.setVisibility(View.VISIBLE);
            }
        });
    }

    public void sign2Feature(Button ciblé, TextView message , Activity pageRecent, Class redirection, User user){
        Log.e("code:",user.toString());
        SessionManager session = new SessionManager(pageRecent);
        Log.e("83 Sin2Feature", "onClick: Eto isika  no key Email "+session.getSessionString("KEY_EMAIL"));
        user.setEmail(session.getSessionString("KEY_EMAIL"));
        Log.e("user :: ",user.toString());
        Call<ReponseAPI> reponse = service.userService.sign2User(user);
        Intent intent = null;
        reponse.enqueue(new Callback<ReponseAPI>() {
            @Override
            public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                //Log.e("status",response.body().getStatus().toString());
                if(response.body().getStatus() == 200){
                    Intent intent  = new Intent(pageRecent, redirection);
                    SessionManager session = new SessionManager(pageRecent);
                    Gson gson = new Gson();
                    User utilisateur = (User) gson.fromJson(gson.toJson(response.body().getData()),User.class);
                    session.setSessionObject("KEY_USER",utilisateur);
                    pageRecent.startActivity(intent);
                    pageRecent.finish();
                    message.setText("Code correct");
                    message.setVisibility(View.VISIBLE);
                }else{
                    //Log.e("Line Code :","Line 54 -- User Control.java");
                    //Log.e("Message Error", response.body().getStatus().toString());
                    message.setText("intern Server Error");
                    message.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ReponseAPI> call, Throwable t) {
                // Log.e("Line Code :","Line 54 -- User Control.java");
                // Log.e("Message Error",t.getMessage());
                message.setText("intern Server Error");
                message.setVisibility(View.VISIBLE);
            }
        });
    }

    public void login(Button ciblé,TextView message,Activity pageRecent,Class redirect,User user){
        Call<ReponseAPI> reponse  = service.userService.login(user);
        Intent intent = null;
        reponse.enqueue(new Callback<ReponseAPI>() {
            @Override
            public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                if(response.body().getStatus() == 200){
                    Intent intent  = new Intent(pageRecent, redirect);
                    SessionManager session = new SessionManager(pageRecent);
                    Gson gson = new Gson();
                    User utilisateur = (User) gson.fromJson(gson.toJson(response.body().getData()),User.class);
                    session.setSessionObject("KEY_USER",utilisateur);
                    pageRecent.startActivity(intent);
                    pageRecent.finish();
                }else{
                    //Log.e("Line Code :","Line 54 -- User Control.java");
                    //Log.e("Message Error", response.body().getStatus().toString());
                    message.setText("Mot de passe incorrecte");
                    message.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ReponseAPI> call, Throwable t) {
                // Log.e("Line Code :","Line 54 -- User Control.java");
                // Log.e("Message Error",t.getMessage());
                message.setText("intern Server Error");
                message.setVisibility(View.VISIBLE);
            }
        });
    }


}
