package com.jahnhahcraven.childhelp.view.level;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.Level;
import com.jahnhahcraven.childhelp.view.level.adapter.LevelAdapter;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {
    ArrayList<Level> listLevel;
    LevelAdapter levelAdapter;
    GridView gridView;

    void init(){
        loadLevel();
        gridView=(GridView) findViewById(R.id.grid_level_gridLevel);
        gridView.setNumColumns(3);
        levelAdapter=new LevelAdapter(this,listLevel);
        gridView.setAdapter(levelAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        init();
    }

    private void loadLevel(){
        listLevel=new ArrayList<Level>();
        for(int i=0;i<10;i++){
            listLevel.add(new Level(i,i));
        }

    }
}