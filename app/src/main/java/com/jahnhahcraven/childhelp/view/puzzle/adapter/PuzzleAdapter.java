package com.jahnhahcraven.childhelp.view.puzzle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.Tile;
import com.jahnhahcraven.childhelp.model.Tile;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;
import com.jahnhahcraven.childhelp.view.puzzle.PuzzleActivity;

import java.util.ArrayList;

public class PuzzleAdapter extends ArrayAdapter<Tile> {
    public PuzzleAdapter(@NonNull Context context, ArrayList<Tile> listTile) {
        super(context,0, listTile);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.widget_tile_card, parent, false);
        }
        Tile tile = getItem(position);
        CardView card=(CardView) listitemView.findViewById(R.id.widget_tile_card);
        ImageView img=(ImageView) listitemView.findViewById(R.id.img_widgetPuzzle_bgImg);
        TextView text=(TextView) listitemView.findViewById(R.id.txt_widgetPuzzle_number);
        Glide.with(getContext()).load(tile.getSrcUrl()).centerCrop().into(img);
        text.setText(String.valueOf(tile.getNumero()));

        card.setOnClickListener(new GotoListener((PuzzleActivity)getContext(), LevelActivity.class));


        return listitemView;
    }
}
