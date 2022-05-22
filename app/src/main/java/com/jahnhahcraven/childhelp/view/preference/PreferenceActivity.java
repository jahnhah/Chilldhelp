package com.jahnhahcraven.childhelp.view.preference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;

public class PreferenceActivity extends AppCompatActivity {

    Switch switchMode;
    Switch switchNotification;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        session = new SessionManager(PreferenceActivity.this);
        switchMode= (Switch) findViewById(R.id.switch_preference_darkModeSwitch);
        switchByDefault(session,"MODE","NIGHT", switchMode);
        switchMode.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Toast.makeText(PreferenceActivity.this,"mode was changed",Toast.LENGTH_SHORT).show();

                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    session.setSessionString("MODE","NIGHT");
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    session.setSessionString("MODE","NIGHT_NO");
                }
            }
        });
    }

    public void switchByDefault(SessionManager session,String keySession,String defaultValue, Switch switched){
        String value = session.getSessionString(keySession);
        if (value.compareTo(defaultValue)==0){
            switched.setChecked(true);
        }
    }



}