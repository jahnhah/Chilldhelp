package com.jahnhahcraven.childhelp.fragment.buttonGroup;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.fragment.ExampleFragment;
import com.jahnhahcraven.childhelp.view.MainActivity;
import com.jahnhahcraven.childhelp.view.lettre.LettreActivity;

import java.util.ArrayList;

public class ButtonGroupAdapter extends ArrayAdapter<String> {
    int identifier;
    ButtonGroupAdapter.OnFragmentInteractionListener fListener;
    public ButtonGroupAdapter(@NonNull Context context, ArrayList<String> alphabets,ButtonGroupFragment fragment) {
        super(context,0, alphabets);
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
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                fListener.onFragmentInteraction(identifier,position);
            }
        });
        setInitiaColor(button);
        return listitemView;
    }

    public void setColor(Button button,int id) {
            button.setBackgroundColor(ContextCompat.getColor(getContext(), id));
    }
    public void setInitiaColor(Button button){
        if(identifier==0){
            setColor(button,R.color.light_grey);
        }
        else{
            setColor(button,R.color.bg_color);
        }

    }



    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(int identifier,int pos);
    }
}
