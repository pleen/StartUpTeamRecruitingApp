package com.chosun.startupteamrecruitingapp;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import de.hdodenhof.circleimageview.CircleImageView;


public class SignUp_03 extends Fragment {
    CircleImageView profileImage;
    Bitmap bitmap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_03, container, false);
        ImageView closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        Button goToMainBtn = (Button)rootView.findViewById(R.id.goto_main_btn);
        goToMainBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signup_to_main, null));
        profileImage = (CircleImageView) rootView.findViewById(R.id.profile_image);

        return rootView;
    }
    public void onResume() {
        super.onResume();

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).selecteImage();
                bitmap = ((MainActivity) getActivity()).getBitmapFromMemCache("profile");
                if (bitmap != null) {
                    profileImage.setImageBitmap(bitmap);
                } else {
                    profileImage.setImageResource(R.drawable.icon_close);
                }
            }
        });
    }
}