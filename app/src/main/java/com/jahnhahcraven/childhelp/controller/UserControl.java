package com.jahnhahcraven.childhelp.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jahnhahcraven.childhelp.model.LoginRequest;
import com.jahnhahcraven.childhelp.model.LoginResponse;
import com.jahnhahcraven.childhelp.model.Post;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.generic.ReponseAPI;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.service.BaseService;
import com.jahnhahcraven.childhelp.service.IUserService;
import com.jahnhahcraven.childhelp.view.MainActivity;
import com.jahnhahcraven.childhelp.view.SplashActivity;
import com.jahnhahcraven.childhelp.view.auth.LoginActivity;

import java.util.List;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserControl {
    private static UserControl instance;
    private BaseService service = BaseService.getInstance();
    private SessionManager sessionManager;

    public static UserControl getInstance(){
        if(instance==null){
            UserControl.instance=new UserControl();
        }
        return UserControl.instance;
    }

    public Call<LoginResponse> login(String email, String mdp){
        return service.userService.login(new LoginRequest(email,mdp));
    }

    public void sign1Feature(Button ciblé, TextView message , Activity pageRecent, Class redirection, User object){
        Call<ReponseAPI> reponse = service.userService.sign1User(object);
        Intent intent = null;
        reponse.enqueue(new Callback<ReponseAPI>() {
            @Override
            public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                if(response.body().getStatus() == 200){
                    Intent intent  = new Intent(pageRecent, redirection);
                    pageRecent.startActivity(intent);
                }else{
                    Log.e("Line Code :","Line 54 -- User Control.java");
                    Log.e("Message Error", response.body().getStatus().toString());
                    message.setText("intern Server Error");
                    message.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ReponseAPI> call, Throwable t) {
                Log.e("Line Code :","Line 54 -- User Control.java");
                Log.e("Message Error",t.getMessage());
                message.setText("intern Server Error");
            }
        });
    }

    public void saveToken(Context context,String token){
        sessionManager=new SessionManager(context);
        sessionManager.saveAuthToken(token);
    }

}
