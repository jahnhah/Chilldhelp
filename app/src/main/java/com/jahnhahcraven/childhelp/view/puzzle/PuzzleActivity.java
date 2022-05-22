package com.jahnhahcraven.childhelp.view.puzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.fragment.level.LevelFragment;
import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.Level;
import com.jahnhahcraven.childhelp.model.puzzle.Puzzle;
import com.jahnhahcraven.childhelp.model.puzzle.Tile;
import com.jahnhahcraven.childhelp.view.puzzle.adapter.PuzzleAdapter;
import com.jahnhahcraven.childhelp.view.puzzle.utils.ImageSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleActivity extends AppCompatActivity {

    PuzzleAdapter puzzleAdapter;
    GridView gridView;
    Game game;
    Button btnValider;
    FragmentManager fragmentManager=getSupportFragmentManager();
    View.OnClickListener validerListener;

    private void init() {
        btnValider=(Button) findViewById(R.id.btn_puzzle_valider);
        gridView = (GridView) findViewById(R.id.grid_puzzle_board);
    }

    private void initListener(){
        validerListener=new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean is_ordered=puzzleAdapter.checkArrange();
                LevelFragment levelFragment = new LevelFragment ();

                if(is_ordered){
                    levelFragment.show(fragmentManager, "Sample Fragment");
                }else{
                    Toast.makeText(PuzzleActivity.this,"Nice try!!",Toast.LENGTH_LONG).show();
                }

            }
        };
        btnValider.setOnClickListener(validerListener);
    }


    private void setGridView() {
        gridView.setNumColumns((int) Math.sqrt(game.getTileList().size()));
        puzzleAdapter = new PuzzleAdapter(this, (ArrayList<Tile>) game.getTileList());
        gridView.setAdapter(puzzleAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        init();
        initListener();
        loadGame();
        setGridView();
    }

    private List<Tile> updatedTile() {
        ArrayList<Tile>tiles=(ArrayList<Tile>) this.game.getTileList();
        int count=tiles.size();
        tiles= ImageSplitter.splitImage(this,tiles,game.getMedia(),count);
        return tiles;
    }

    private int[] disorderInteger(int number){
        int[]numbers=new int[number-1];
        for(int i=0;i<numbers.length;i++){
           numbers[i]=i;
        }
        for(int i=0;i<numbers.length;i++){
            int random=(int)Math.random()*(numbers.length);
            int temp=numbers[random];
            numbers[random]=numbers[i];
            numbers[i]=temp;
        }
        return numbers;
    }

    List<Tile> initTiles(){
        int[] numbers=disorderInteger(game.getDimension());
        ArrayList<Tile> tileList=new ArrayList<Tile>();
        for(int i=0;i<numbers.length;i++){
            tileList.add(new Tile(numbers[i],null));
        }
        tileList.add(new Tile(-1,null));
        return tileList;
    }

    private void loadGame(){
        this.game=new Game();
        this.game.set_id("id");
        this.game.setLevel(1);
        this.game.setDimension(4);
        this.game.setMedia("https://cdn.pixabay.com/photo/2021/12/19/12/27/road-6881040_960_720.jpg");
        this.game.setTileList(initTiles());
        this.game.setTileList(updatedTile());
    }

}