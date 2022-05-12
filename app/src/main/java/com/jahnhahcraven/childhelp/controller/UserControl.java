package com.jahnhahcraven.childhelp.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.model.LoginRequest;
import com.jahnhahcraven.childhelp.model.LoginResponse;
import com.jahnhahcraven.childhelp.model.Post;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.model.sessionManager.SessionManager;
import com.jahnhahcraven.childhelp.service.BaseService;
import com.jahnhahcraven.childhelp.view.MainActivity;
import com.jahnhahcraven.childhelp.view.auth.LoginActivity;

import java.util.List;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserControl {
    private static UserControl instance;
    private BaseService service=BaseService.getInstance();
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
    public void saveToken(Context context,String token){
        sessionManager=new SessionManager(context);
        sessionManager.saveAuthToken(token);
    }

}
