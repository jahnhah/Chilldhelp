package com.jahnhahcraven.childhelp.view.chiffre.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.GameType;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;

import java.util.ArrayList;

public class ButtonChiffreAdapter extends ArrayAdapter<Double> {
    public ButtonChiffreAdapter(@NonNull Context context, ArrayList<Double> listNb) {
        super(context, 0, listNb);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.widget_chiffre_block, parent, false);
        }
        Double nb= getItem(position);
        CardView btn=(CardView) listitemView.findViewById(R.id.card_chiffre_button);
        TextView lbl=(TextView) listitemView.findViewById(R.id.lbl_chiffre_nb);
        lbl.setText(String.format("%,.2f", nb));

        return listitemView;
    }
}
