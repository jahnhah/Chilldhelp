package com.jahnhahcraven.childhelp.view.listener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GotoListener implements View.OnClickListener {
    private Activity currentActivity;
    private Class toShowClass;
    private String message;


    public GotoListener(Activity current,Class toShow) {
        this.currentActivity=current;
        this.toShowClass=toShow;
    }

    public void setMessage(String message){
        this.message=message;
    }


    @Override
    public void onClick(View view) {
        Intent intent=new Intent(currentActivity,toShowClass);
//        intent.putExtra(EXTRA_MESSAGE,"HELLO");
        if(message!=null){
            Bundle bundle = new Bundle();
            bundle.putString("params",message);
            intent.putExtras(bundle);
            Log.i("Intent","Bundle ajouter");
        }
        currentActivity.startActivity(intent);
    }
}
