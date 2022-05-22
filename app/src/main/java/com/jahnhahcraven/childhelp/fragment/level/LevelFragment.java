package com.jahnhahcraven.childhelp.fragment.level;

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

public class LevelFragment extends DialogFragment {

    ImageButton listButton;
    ImageButton nextButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_level, container, false);
        return rootView;
    }

    private void init(View rootView){
        this.listButton=(ImageButton) rootView.findViewById(R.id.btn_levelFragment_list);
        this.nextButton=(ImageButton) rootView.findViewById(R.id.btn_levelFragment_next);
        this.listButton.setOnClickListener(listListener);
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


}
