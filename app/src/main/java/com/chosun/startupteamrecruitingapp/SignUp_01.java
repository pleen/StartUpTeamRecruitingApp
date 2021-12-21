package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class SignUp_01 extends Fragment {
    Member member;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_01, container, false);
        ImageView closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        ConstraintLayout stuSignUpBtn = (ConstraintLayout) rootView.findViewById(R.id.student_signup_constraint);
        member = new Member();
        stuSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setMemType("STUDENT");
                Navigation.findNavController(rootView).navigate(SignUp_01Directions.actionGotoStudentSignup02().setMember01(member));
            }
        });
        ConstraintLayout normalSignUpBtn = (ConstraintLayout) rootView.findViewById(R.id.normal_signup_constraint);
        normalSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setMemType("NORMAL");
                Navigation.findNavController(rootView).navigate(SignUp_01Directions.actionGotoSignup02().setMember01(member));
            }
        });
        return rootView;
    }
}