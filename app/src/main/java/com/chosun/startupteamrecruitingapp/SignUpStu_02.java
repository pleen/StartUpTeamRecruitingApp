package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

public class SignUpStu_02 extends Fragment {
    Member member;
    ImageView closeIcon;

    EditText nameText;
    EditText nickNameText;
    EditText idText;
    EditText passwordText;
    EditText passwordConfirmText;
    EditText phoneNumberText;
    EditText universityNameSearch;
    EditText universityIdText;
    EditText universityDomain;
    EditText introduceText;
    Button goToSignUpBtn_03;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_stu_02, container, false);
        member = new Member();
        member = SignUpStu_02Args.fromBundle(getArguments()).getMember01();
        closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        nameText=(EditText)rootView.findViewById(R.id.name_text);
        nickNameText=(EditText)rootView.findViewById(R.id.nick_name_text);
        idText=(EditText)rootView.findViewById(R.id.id_text);
        passwordText=(EditText)rootView.findViewById(R.id.password_text);
        passwordConfirmText=(EditText)rootView.findViewById(R.id.password_confirm_text);
        phoneNumberText=(EditText)rootView.findViewById(R.id.phone_number_text);
        universityNameSearch = (EditText) rootView.findViewById(R.id.university_name_search);
        universityNameSearch.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_search_univ, null));
        universityDomain = (EditText)rootView.findViewById(R.id.university_domain_text);
        universityIdText = (EditText)rootView.findViewById(R.id.university_id_text);
        introduceText=(EditText)rootView.findViewById(R.id.introduce_text);
        goToSignUpBtn_03 = (Button)rootView.findViewById(R.id.goto_signup_03_btn);

        Button goToSignUpBtn_03 = (Button)rootView.findViewById(R.id.goto_signup_03_btn);
        goToSignUpBtn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameText.getText().toString().isEmpty()||nickNameText.getText().toString().isEmpty()||passwordText.getText().toString().isEmpty()||passwordConfirmText.getText().toString().isEmpty()
                        ||phoneNumberText.getText().toString().isEmpty()||universityIdText.getText().toString().isEmpty()||universityDomain.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "빈 칸을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if(!passwordText.getText().toString().equals(passwordConfirmText.getText().toString())) {
                    Toast.makeText(getContext(), "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                } else {
                    String email = universityIdText.getText().toString() + "@" + universityDomain.getText().toString();
                    member.setMemNm(nameText.getText().toString());
                    member.setCharacter(new Character());
                    member.getCharacter().setMemNickname(nickNameText.getText().toString());
                    member.setMemId(idText.getText().toString());
                    member.setPassword(passwordText.getText().toString());
                    member.setMemPhone(phoneNumberText.getText().toString());
                    member.setMemEmail(email);
                    member.setIntroduce(introduceText.getText().toString());
                    Navigation.findNavController(rootView).navigate(SignUp_02Directions.actionGotoSignup03().setMember02(member));
                }
            }
        });

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
