package com.jahnhahcraven.childhelp.fragment.buttonGroup;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.fragment.ExampleFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class ButtonGroupFragment extends Fragment implements  ButtonGroupAdapter.OnFragmentInteractionListener{


    ArrayList<String> alphabet_answer;
    ArrayList<String> alphabet_use;
    ButtonGroupAdapter useAdapter;
    ButtonGroupAdapter answerAdapter;
    GridView answerGrid;
    GridView useGrid;



    public void setAlphabet(String[]alphabet){
        this.alphabet_use=new ArrayList<String>(Arrays.asList(alphabet));
        this.alphabet_answer=init_answer(alphabet);
        answerAdapter = new ButtonGroupAdapter(getContext(),alphabet_answer,this);
        useAdapter=new ButtonGroupAdapter(getContext(),alphabet_use,this);
    }

    ArrayList<String> init_answer(String[] alphabet){
        String[]val=alphabet.clone();
        for(int i=0;i<alphabet.length;i++){
           val[i]="-";
        }
        return new ArrayList<String>(Arrays.asList(val));
    }


    private void init(){
        alphabet_use=init_answer(new String[0]);
        alphabet_use=init_answer(new String[0]);
    }
    public ButtonGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        answerAdapter = new ButtonGroupAdapter(getContext(),alphabet_answer,this);
        useAdapter = new ButtonGroupAdapter(getContext(),alphabet_use,this);
    }

    public void init_grid(View binding){
//        get
        answerGrid=(GridView) binding.findViewById(R.id.grid_textButton_answer);
        answerAdapter.setIdentifier(0);
        useGrid=(GridView) binding.findViewById(R.id.grid_textButton_toUse);
        useAdapter.setIdentifier(1);
//        set column
        answerGrid.setNumColumns(alphabet_answer.size());
        useGrid.setNumColumns(alphabet_answer.size());
//        set adapter
        useGrid.setAdapter(useAdapter);
        answerGrid.setAdapter(answerAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getAnswer(){
        return String.join("",this.alphabet_answer.toArray(new String[alphabet_answer.size()]));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View binding=inflater.inflate(R.layout.fragment_text_button, container, false);
        init_grid(binding);
        return binding;
    }


    int nextBlank(ArrayList<String> list){
        int pos=0;
        for (String el:list) {
            if(el.compareTo("-")==0){
                pos=list.indexOf(el);
                break;
            }
        }
        return pos;
    }

    void arrange(){
        for (int i=0;i<alphabet_use.size();i++) {
            if(alphabet_use.get(i).compareTo("-")==0){
                alphabet_use.remove(i);
                alphabet_use.add("-");
            }
            if(alphabet_answer.get(i).compareTo("-")==0){
                alphabet_answer.remove(i);
                alphabet_answer.add("-");
            }
        }

    }




    @Override
    public void onFragmentInteraction(int identifier,int pos) {
        if(identifier==0 && alphabet_answer.get(pos).compareTo("-")!=0){
            int blankPos=nextBlank(alphabet_use);
            alphabet_use.add(blankPos,alphabet_answer.get(pos));
            alphabet_use.remove(alphabet_use.size()-1);
            alphabet_answer.remove(pos);
            alphabet_answer.add(pos,"-");
            arrange();
        }
        if(identifier==1 && alphabet_use.get(pos).compareTo("-")!=0){
            int blankPos=nextBlank(alphabet_answer);
            alphabet_answer.add(blankPos,alphabet_use.get(pos));
            alphabet_answer.remove(alphabet_answer.size()-1);
            alphabet_use.remove(pos);
            alphabet_use.add(pos,"-");
            arrange();
        }
        answerAdapter.notifyDataSetChanged();
        useAdapter.notifyDataSetChanged();
    }
}