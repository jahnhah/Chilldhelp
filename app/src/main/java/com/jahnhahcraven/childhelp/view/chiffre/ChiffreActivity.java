package com.jahnhahcraven.childhelp.view.chiffre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.fragment.level.LevelFragment;
import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.chiffre.Chiffre;
import com.jahnhahcraven.childhelp.model.puzzle.Tile;
import com.jahnhahcraven.childhelp.view.chiffre.adapter.ButtonChiffreAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChiffreActivity extends AppCompatActivity implements ButtonChiffreAdapter.OnChiffreInteractionListener{
    Game game;
    GridView gridView;
    ButtonChiffreAdapter chiffreAdapter;
    FragmentManager fragmentManager=getSupportFragmentManager();
    LevelFragment levelFragment = new LevelFragment ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadGame();
        setContentView(R.layout.activity_chiffre);
        init();
    }

    private void loadGame(){
        game=new Game();
        game.set_id("1");
        game.setLevel(1);
        game.setMedia("https://www.youtube.com/watch?v=alV6wxrbULs");
        game.setGameType("CHIFFRE");
        game.setText_game("Combien de pomme Maman a acheté?");
        game.setResult(2.0);
        ArrayList<Double> answers=new ArrayList<Double>();
        answers.add(1.0);answers.add(2.0);answers.add(3.0);answers.add(4.0);
        game.setNumber_game(answers);
    }

    void init(){
        chiffreAdapter=new ButtonChiffreAdapter(this,game.getNumber_game());
        gridView=findViewById(R.id.grid_chiffre_answerGrid);
        gridView.setNumColumns(this.game.getNumber_game().size()/2);
        gridView.setAdapter(chiffreAdapter);
        TextView question=(TextView) findViewById(R.id.lbl_chiffreActivity_question);
        question.setText(game.getText_game());
    }

    @Override
    public void onFragmentInteraction(Double nb) {
        if(nb==game.getResult()){
            levelFragment.show(fragmentManager, "Sample Fragment");
        }else{
            Toast.makeText(ChiffreActivity.this,"Nice try",Toast.LENGTH_SHORT);
        }
    }
}