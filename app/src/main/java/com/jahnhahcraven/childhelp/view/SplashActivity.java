package com.jahnhahcraven.childhelp.view;

import android.annotation.SuppressLint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;

import com.jahnhahcraven.childhelp.view.auth.LoginActivity;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {
    private ImageView imgLogo;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        initLogoAnimation();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SessionManager session = new SessionManager(SplashActivity.this);
                Class aRedirect  = LoginActivity.class;
                User utilisateur = (User) session.getSessionObject("KEY_USER", User.class);
                String mode = session.getSessionString("MODE")+"";
                setMode(mode);
                if (utilisateur.getToken().length() !=0){
                    aRedirect = HomeActivity.class;
                }
                Intent intent  = new Intent(SplashActivity.this,aRedirect);


//                Intent intent  = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    private void init(){
        imgLogo=(ImageView) findViewById(R.id.imgLogo);
    }

    private void initLogoAnimation(){
        Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_logo);
        imgLogo.startAnimation(aniSlide);
    }

    private void setMode(String mode){
        if (mode.compareTo("NIGHT") == 0){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            return;
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }


}