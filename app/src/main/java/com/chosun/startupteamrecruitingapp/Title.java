package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class Title extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_title, container, false);
        Button goToSignUpBtn = rootView.findViewById(R.id.goto_signup_btn);
        ConstraintLayout goToSignInBtn = rootView.findViewById(R.id.goto_signup_02_btn);
        goToSignUpBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_title_to_signup, null));
        goToSignInBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_title_to_signin, null));
        return rootView;
    }
}