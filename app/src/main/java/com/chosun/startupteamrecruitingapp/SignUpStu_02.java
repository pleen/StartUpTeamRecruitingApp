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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

public class SignUpStu_02 extends Fragment {
    ImageView closeIcon;
    EditText universityNameSearch;
    EditText universityDomain;
    EditText universityIdText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_stu_02, container, false);
        closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        universityNameSearch = (EditText) rootView.findViewById(R.id.university_name_search);
        universityNameSearch.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_search_univ, null));
        universityDomain = (EditText)rootView.findViewById(R.id.university_domain_text);
        universityIdText = (EditText)rootView.findViewById(R.id.university_id_text);
        Button goToSignUpBtn_03 = (Button)rootView.findViewById(R.id.goto_signup_03_btn);
        goToSignUpBtn_03.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_signup_03, null));

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getParentFragmentManager().setFragmentResultListener("univKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                String selectdUnivName = bundle.getString("selectedUnivName");
                String selectdUnivDomain = bundle.getString("selectedUnivDomain");
                universityNameSearch.setText(selectdUnivName);
                universityDomain.setText(selectdUnivDomain);
            }
        });

    }

}
