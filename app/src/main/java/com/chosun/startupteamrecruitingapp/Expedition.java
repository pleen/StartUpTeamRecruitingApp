package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Expedition extends Fragment {
    // 뷰 선언
    ImageButton createBtn;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    PageAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_expedition, container, false);

        // XML에서 뷰 ID 가져오기
        createBtn = rootView.findViewById(R.id.create_button);
        tabLayout = rootView.findViewById(R.id.tablayout);
        viewPager = rootView.findViewById(R.id.viewPager);
        pagerAdapter = new PageAdapter(this);

        // 상단 탭 프래그먼트 추가 및 아이디 생성
        pagerAdapter.addFragment(new ExpeditionList());
        pagerAdapter.addFragment(new ExpeditionMemberFind());
        String[] tabLayoutTextArray= new String[]{"원정대 목록", "원정대원 찾기"};

        // 어댑터 장착, 집어 넣어주기
        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabLayoutTextArray[position])
        ).attach();

        // 뷰페이저 충돌 방지
        viewPager.setSaveEnabled(false);

        // 원정대 생성 + 버튼
        createBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_goto_expedition_create));


        return rootView;
    }

}
