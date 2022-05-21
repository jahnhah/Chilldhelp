package com.jahnhahcraven.childhelp.view.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.controller.UserControl;
import com.jahnhahcraven.childhelp.model.User;

public class Sign2Activity extends AppCompatActivity {
    private Button btnNext;
    private TextView message;
    private EditText code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign2);
        init();
    }


    private void init(){
        this.btnNext = (Button) findViewById(R.id.sign2btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setCode(code.getText().toString());
                Log.e("38 Sin2Activity", "onClick: Eto isika  ");
                UserControl.getInstance().sign2Feature(btnNext,message,Sign2Activity.this,null,user);
            }
        });
        this.message = (TextView) findViewById(R.id.textViewMessage);
        message.setVisibility(View.INVISIBLE);
        this.code = (EditText) findViewById(R.id.editTextCode);

    }
}