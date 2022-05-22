package com.jahnhahcraven.childhelp.view.puzzle.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.puzzle.Tile;

import java.util.ArrayList;
import java.util.List;

public class PuzzleAdapter extends ArrayAdapter<Tile>{
    private List<Tile> listTile;
    public PuzzleAdapter(@NonNull Context context, ArrayList<Tile> listTile) {
        super(context,0, listTile);
        this.listTile=listTile;
    }

    private int getSceenWidth(){
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }
    private int getMargin(){
        return 40;
    }
    private int getColHeight(){
        return (int)((getSceenWidth()-getMargin())
                /(Math.sqrt(listTile.size()))
        );
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
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
        img.setImageBitmap(tile.getImage());
        if(tile.getImage()==null){
            text.setText(String.valueOf(tile.getNumero()));
        }else{
            text.setText("");
        }

        card.getLayoutParams().height=getColHeight();

        if(tile.getNumero()==-1){
            card.setCardBackgroundColor(Color.GRAY);
            text.setText(".");
        }
        else{
            card.setCardBackgroundColor(getContext().getColor(R.color.bg_color));
        }

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrange(position);
            }
        });


        return listitemView;
    }

    int getColCount(){
        return (int)(Math.sqrt(listTile.size()));
    }


    public int getBlankPosition() {
        for (int i=0;i<listTile.size();i++){
            if(listTile.get(i).getNumero()==-1){
                return i;
            }
        }
        return 0;
    }

    public void arrange(int position){
        int blankPos=getBlankPosition();
        int colNum=getColCount();
        boolean cond1=(position+colNum==blankPos);
        boolean cond2=(position-colNum==blankPos);
        boolean cond3=(position+1==blankPos);
        boolean cond4=(position-1==blankPos);
        if(cond1||cond2||cond3||cond4){
            listTile.add(blankPos,listTile.get(position));
            listTile.remove(blankPos+1);

            listTile.add(position,new Tile(-1,null));
            listTile.remove(position+1);

            notifyDataSetChanged();

        }
    }

    public boolean checkArrange(){
        for(int i=1;i<listTile.size()-1;i++){
            if((listTile.get(i).getNumero())!=(listTile.get(i-1).getNumero()+1)){
                return false;
            }
        }
        return true;
    }


}
