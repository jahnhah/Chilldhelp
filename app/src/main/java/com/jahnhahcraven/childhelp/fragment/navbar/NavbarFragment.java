package com.jahnhahcraven.childhelp.fragment.navbar;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jahnhahcraven.childhelp.R;
import com.jahnhahcraven.childhelp.controller.UserControl;
import com.jahnhahcraven.childhelp.model.User;
import com.jahnhahcraven.childhelp.view.auth.LoginActivity;
import com.jahnhahcraven.childhelp.view.home.HomeActivity;
import com.jahnhahcraven.childhelp.view.listener.GotoListener;
import com.jahnhahcraven.childhelp.view.preference.PreferenceActivity;

public class NavbarFragment extends Fragment {
    ImageView settingIcons;


    public NavbarFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflator =  inflater.inflate(R.layout.fragment_navbar, container, false);
        init(inflator);
        return inflator;
    }

    private void init(View view){
        settingIcons = view.findViewById(R.id.imageView3);
        settingIcons.setOnClickListener(new GotoListener((Activity) getContext(), PreferenceActivity.class));
    }
}