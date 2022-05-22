package com.jahnhahcraven.childhelp.controller;

import android.app.Activity;
import android.os.Bundle;

import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.service.BaseService;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;

public class GameControl {
    private static GameControl instance;
    private static BaseService service = BaseService.getInstance();


    public static GameControl getInstance(){
        if(instance==null){
            GameControl.instance = new GameControl();
        }
        return GameControl.instance;
    }

    public void getGame(Activity pageRecent){
        SessionManager sessionManager = new SessionManager(pageRecent);
        User utilisateur = (User) sessionManager.getSessionObject("KEY_USER", User.class);
        Game game = new Game();
        Bundle bundle = pageRecent.getIntent().getExtras();
        String params = bundle.getString("params");
        game.set_id(params);
        Call<ReponseAPI> reponse = service.gameService.getGame(utilisateur.getToken(), game);
//        reponse.enqueue();
    }
//    Puzzle


//    letter

//    Number
}
