package com.jahnhahcraven.childhelp.view.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.Tile;
import com.jahnhahcraven.childhelp.view.puzzle.adapter.PuzzleAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleActivity extends AppCompatActivity {

    ArrayList<Tile> list_tile;
    PuzzleAdapter puzzleAdapter;
    GridView gridView;

    private void init(){
        getSupportActionBar().hide();
        loadTile();
        gridView=(GridView) findViewById(R.id.grid_puzzle_board);
      gridView.setNumColumns((int)Math.sqrt(list_tile.size()));

        puzzleAdapter= new PuzzleAdapter(this, list_tile);
        gridView.setAdapter(puzzleAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        init();
    }

    private void loadTile(){
        list_tile=new ArrayList<Tile>();
        for(int i=0;i<100;i++){
            list_tile.add(new Tile(i,""));
        }
    }
}