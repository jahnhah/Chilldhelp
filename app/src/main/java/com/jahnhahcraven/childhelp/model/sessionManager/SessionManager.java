package com.jahnhahcraven.childhelp.model.sessionManager;

import android.content.Context;
import android.content.SharedPreferences;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.model.User;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final static String USER_TOKEN="user_token";


    public SessionManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE);
        editor = this.sharedPreferences.edit();
        editor.apply();
    }

    /**
     * Function to save auth token
     */

    public void saveAuthToken(String token) {
       this.editor.putString("KEY_TOKEN",token);
       this.editor.commit();
    }

    public void setEmail(String email){
        this.editor.putString("KEY_EMAIL",email);
        this.editor.commit();
    }

    public void setUser(String nomComplet){
        this.editor.putString("KEY_USER",nomComplet);
        this.editor.commit();
    }

    /**
     * Function to fetch auth token
     */
    public String getSessionString(String key) {
        return this.sharedPreferences.getString(key,"");
    }

    public Boolean getSessionBoolean(String key) {
        return this.sharedPreferences.getBoolean(key,false);
    }

}
