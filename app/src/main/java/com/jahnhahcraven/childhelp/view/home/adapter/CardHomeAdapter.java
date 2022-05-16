package com.jahnhahcraven.childhelp.view.home.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
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
import com.jahnhahcraven.childhelp.fragment.buttonGroup.ButtonGroupAdapter;
import com.jahnhahcraven.childhelp.fragment.buttonGroup.ButtonGroupFragment;
import com.jahnhahcraven.childhelp.model.GameType;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;
import com.jahnhahcraven.childhelp.view.puzzle.PuzzleActivity;

import java.util.ArrayList;

public class CardHomeAdapter extends ArrayAdapter<GameType> {
    public CardHomeAdapter(@NonNull Context context, ArrayList<GameType> listGame) {
        super(context,0, listGame);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.widget_home_card, parent, false);
        }
        GameType game = getItem(position);
        CardView card=(CardView) listitemView.findViewById(R.id.widget_home_card);
        ImageView img=(ImageView) listitemView.findViewById(R.id.img_widgetHome_bgImg);
        TextView text=(TextView) listitemView.findViewById(R.id.txt_widgetHome_name);
        Glide.with(getContext()).load(game.getSrcUrl()).centerCrop().into(img);
        text.setText(game.getName());
        GotoListener listener=new GotoListener((HomeActivity)getContext(),LevelActivity.class);
        listener.setMessage(game.getName());
        card.setOnClickListener(listener);

        return listitemView;
    }

//    View.OnClickListener getListener(String name){
//        if(name.toUpperCase().compareTo("LETTRE")==0){
//            return new GotoListener((HomeActivity)getContext(), LevelActivity.class);
//        }
//        if(name.toUpperCase().compareTo("CHIFFRE")==0){
////            return new GotoListener((HomeActivity)getContext(), ChiffreActivity.class);
//        }
//        if(name.toUpperCase().compareTo("PUZZLE")==0){
//            return new GotoListener((HomeActivity)getContext(), PuzzleActivity.class);
//        }
//        return null;
//    }

}
