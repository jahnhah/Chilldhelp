package com.jahnhahcraven.childhelp.fragment.level;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;

public class LevelFragment extends DialogFragment {

    ImageButton listButton;
    ImageButton nextButton;
    String gameType;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_level, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView){
        this.listButton=(ImageButton) rootView.findViewById(R.id.btn_levelFragment_list);
        this.nextButton=(ImageButton) rootView.findViewById(R.id.btn_levelFragment_next);
        Activity activity = (Activity) getContext();

        GotoListener listener = new GotoListener(activity, LevelActivity.class);
        listener.setMessage(getGameType());
        listener.setFinish(true);
        this.listButton.setOnClickListener(listener);
        this.nextButton.setOnClickListener(nextListener);

    }

    private View.OnClickListener listListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(),"shall go to next",Toast.LENGTH_SHORT);
           
        }
    };

    private View.OnClickListener nextListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(),"shall go to next",Toast.LENGTH_SHORT);
        }
    };

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
}
