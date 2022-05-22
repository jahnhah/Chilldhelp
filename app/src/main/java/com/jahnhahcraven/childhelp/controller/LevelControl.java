package com.jahnhahcraven.childhelp.controller;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.GameType;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.service.BaseService;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.home.adapter.CardHomeAdapter;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.level.adapter.LevelAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LevelControl {
    private static LevelControl instance;
    private static BaseService service = BaseService.getInstance();


    public static LevelControl getInstance(){
        if(instance==null){
            LevelControl.instance = new LevelControl();
        }
        return LevelControl.instance;
    }


    public void getLevelGame(LevelActivity page, GridView gridView){
        SessionManager sessionManager = new SessionManager(page);
        User utilisateur = (User) sessionManager.getSessionObject("KEY_USER", User.class);
        Bundle bundle = page.getIntent().getExtras();
        String params = bundle.getString("params");
        Log.e("params",params);
        Game game = new Game();
        game.setGametype(params);
        Call<ReponseAPI> reponse = service.gameService.getAllGameLevel(utilisateur.getToken(),game);
        reponse.enqueue(new Callback<ReponseAPI>() {
            @Override
            public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                if(response.body().getStatus() == 200){
                    ArrayList<Game> array =  new ReponseAPI().fomraterArrayJSONObject((ArrayList<Object>) response.body().getData(),Game.class);
                    Log.e("ok 200: ","ok ça marche"+response.body().getData().toString());
                    LevelAdapter levelAdapter = new LevelAdapter(page,array);
                    gridView.setAdapter(levelAdapter);
                }else{
                    Log.e("status errot type : ",response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ReponseAPI> call, Throwable t) {
                Log.e("Line 48 -- HomeControl",t.getMessage());
            }
        });
    }
}
