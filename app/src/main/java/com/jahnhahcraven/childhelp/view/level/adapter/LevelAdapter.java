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
import com.jahnhahcraven.childhelp.model.Level;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;
import com.jahnhahcraven.childhelp.view.lettre.LettreActivity;

import java.util.ArrayList;

public class LevelAdapter extends ArrayAdapter<Level> {
    public LevelAdapter(@NonNull Context context, ArrayList<Level> listLevel) {
        super(context,0, listLevel);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.widget_level_card, parent, false);
        }
        Level level = getItem(position);
        CardView card=(CardView) listitemView.findViewById(R.id.widget_level_card);
        TextView text=(TextView) listitemView.findViewById(R.id.txt_widgetLevel_name);
        text.setText(String.valueOf(level.getNumero()));
        card.setOnClickListener(new GotoListener((LevelActivity)getContext(),LettreActivity.class));

        return listitemView;
    }

}
