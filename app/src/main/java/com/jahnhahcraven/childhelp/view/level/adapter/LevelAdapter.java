package com.jahnhahcraven.childhelp.view.level.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.Game;
import com.jahnhahcraven.childhelp.model.Level;
import com.jahnhahcraven.childhelp.view.chiffre.ChiffreActivity;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;
import com.jahnhahcraven.childhelp.view.lettre.LettreActivity;
import com.jahnhahcraven.childhelp.view.puzzle.PuzzleActivity;

import java.util.ArrayList;

public class LevelAdapter extends ArrayAdapter<Game> {
    public LevelAdapter(@NonNull Context context, ArrayList<Game> listLevel) {
        super(context,0, listLevel);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        try {
            if (listitemView == null) {
                // Layout Inflater inflates each item to be displayed in GridView.
                listitemView = LayoutInflater.from(getContext()).inflate(R.layout.widget_level_card, parent, false);
            }
            Game level = getItem(position);
            CardView card=(CardView) listitemView.findViewById(R.id.widget_level_card);
            TextView text=(TextView) listitemView.findViewById(R.id.txt_widgetLevel_name);
            text.setText(String.valueOf(level.getLevel()));
            card.setOnClickListener(new GotoListener((LevelActivity)getContext(),getGameRedirect(level.getGametype()),level.get_id()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listitemView;

    }

    private Class getGameRedirect(String gametype) throws Exception {
        if (gametype.toLowerCase().compareTo("puzzle")==0){
            return PuzzleActivity.class;
        }

        if (gametype.toLowerCase().compareTo("letter")==0){
            return LettreActivity.class;
        }

        if (gametype.toLowerCase().compareTo("number")==0){
            return ChiffreActivity.class;
        }

        throw new Exception("type game not exist!");
    }

}
