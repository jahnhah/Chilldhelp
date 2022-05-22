package com.jahnhahcraven.childhelp.view.preference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;

import com.jahnhahcraven.childhelp.service.NotificationService;
import com.jahnhahcraven.childhelp.view.SplashActivity;
import com.jahnhahcraven.childhelp.view.auth.LoginActivity;
import com.jahnhahcraven.childhelp.view.level.LevelActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;


public class PreferenceActivity extends AppCompatActivity {

    Switch switchMode;
    Switch switchNotification;
    Button btnSignOut;
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
        switchMode = (Switch) findViewById(R.id.switch_preference_darkModeSwitch);
        switchNotification = (Switch) findViewById(R.id.switch_preference_notification);
        btnSignOut = (Button) findViewById(R.id.button_preference_signout);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut(PreferenceActivity.this,session);
            }
        });
        switchByDefault(session,"MODE","NIGHT", switchMode);
        switchByDefault(session,"NOTIFICATION","ALLOW", switchNotification);
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


    @Override
    protected void onResume() {
        super.onResume();
        checkSession();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        checkSession();
    }

    public void switchByDefault(SessionManager session, String keySession, String defaultValue, Switch switched){
        String value = session.getSessionString(keySession);
        if (value.compareTo(defaultValue)==0){
            switched.setChecked(true);
            return;
        }
        switched.setChecked(false);
    }

    public void logOut(Activity page,SessionManager session){
        session.removeSession();
        switchByDefault(session,"MODE","NIGHT", switchMode);
        switchByDefault(session,"NOTIFICATION","ALLOW", switchNotification);
        checkSession();
    }

    CompoundButton.OnCheckedChangeListener notifListener = new CompoundButton.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked){
                startService( new Intent( PreferenceActivity.this, NotificationService.class )) ;
                session.setSessionString("NOTIFICATION","ALLOW");
            }else{
                stopService(new Intent( PreferenceActivity.this, NotificationService.class ));
                session.setSessionString("NOTIFICATION","DENY");
            }
        }
    };


    public void checkSession(){
        SessionManager session = new SessionManager(PreferenceActivity.this);
        User utilisateur = (User) session.getSessionObject("KEY_USER", User.class);
        if (utilisateur == null || utilisateur.getToken().length() == 0) {
            Intent intent = new Intent(PreferenceActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }




}