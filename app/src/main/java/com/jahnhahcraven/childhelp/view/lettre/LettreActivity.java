package com.jahnhahcraven.childhelp.view.lettre;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.fragment.level.LevelFragment;
import com.jahnhahcraven.childhelp.view.lettre.adapter.ButtonGroupFragment;

public class LettreActivity extends AppCompatActivity {

    FragmentManager fragmentManager=getSupportFragmentManager();
    ButtonGroupFragment buttonGroupFragment;
    Button btnValider;
    public void init(){
        String alphabet="MANER";
        buttonGroupFragment=(ButtonGroupFragment) fragmentManager.findFragmentById(R.id.fragment_lettre_buttonGroup);
        buttonGroupFragment.setAlphabet(split(alphabet));
        btnValider=(Button) findViewById(R.id.btn_lettre_valider);
        btnValider.setBackgroundColor(ContextCompat.getColor(this,R.color.bg_color));
        addSubmitListener(btnValider);
    }

    private void addSubmitListener(Button button){
        button.setOnClickListener(new OnClickListener() {
//            jdk8
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String answer=buttonGroupFragment.getAnswer();
                LevelFragment levelFragment = new LevelFragment ();
                levelFragment.show(fragmentManager, "Sample Fragment");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lettre);
        init();
    }
    String[] split(String alphabet){
        return alphabet.split("(?!^)");
    }

}