package com.jahnhahcraven.childhelp.view.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.controller.UserControl;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;

public class Sign1Activity extends AppCompatActivity {
    private Button btnNext;
    private Button btnBack;
    private TextView message;
    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign1);
        init();
    }

    private void init(){
        this.btnNext = (Button) findViewById(R.id.sign2btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(nom.getText().toString(),email.getText().toString(),password.getText().toString());
                UserControl.getInstance().sign1Feature(btnNext,message,Sign1Activity.this,Sign2Activity.class,user);
            }
        });
        this.btnBack = (Button) findViewById(R.id.sign1btnBack);
        btnBack.setOnClickListener(new GotoListener(this,LoginActivity.class));
        this.message = (TextView) findViewById(R.id.textViewError);
        message.setVisibility(View.INVISIBLE);
        this.nom = (EditText) findViewById(R.id.editTextNom);
        this.prenom = (EditText) findViewById(R.id.editTextPrenom);
        this.email = (EditText) findViewById(R.id.editTextEmail);
        this.password = (EditText) findViewById(R.id.editTextCode);
    }

}