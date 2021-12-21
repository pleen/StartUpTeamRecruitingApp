package com.chosun.startupteamrecruitingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignIn extends Fragment {
    EditText id;
    EditText pw;
    Button signInBtn;
    Retrofit retrofit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);
        signInBtn = rootView.findViewById(R.id.signin_btn);
        id = rootView.findViewById(R.id.id_text);
        pw = rootView.findViewById(R.id.password_text);
        signInBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signin_to_main, null));
        retrofit = ((MainActivity) MainActivity.context).retrofit;

        SharedPreferences sp = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = id.getText().toString();
                String pwStr = pw.getText().toString();
                if(idStr.isEmpty()||pwStr.isEmpty()) {
                    Toast.makeText(getContext(), "아이디/비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                LoginDTO loginDTO = new LoginDTO(idStr,pwStr);
                RetrofitInterface service = retrofit.create(RetrofitInterface.class);
                Call<Void> call = service.login(loginDTO);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Log.e("jwt_token",response.headers().get("Authorization"));
                            editor.putString("jwt_token",response.headers().get("Authorization"));
                            Navigation.findNavController(rootView).navigate(R.id.action_signin_to_main);
                        } else {
                            Log.d("jwt_token", "error code: "+response.code());
                            if(response.code() == 401)
                                Toast.makeText(getContext(), "이메일 인증을 진행해 주십시오.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("jwt_token", "onFailure():" + t.getMessage());
                    }
                });
            }
        });
        return rootView;
    }
}
