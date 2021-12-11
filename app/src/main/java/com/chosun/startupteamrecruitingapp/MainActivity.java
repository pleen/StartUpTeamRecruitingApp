package com.chosun.startupteamrecruitingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    NavHostFragment navHostFragment;
    NavController navController;
    AppBarConfiguration appBarConfiguration;
//    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        navController = navHostFragment.getNavController();
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getParent().getId()==R.id.onboarding) {
//                    toolbar.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.GONE);
                } else if(destination.getParent().getId()==R.id.signup){
//                    toolbar.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.GONE);
//                    findViewById(R.id.signup_title).setVisibility(View.VISIBLE);
//                    findViewById(R.id.close_btn).setVisibility(View.VISIBLE);
                } else if(destination.getParent().getId()==R.id.main){
//                    toolbar.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}