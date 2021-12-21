package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class ExpeditionCreate extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_expedition_create, container, false);

        ImageButton closeBtn = rootView.findViewById(R.id.close_btn);
        closeBtn.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());

        ImageButton partyCreateBtn = rootView.findViewById(R.id.party_create_button);
        partyCreateBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_expedition_recommender));
        return rootView;
    }
}
