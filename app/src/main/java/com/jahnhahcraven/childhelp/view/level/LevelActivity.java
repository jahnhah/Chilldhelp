package com.jahnhahcraven.childhelp.view.level;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.controller.LevelControl;
import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.Level;
import com.jahnhahcraven.childhelp.view.level.adapter.LevelAdapter;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {
    ArrayList<Game> listLevel;
    LevelAdapter levelAdapter;
    GridView gridView;

    void init(){
        gridView=(GridView) findViewById(R.id.grid_level_gridLevel);
        gridView.setNumColumns(3);
        loadLevel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        init();
    }

    private void loadLevel(){
        LevelControl.getInstance().getLevelGame(this,gridView);
    }
}