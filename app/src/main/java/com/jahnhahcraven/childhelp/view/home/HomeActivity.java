package com.jahnhahcraven.childhelp.view.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.fragment.buttonGroup.ButtonGroupAdapter;
import com.jahnhahcraven.childhelp.model.GameType;
import com.jahnhahcraven.childhelp.view.home.adapter.CardHomeAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    ArrayList<GameType> list_game;
    CardHomeAdapter cardHomeAdapter;
    ListView listView;

    private void init(){
        getSupportActionBar().hide();
        loadGameType();
        listView=(ListView) findViewById(R.id.listView_home_cardList);
        cardHomeAdapter= new CardHomeAdapter(this, list_game);
        listView.setAdapter(cardHomeAdapter);
        listView.setDivider(this.getResources().getDrawable(R.color.transparent));
        listView.setDividerHeight(20);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        Log.i("GameType",String.valueOf(list_game.size()));
    }

    private void loadGameType(){
        GameType[] gameTypes=new GameType[]{
          new GameType(0,"LETTRE","https://cdn.pixabay.com/photo/2014/10/04/16/55/wooden-cubes-473703_960_720.jpg"),
          new GameType(1,"CHIFFRE","https://cdn.pixabay.com/photo/2019/02/22/19/03/numbers-4014181_960_720.jpg"),
          new GameType(2,"CHIFFRE","https://cdn.pixabay.com/photo/2019/02/22/19/03/numbers-4014181_960_720.jpg")
        };
        this.list_game=new ArrayList<>(Arrays.asList(gameTypes));
    }

}