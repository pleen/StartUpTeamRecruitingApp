package com.chosun.startupteamrecruitingapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class SignUp_03 extends Fragment{
    View rootView;
    ImageView closeIcon;
    Retrofit retrofit;
    CircleImageView profileImage;
    Bitmap bitmap;
    Spinner mbtiSpinner;
    EditText majorText;
    EditText targetJobText;
    LinearLayout skillLayout;
    LinearLayout awardsLayout;
    LinearLayout portfolioLayout;
    ImageView skillPlusIcon;
    ImageView awardsPlusIcon;
    ImageView portfolioPlusIcon;
    ArrayList<CustomEditText> skillTexts;
    ArrayList<CustomEditText> awardsTexts;
    ArrayList<CustomEditText> portfolioTexts;
    Button goToMainBtn;
    Member member;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_signup_03, container, false);
        closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());
        retrofit = ((MainActivity) MainActivity.context).retrofit;
        profileImage = (CircleImageView) rootView.findViewById(R.id.profile_image);
        mbtiSpinner = (Spinner)rootView.findViewById(R.id.mbti_spinner);
        majorText = (EditText)rootView.findViewById(R.id.major_text);
        targetJobText = (EditText)rootView.findViewById(R.id.target_job_text);
        skillLayout = (LinearLayout)rootView.findViewById(R.id.skill_layout);
        awardsLayout = (LinearLayout)rootView.findViewById(R.id.awards_layout);
        portfolioLayout = (LinearLayout)rootView.findViewById(R.id.portfolio_layout);
        skillPlusIcon= (ImageView)rootView.findViewById(R.id.skill_plus_btn);
        awardsPlusIcon= (ImageView)rootView.findViewById(R.id.awards_plus_btn);
        portfolioPlusIcon= (ImageView)rootView.findViewById(R.id.portfolio_plus_btn);
        skillTexts = new ArrayList<>();
        awardsTexts = new ArrayList<>();
        portfolioTexts = new ArrayList<>();
        goToMainBtn = (Button)rootView.findViewById(R.id.goto_main_btn);
        member = new Member();
        member = SignUp_03Args.fromBundle(getArguments()).getMember02();
        ImageView.OnClickListener onClickListener = new ImageView.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.skill_plus_btn:
                        addMemSkill();
                        if(!skillTexts.get(skillTexts.size() - 1).getText().isEmpty()) {
                            addCustomText(skillTexts, "스킬을 입력해주세요.", skillLayout);
                        }
                        break;
                    case R.id.awards_plus_btn:
                        addMemAwards();
                        if(!awardsTexts.get(awardsTexts.size() - 1).getText().isEmpty()) {
                            addCustomText(awardsTexts, "경력을 입력해주세요", awardsLayout);
                        }
                        break;
                    case R.id.portfolio_plus_btn:
                        addMemPPLinks();
                        if(!portfolioTexts.get(portfolioTexts.size() - 1).getText().isEmpty()) {
                            addCustomText(portfolioTexts, "포트폴리오/sns 링크를 입력해주세요.", portfolioLayout);
                        }
                        break;
                }
            }
        };

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).selecteImage();
                bitmap = ((MainActivity) getActivity()).getBitmapFromMemCache("profile");
                if (bitmap != null) {
                    profileImage.setImageBitmap(bitmap);
                }
            }
        });

        addCustomText(skillTexts, "스킬을 입력해주세요.", skillLayout);
        addCustomText(awardsTexts, "경력을 입력해주세요", awardsLayout);
        addCustomText(portfolioTexts, "포트폴리오/sns 링크를 입력해주세요.", portfolioLayout);
        skillPlusIcon.setOnClickListener(onClickListener);
        awardsPlusIcon.setOnClickListener(onClickListener);
        portfolioPlusIcon.setOnClickListener(onClickListener);

        goToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setMemStat("AUTH");
                member.getCharacter().setMemMbti(mbtiSpinner.getSelectedItem().toString());
                member.getCharacter().setMemMajor(majorText.getText().toString());
                addMemSkill();
                addMemAwards();
                addMemPPLinks();
                RetrofitInterface service = retrofit.create(RetrofitInterface.class);
                Call<Member> call = service.register(member);
                Log.d("testa",member.toString());
                call.enqueue(new Callback<Member>() {
                    @Override
                    public void onResponse(Call<Member> call, Response<Member> response) {
                        if (response.isSuccessful()) {
                            Member result = response.body();
                            Log.d("Retrofit", "성공 "+result.toString());
                            Navigation.findNavController(rootView).navigate(R.id.action_signup_to_main);
                        } else {
                            Log.d("Retrofit", "error code: "+response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Member> call, Throwable t) {
                        Log.d("Retrofit", "onFailure():" + t.getMessage());
                    }
                });
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        bitmap = ((MainActivity) getActivity()).getBitmapFromMemCache("profile");
        if (bitmap != null) {
            profileImage.setImageBitmap(bitmap);
        }
    }

    public void addCustomText(ArrayList<CustomEditText> customEditTexts, String hint, LinearLayout linear) {
        customEditTexts.add(new CustomEditText(MainActivity.context));
        customEditTexts.get(customEditTexts.size()-1).setHint(hint);
        linear.addView(customEditTexts.get(customEditTexts.size()-1));
    }
    public void addMemSkill() {
        String str = skillTexts.get(skillTexts.size() - 1).getText();
        if(!str.equals("")){
            Skill skill = new Skill();
            skill.setSkillNm(str);
            member.getCharacter().getMemSkills().add(skill);
        }
    }
    public void addMemAwards(){
        String str = awardsTexts.get(awardsTexts.size() - 1).getText();
        if(!str.equals("")){
            MemberAwards awards = new MemberAwards();
            awards.setAwardContent(str);
            member.getCharacter().getMemberAwards().add(awards);
        }
    }
    public void addMemPPLinks() {
        String str = portfolioTexts.get(portfolioTexts.size() - 1).getText();
        if(!str.equals("")){
            MemberPPLink memberPPLink = new MemberPPLink();
            memberPPLink.setMplContent(str);
            member.getCharacter().getMemPPLinks().add(memberPPLink);
        }
    }
}