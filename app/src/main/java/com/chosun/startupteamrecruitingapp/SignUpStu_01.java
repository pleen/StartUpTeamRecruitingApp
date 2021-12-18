package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.util.Log;
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
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class SignUpStu_01 extends Fragment {
    ImageView closeIcon;
    Button emailAuthBtn;
    EditText universityNameSearch;
    EditText universityDomain;
    EditText universityIdText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_stu_01, container, false);
        closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        emailAuthBtn = (Button) rootView.findViewById(R.id.email_auth_button);
        universityNameSearch = (EditText) rootView.findViewById(R.id.university_name_search);
        universityNameSearch.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_search_univ, null));
        universityDomain = (EditText)rootView.findViewById(R.id.university_domain_text);
        universityIdText = (EditText)rootView.findViewById(R.id.university_id_text);
        emailAuthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String studentEmail = universityIdText.getText().toString() + "@" + universityDomain.getText().toString();
                Log.d("email", studentEmail);
                bundle.putString("studentEmail", studentEmail);
                getParentFragmentManager().setFragmentResult("email", bundle);
                Navigation.findNavController(rootView).navigate(R.id.action_goto_student_signup_02);
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getParentFragmentManager().setFragmentResultListener("selectedUniv", this, new FragmentResultListener() {
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
