package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChallengeList extends Fragment {
    Retrofit retrofit;
    private ListView listview ;
    private ChallengeListViewAdapter adapter;
    List<ChallengeDTO> result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_challenge_list, container, false);
        retrofit = ((MainActivity) MainActivity.context).retrofit;
        // 리스트뷰 참조 및 Adapter달기
        listview = rootView.findViewById(R.id.challenge_listview);
        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<List<ChallengeDTO>> call = service.challenges();
        call.enqueue(new Callback<List<ChallengeDTO>>() {
            @Override
            public void onResponse(Call<List<ChallengeDTO>> call, Response<List<ChallengeDTO>> response) {
                if (response.isSuccessful()) {
                    Log.e("challenge",response.body().toString());
                    result = response.body();
                    // Adapter 생성
                    adapter = new ChallengeListViewAdapter(result);
                    listview.setAdapter(adapter);
                } else {
                    Log.d("challenge", "error code: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<List<ChallengeDTO>> call, Throwable t) {
                Log.d("challenge", "onFailure():" + t.getMessage());
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(result.get(position).getHomepage()!=null)
                    ((MainActivity)getActivity()).openURL(result.get(position).getHomepage());
            }
        });
        return rootView;
    }
}