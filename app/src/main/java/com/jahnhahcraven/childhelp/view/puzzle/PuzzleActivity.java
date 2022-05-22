package com.jahnhahcraven.childhelp.view.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.Level;
import com.jahnhahcraven.childhelp.model.puzzle.Puzzle;
import com.jahnhahcraven.childhelp.model.puzzle.Tile;
import com.jahnhahcraven.childhelp.view.puzzle.adapter.PuzzleAdapter;
import com.jahnhahcraven.childhelp.view.puzzle.utils.ImageSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleActivity extends AppCompatActivity {

    Puzzle puzzle;
    PuzzleAdapter puzzleAdapter;
    GridView gridView;
    ArrayList<Bitmap> bitmapArrayList;

    private void init() {
        gridView = (GridView) findViewById(R.id.grid_puzzle_board);
    }


    private void setGridView() {
        gridView.setNumColumns((int) Math.sqrt(puzzle.getTileList().size()));
        puzzleAdapter = new PuzzleAdapter(this, (ArrayList<Tile>) puzzle.getTileList());
        gridView.setAdapter(puzzleAdapter);
        int width = gridView.getColumnWidth();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        init();
        loadPuzzle();
        setGridView();
    }

    private List<Tile> updatedTile() {
        ArrayList<Tile>tiles=(ArrayList<Tile>) this.puzzle.getTileList();
        int count=tiles.size();
        tiles= ImageSplitter.splitImage(this,tiles,puzzle.getMedia(),count);

        return tiles;
    }

    List<Tile> fakeTiles(){
        Tile[] array=new Tile[]{
                new Tile(0,null),
                new Tile(1,null),
                new Tile(7,null),
                new Tile(3,null),
                new Tile(4,null),
                new Tile(-1,null),
                new Tile(6,null),
                new Tile(2,null),
                new Tile(5,null),
        };
        ArrayList<Tile> tileList=new ArrayList<Tile>(Arrays.asList(array));
        return tileList;
    }

    private void loadPuzzle() {
        String img_src = "https://cdn.pixabay.com/photo/2021/12/19/12/27/road-6881040_960_720.jpg";
        Level level = new Level(1, 1);
        this.puzzle = new Puzzle("banane", 4, fakeTiles());
        puzzle.setMedia(img_src);
        Log.i("count2",String.valueOf(fakeTiles().size()));
        this.puzzle.setTileList(updatedTile());
    }





}