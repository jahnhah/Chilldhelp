package com.jahnhahcraven.childhelp.view.lettre;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.fragment.level.LevelFragment;
import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.puzzle.Tile;
import com.jahnhahcraven.childhelp.view.lettre.adapter.ButtonGroupFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LettreActivity extends AppCompatActivity {
    Game game;
    FragmentManager fragmentManager=getSupportFragmentManager();
    ButtonGroupFragment buttonGroupFragment;
    Button btnValider;
    String disorder="";
    String answer="";
    public void init(){
        loadGame();
        buttonGroupFragment=(ButtonGroupFragment) fragmentManager.findFragmentById(R.id.fragment_lettre_buttonGroup);
        buttonGroupFragment.setAlphabet(split(disorder));
        btnValider=(Button) findViewById(R.id.btn_lettre_valider);
        btnValider.setBackgroundColor(ContextCompat.getColor(this,R.color.bg_color));
        addSubmitListener(btnValider);
    }

    private void addSubmitListener(Button button){
        button.setOnClickListener(new OnClickListener() {
//            jdk8
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String user_answer=buttonGroupFragment.getAnswer();
                LevelFragment levelFragment = new LevelFragment ();
                if(answer.compareTo(user_answer)==0){
                    levelFragment.show(fragmentManager, "Sample Fragment");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lettre);
        init();
    }

    private void loadGame(){
//        fake api
        this.game=new Game();
        game.set_id("id");
        game.setGameType("lettre");
        game.setMedia("https://www.youtube.com/watch?v=alV6wxrbULs");
        game.setText_game("ANSWER");
        this.answer=game.getText_game();
        this.disorder=disorderString(this.answer);
    }

    private String disorderString(String answer){
        String val="";
        String[]splited=split(answer);
        for(int i=0;i<splited.length;i++){
            int random=(int)Math.random()*(splited.length);
            String temp=splited[random];
            splited[random]=splited[i];
            splited[i]=temp;
        }
        return join(splited);
    }

    private String join(String[] array){
        String val="";
        for(int i=0;i< array.length;i++){
            val+=array[i];
        }
        return val;
    }


    String[] split(String alphabet){
        return alphabet.split("(?!^)");
    }

}