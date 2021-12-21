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
import androidx.navigation.Navigation;

public class SignUp_02 extends Fragment {
    Member member;
    ImageView closeIcon;

    EditText nameText;
    EditText nickNameText;
    EditText idText;
    EditText passwordText;
    EditText passwordConfirmText;
    EditText phoneNumberText;
    EditText emailText;
    EditText introduceText;
    Button goToSignUpBtn_03;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_02, container, false);
        member = new Member();
        member = SignUp_02Args.fromBundle(getArguments()).getMember01();
        closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        nameText=(EditText)rootView.findViewById(R.id.name_text);
        nickNameText=(EditText)rootView.findViewById(R.id.nick_name_text);
        idText=(EditText)rootView.findViewById(R.id.id_text);
        passwordText=(EditText)rootView.findViewById(R.id.password_text);
        passwordConfirmText=(EditText)rootView.findViewById(R.id.password_confirm_text);
        phoneNumberText=(EditText)rootView.findViewById(R.id.phone_number_text);
        emailText = (EditText)rootView.findViewById(R.id.email_text);
        introduceText=(EditText)rootView.findViewById(R.id.introduce_text);
        goToSignUpBtn_03 = (Button)rootView.findViewById(R.id.goto_signup_03_btn);

        goToSignUpBtn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setMemNm(nameText.getText().toString());
                member.getCharacter().setMemNickname(nickNameText.getText().toString());
                member.setMemId(idText.getText().toString());
                member.setPassword(passwordText.getText().toString());
                member.setMemPhone(phoneNumberText.getText().toString());
                member.setMemEmail(emailText.getText().toString());
                member.setIntroduce(introduceText.getText().toString());
                Navigation.findNavController(rootView).navigate(SignUp_02Directions.actionGotoSignup03().setMember02(member));
            }
        });
        return rootView;
    }
}