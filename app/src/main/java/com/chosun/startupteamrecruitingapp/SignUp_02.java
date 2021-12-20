package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;


public class SignUp_02 extends Fragment {
    EditText emailText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_02, container, false);
        ImageView closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        Button goToSignUpBtn_03 = (Button)rootView.findViewById(R.id.goto_signup_03_btn);
        goToSignUpBtn_03.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_signup_03, null));
        emailText = (EditText)rootView.findViewById(R.id.email_text);

        return rootView;
    }
}