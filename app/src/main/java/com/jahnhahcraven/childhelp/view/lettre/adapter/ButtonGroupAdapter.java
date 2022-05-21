package com.jahnhahcraven.childhelp.view.lettre.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.jahnhahcraven.childhelp.R;

import java.util.ArrayList;

public class ButtonGroupAdapter extends ArrayAdapter<String> {
    int identifier;
    ArrayList<String> alphabets;
    ButtonGroupAdapter.OnFragmentInteractionListener fListener;
    public ButtonGroupAdapter(@NonNull Context context, ArrayList<String> alphabets,ButtonGroupFragment fragment) {
        super(context,0, alphabets);
        this.alphabets=alphabets;
        fListener=(ButtonGroupAdapter.OnFragmentInteractionListener) fragment;
    }

    public void setIdentifier(int identifier){
        this.identifier=identifier;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.widget_text_block, parent, false);
        }
        String alphabet = getItem(position);
        Button button =(Button) listitemView.findViewById(R.id.btn_widget_text_block_alphabet);
        button.setText(alphabet);
        if(identifier==1){
            button.getLayoutParams().height=getButtonHeight();
        }

        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                fListener.onFragmentInteraction(identifier,position);
            }
        });
        setInitiaColor(button);
        return listitemView;
    }

    private int getSceenWidth(){
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    private int getMargin(){
        return 40;
    }

    private int getButtonHeight(){
        int size=alphabets.size();
        int sqrt=(int)Math.sqrt(size);
        while (sqrt*sqrt<size){
            size++;
            sqrt=(int)Math.sqrt(size);
        }
        return (int)((getSceenWidth()-300)/(sqrt));
    }

    public void setColor(Button button,int id) {
            button.setBackground(ContextCompat.getDrawable(getContext(),id));
    }
    public void setInitiaColor(Button button){
        if(identifier==0){
            setColor(button,R.drawable.button_gray);
        }
        else{
            setColor(button,R.drawable.button_blue);
            button.setTextColor(Color.WHITE);
        }

    }



    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(int identifier,int pos);
    }
}
