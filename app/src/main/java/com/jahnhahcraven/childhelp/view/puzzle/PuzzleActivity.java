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
import com.jahnhahcraven.childhelp.controller.GameControl;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        btnValider = (Button) findViewById(R.id.btn_puzzle_valider);
        gridView = (GridView) findViewById(R.id.grid_puzzle_board);
        validerListener=new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean is_ordered=puzzleAdapter.checkArrange();
                LevelFragment levelFragment = new LevelFragment ();

                if(is_ordered){
                    levelFragment.setGameType("Puzzle");
                    levelFragment.show(fragmentManager, "Sample Fragment");
                }else{
                    Toast.makeText(PuzzleActivity.this,"Nice try!!",Toast.LENGTH_LONG).show();
                }

            }
        };
        btnValider.setOnClickListener(validerListener);
        GameControl.getInstance().getGame(this);
    }




    private void setGridView() {
        gridView.setNumColumns((int) Math.sqrt(game.getTileList().size()));
        puzzleAdapter = new PuzzleAdapter(this, (ArrayList<Tile>) game.getTileList());
        gridView.setAdapter(puzzleAdapter);
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

    public void loadGame(){
//        this.game=new Game();
//        this.game.set_id("id");
//        this.game.setLevel(1);
//        this.game.setDimension(9);
//        this.game.setMedia("data:image/jpeg;base64,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");
        Log.e("game",game.toString());
        this.game.setTileList(initTiles());
        this.game.setTileList(updatedTile());
        setGridView();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}