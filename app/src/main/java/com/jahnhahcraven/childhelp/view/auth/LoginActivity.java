package com.jahnhahcraven.childhelp.view.auth;

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
import com.jahnhahcraven.childhelp.view.listener.GotoListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private UserControl userControl;
    private User user;
    private EditText txtEmail;
    private EditText txtPwd;
    private TextView lblError;
    private Button btnLogin;
    private String emaiValue;
    private String pwdValue;
    private TextView linkSign;


    public View.OnClickListener onButtonPressed = new Button.OnClickListener(){
        public void onClick(View view){
            emaiValue=txtEmail.getText().toString();
            pwdValue=txtPwd.getText().toString();
            login();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        init();
    }


    private void init(){
        this.userControl = UserControl.getInstance();
        this.txtEmail = findViewById(R.id.txt_login_email);
        this.txtPwd = findViewById(R.id.txt_login_pwd);
        this.lblError = findViewById(R.id.lbl_login_error);
        this.btnLogin = findViewById(R.id.btn_login_submit);
        this.linkSign = (TextView) findViewById(R.id.txtSignup);
        linkSign.setOnClickListener(new GotoListener(this, Sign1Activity.class));
        btnLogin.setOnClickListener(onButtonPressed);
    }

    private void login(){
        userControl.login(emaiValue,pwdValue).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    userControl.saveToken(LoginActivity.this,response.body().getAuthToken().toString());
                    Toast.makeText(LoginActivity.this,"LOGIN PASS",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(LoginActivity.this,"Error->"+response.code(),Toast.LENGTH_LONG).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Exception->"+t.getMessage(),Toast.LENGTH_LONG).show();
                Log.i("erreur","tes terr");
                Log.i("FAIL","FAILURE");
            }
        });
    }
}