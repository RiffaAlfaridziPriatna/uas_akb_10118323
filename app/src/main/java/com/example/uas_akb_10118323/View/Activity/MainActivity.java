//10 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.uas_akb_10118323.R;
import com.example.uas_akb_10118323.View.Fragment.AboutFragment;
import com.example.uas_akb_10118323.View.Fragment.HomeFragment;
import com.example.uas_akb_10118323.View.Fragment.WisataFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            }

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_wisata:
                    selectedFragment = new WisataFragment();
                    break;
                case R.id.nav_about:
                    selectedFragment = new AboutFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment, selectedFragment.getClass().getName()).commit();

            return true;
        });
    }
}