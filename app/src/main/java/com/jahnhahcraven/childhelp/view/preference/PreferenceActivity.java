package com.jahnhahcraven.childhelp.view.preference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;

import com.jahnhahcraven.childhelp.service.NotificationService;
import com.jahnhahcraven.childhelp.view.SplashActivity;


public class PreferenceActivity extends AppCompatActivity {

    Switch switchMode;
    Switch switchNotification;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }else{
            setTheme(R.style.Theme_Light);
        }
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
        switchNotification.setOnCheckedChangeListener(notifListener);

    }

    public void switchByDefault(SessionManager session,String keySession,String defaultValue, Switch switched){
        String value = session.getSessionString(keySession);
        if (value.compareTo(defaultValue)==0){
            switched.setChecked(true);
        }
    }


    CompoundButton.OnCheckedChangeListener notifListener=new CompoundButton.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked){
                startService( new Intent( PreferenceActivity.this, NotificationService.class )) ;
            }else{
                stopService(new Intent( PreferenceActivity.this, NotificationService.class ));
            }
        }
    };



}