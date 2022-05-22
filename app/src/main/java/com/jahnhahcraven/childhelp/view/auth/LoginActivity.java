package com.jahnhahcraven.childhelp.view.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.controller.UserControl;
import com.jahnhahcraven.childhelp.model.LoginResponse;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.view.SplashActivity;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPwd;
    private TextView lblError;
    private Button btnLogin;
    private TextView linkSign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }


    private void init(){
        this.txtEmail = findViewById(R.id.txt_login_email);
        this.txtPwd = findViewById(R.id.txt_login_pwd);
        this.lblError = findViewById(R.id.lbl_login_error);
        lblError.setVisibility(View.INVISIBLE);
        this.btnLogin = findViewById(R.id.btn_login_submit);
        this.linkSign = (TextView) findViewById(R.id.txtSignup);
        linkSign.setOnClickListener(new GotoListener(this, Sign1Activity.class));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                User utilisateur = new User();
                utilisateur.setEmail(txtEmail.getText().toString());
                utilisateur.setPassword(txtPwd.getText().toString());
                UserControl.getInstance().login(null,lblError,LoginActivity.this, HomeActivity.class,utilisateur);
            }
        });
    }





}