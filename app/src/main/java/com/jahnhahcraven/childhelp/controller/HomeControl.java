package com.jahnhahcraven.childhelp.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.GameType;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.service.BaseService;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.home.adapter.CardHomeAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeControl {
    private static HomeControl instance;
    private static BaseService service = BaseService.getInstance();


    public static HomeControl getInstance(){
        if(instance==null){
            HomeControl.instance = new HomeControl();
        }
        return HomeControl.instance;
    }


    public void getGameType(HomeActivity page, ListView listView){
        SessionManager sessionManager = new SessionManager(page);
        User utilisateur = (User) sessionManager.getSessionObject("KEY_USER", User.class);
        Call<ReponseAPI> reponse = service.gameService.getAllGameType(utilisateur.getToken());
        reponse.enqueue(new Callback<ReponseAPI>() {
            @Override
            public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                if(response.body().getStatus() == 200){
                    ArrayList<GameType> array =  new ReponseAPI().fomraterArrayJSONObject((ArrayList<Object>) response.body().getData(),GameType.class);
                    CardHomeAdapter cardHomeAdapter = new CardHomeAdapter(page,array);
                    listView.setAdapter(cardHomeAdapter);
                    listView.setDivider(page.getResources().getDrawable(R.color.transparent));
                    listView.setDividerHeight(20);
                }else{
                    Log.e("status errot type : ",response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ReponseAPI> call, Throwable t) {
//                Mi afficher modal eto
                Log.e("Line 48 -- HomeControl",t.getMessage());
            }
        });
    }
}
