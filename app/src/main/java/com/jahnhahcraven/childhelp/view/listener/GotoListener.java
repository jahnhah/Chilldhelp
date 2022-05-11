package com.jahnhahcraven.childhelp.view.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class GotoListener implements View.OnClickListener {
    private Activity currentActivity;
    private Class toShowClass;
    public GotoListener(Activity current,Class toShow) {
        this.currentActivity=current;
        this.toShowClass=toShow;
    }


    @Override
    public void onClick(View view) {
        Intent intent=new Intent(currentActivity,toShowClass);
//        intent.putExtra(EXTRA_MESSAGE,"HELLO");
        currentActivity.startActivity(intent);
    }
}
