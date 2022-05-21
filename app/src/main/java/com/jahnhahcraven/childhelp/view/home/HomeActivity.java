package com.jahnhahcraven.childhelp.view.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.jahnhahcraven.childhelp.R;

import com.jahnhahcraven.childhelp.controller.HomeControl;

import com.jahnhahcraven.childhelp.model.GameType;
import com.jahnhahcraven.childhelp.view.home.adapter.CardHomeAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    ArrayList<GameType> list_game;
    CardHomeAdapter cardHomeAdapter;
    ListView listView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init(){
        getSupportActionBar().hide();
        listView=(ListView) findViewById(R.id.listView_home_cardList);
        loadGameType();
    }



    private void loadGameType(){
        HomeControl.getInstance().getGameType(this,listView);
//        this.list_game=new ArrayList<>(Arrays.asList(gameTypes));
    }

    public ArrayList<GameType> getList_game() {
        Log.e("lis",list_game.toString());
        return list_game;
    }

    public void setList_game(ArrayList<GameType> list_game) {
        this.list_game = list_game;
    }
}