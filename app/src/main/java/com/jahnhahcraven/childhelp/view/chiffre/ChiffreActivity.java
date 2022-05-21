package com.jahnhahcraven.childhelp.view.chiffre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.chiffre.Chiffre;
import com.jahnhahcraven.childhelp.view.chiffre.adapter.ButtonChiffreAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChiffreActivity extends AppCompatActivity {

    GridView gridView;
    ButtonChiffreAdapter chiffreAdapter;
    Chiffre chiffre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chiffre);
        loadChiffre();
        init();
    }

    void loadChiffre(){
        String question="Combien de pomme a t-il acheté?";
        String videoUrl="";
        ArrayList<Double> answers=new ArrayList<Double>();
        for(int i=0;i<4;i++){
            answers.add(Math.random());
        }
        chiffre=new Chiffre(1,videoUrl,question,answers);

    }

    void init(){
        chiffreAdapter=new ButtonChiffreAdapter(this,(ArrayList<Double>) chiffre.getAnswers());
        gridView=findViewById(R.id.grid_chiffre_answerGrid);
        gridView.setNumColumns(this.chiffre.getAnswers().size()/2);
        gridView.setAdapter(chiffreAdapter);

        TextView question=(TextView) findViewById(R.id.lbl_chiffreActivity_question);
        question.setText(chiffre.getQuestion());
    }
}