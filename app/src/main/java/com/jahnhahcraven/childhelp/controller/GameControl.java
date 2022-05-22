package com.jahnhahcraven.childhelp.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.GameType;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.service.BaseService;
import com.jahnhahcraven.childhelp.view.chiffre.ChiffreActivity;
import com.jahnhahcraven.childhelp.view.home.adapter.CardHomeAdapter;
import com.jahnhahcraven.childhelp.view.lettre.LettreActivity;
import com.jahnhahcraven.childhelp.view.puzzle.PuzzleActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
        reponse.enqueue(new Callback<ReponseAPI>() {
            @Override
            public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                if(response.body().getStatus() == 200){
                    Log.e("status success type : ",response.body().getMessage());
                    Gson gson = new Gson();
                    Game game = (Game) gson.fromJson(gson.toJson(response.body().getData()),Game.class);
                    handleGame(pageRecent,game,game.getGametype());
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


    public void handleGame(Activity activity,Game game,String gametype){
        if (gametype.toLowerCase().compareTo("letter")==0) integrateGameLetter((LettreActivity) activity,game);
        if (gametype.toLowerCase().compareTo("number")==0) integrateGameNumber((ChiffreActivity) activity,game);
        if (gametype.toLowerCase().compareTo("puzzle")==0) integrateGamePuzzle((PuzzleActivity) activity,game);
    }

    public void integrateGameNumber(ChiffreActivity activity,Game game){
        activity.setGame(game);
        activity.init();
    }

    public void integrateGameLetter(LettreActivity activity, Game game){
//        activity.setGame(game);
        activity.init();
    }

    public void integrateGamePuzzle(PuzzleActivity activity, Game game){
        activity.setGame(game);
        activity.loadGame();
    }


}
