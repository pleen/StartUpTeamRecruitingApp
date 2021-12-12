package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Challenge extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ChallengePageAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);
        pagerAdapter = new ChallengePageAdapter(this);

        pagerAdapter.addFragment(new Fragment_challenge_list());
        pagerAdapter.addFragment(new Fragment_challenge_party());
        pagerAdapter.addFragment(new Fragment_challenge_member());
        String[] tabLayoutTextArray= new String[]{"챌린지 목록", "파티 모집", "파티원 찾기"};

        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabLayoutTextArray[position])
        ).attach();


        return view;

    }
}
