package com.jahnhahcraven.childhelp.view;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.controller.PostControl;
import com.jahnhahcraven.childhelp.model.Post;
import com.jahnhahcraven.childhelp.view.fragment.ExampleFragment;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ExampleFragment.OnFragmentInteractionListener {
//     properties declaration
    private PostControl control;
    public List<Post> posts;
    public Post post;
    TextView txtHello;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("init test","Init test");
        init();
        loadPosts();
    }
//    properties initialisation
    /**
     * properties initialisation
     */
    private void init(){
//        init all the properties

        control= PostControl.getInstance();
        txtHello= findViewById(R.id.txt_hello);
        button=(Button) findViewById(R.id.btnGoto);
        button.setOnClickListener(new GotoListener(this,SplashActivity.class));
    }

//    load posts
    private void loadPosts(){
        control.getAllPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    posts=response.body();
                }
                else{
                    Toast.makeText(MainActivity.this,"Error->"+response.code(),Toast.LENGTH_LONG).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Exception->"+t.getMessage(),Toast.LENGTH_LONG).show();
                Log.i("erreur","tes terr");
                Log.i("FAIL","FAILURE");
            }
        });
    }
    public void load(View view){
//        loadPosts();

        txtHello.setText(posts.get(0).getText());
        Log.d("MESSAGE SSSSSSSSS====",posts.get(0).getText());
    }

    public void showPost(int id){
        control.getPost(id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    post=response.body();
                    txtHello.setText(post.getText());
                }
                else{
                    Toast.makeText(MainActivity.this,"Error->"+response.code(),Toast.LENGTH_LONG).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Exception->"+t.getMessage(),Toast.LENGTH_LONG).show();
                Log.i("erreur","tes terr");
                Log.i("FAIL","FAILURE");
            }
        });
    }


    @Override
    public void onFragmentInteraction(int id) {
        Log.i("RRRRRRRRRGII","INNNNNNNNNTTTTTTEEEEEEEERRRRRRRRAAA");
        showPost(id);
    }
}