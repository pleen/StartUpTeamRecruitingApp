package com.chosun.startupteamrecruitingapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchUniv extends Fragment {
    Retrofit retrofit;
    private ListView listView;
    private EditText searchUnivText;
    private List<University> univNames;
    private List<University> searchedUnivNames = new ArrayList<>();
    private UniversityListAdapter adapter;
    private University selectedUniv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_univ, container, false);
        retrofit = ((MainActivity) MainActivity.context).retrofit;
        ImageView closeIcon= (ImageView)rootView.findViewById(R.id.close_btn);
        closeIcon.setOnClickListener(v -> ((MainActivity)getActivity()).onBackPressed());

        listView = (ListView)rootView.findViewById(R.id.univ_list);
        searchUnivText = (EditText)rootView.findViewById(R.id.univ_search_text);

        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<List<University>> call = service.getUnivs();
        call.enqueue(new Callback<List<University>>() {
            @Override
            public void onResponse(Call<List<University>> call, Response<List<University>> response) {
                if (response.isSuccessful()) {
                    List<University> result = response.body();
                    Log.d("Retrofit", result.toString());
                    univNames = result;
                    adapter = new UniversityListAdapter(univNames);
                    listView.setAdapter(adapter);
                } else {
                    Log.d("Retrofit", "onResponse 실패");
                }
            }

            @Override
            public void onFailure(Call<List<University>> call, Throwable t) {
                Log.d("Retrofit", "onFailure()" + t.getMessage());
            }
        });
        searchUnivText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String keyword = searchUnivText.getText().toString();
                searchProc(keyword);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                if(searchUnivText.getText().length()==0) {
                    selectedUniv = univNames.get(position);
                }
                else {
                    selectedUniv = searchedUnivNames.get(position);
                }
                bundle.putString("selectedUnivName", selectedUniv.getUnivNm());
                bundle.putString("selectedUnivDomain", selectedUniv.getUnivDomain());
                getParentFragmentManager().setFragmentResult("univKey", bundle);
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        return rootView;
    }
    private void searchProc(String keyword){
        searchedUnivNames.clear();

        if(keyword.length() == 0){
            searchedUnivNames.addAll(univNames);
            Log.d("searchProc","univNames"+searchedUnivNames);
        }else{
            for(int i=0; i<univNames.size(); i++){
                if(univNames.get(i).getUnivNm().toLowerCase().contains(keyword)){
                    searchedUnivNames.add(univNames.get(i));
                    Log.d("searchProc","univNames"+univNames.get(i));
                }
            }
        }
        adapter.convertList(searchedUnivNames);
    }

    private List<String> getUnivNames(List<University> univs){
        List<String> names = new ArrayList<>();
        for(int i=0; i<univs.size(); i++){
            String name = univs.get(i).getUnivNm();
            names.add(name);
        }
        return names;
    }
}