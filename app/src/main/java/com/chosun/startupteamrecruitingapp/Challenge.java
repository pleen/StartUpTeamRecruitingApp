package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.chosun.startupteamrecruitingapp.ChallengeList;
import com.chosun.startupteamrecruitingapp.ChallengePartyFind;
import com.chosun.startupteamrecruitingapp.ChallengePartyRecruit;
import com.chosun.startupteamrecruitingapp.PageAdapter;
import com.chosun.startupteamrecruitingapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Challenge extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    PageAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);
        pagerAdapter = new PageAdapter(this);

        pagerAdapter.addFragment(new ChallengeList());
        pagerAdapter.addFragment(new ChallengePartyRecruit());
        pagerAdapter.addFragment(new ChallengePartyFind());
        String[] tabLayoutTextArray= new String[]{"챌린지 목록", "파티 모집", "파티원 찾기"};

        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabLayoutTextArray[position])
        ).attach();

        return view;

    }
}
