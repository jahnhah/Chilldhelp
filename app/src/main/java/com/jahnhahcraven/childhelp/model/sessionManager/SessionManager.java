package com.jahnhahcraven.childhelp.model.sessionManager;

import android.content.Context;
import android.content.SharedPreferences;

import com.jahnhahcraven.childhelp.R;

public class SessionManager {

    private Context context;
    private SharedPreferences prefs=context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE);
    private final static String USER_TOKEN="user_token";
    public SessionManager(Context context) {
        this.context = context;
    }

    /**
     * Function to save auth token
     */

    public  void saveAuthToken(String token) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_TOKEN, token);
        editor.apply();
    }

    /**
     * Function to fetch auth token
     */

    public  String fetchAuthToken()
    {
        return prefs.getString(USER_TOKEN,null);
    }

}
