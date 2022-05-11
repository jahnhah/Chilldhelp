package com.jahnhahcraven.childhelp.view.auth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.jahnhahcraven.childhelp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }
}