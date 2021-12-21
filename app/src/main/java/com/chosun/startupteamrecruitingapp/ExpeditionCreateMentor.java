package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class ExpeditionCreateMentor extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_expedition_create_mentor, container, false);
        ImageButton closeBtn = rootView.findViewById(R.id.close_btn);
        closeBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_expedition_quest));

        return rootView;
    }
}
