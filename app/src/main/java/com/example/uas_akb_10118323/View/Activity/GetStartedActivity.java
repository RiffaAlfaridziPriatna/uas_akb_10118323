//14 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uas_akb_10118323.R;
import com.google.android.material.tabs.TabLayout;

public class GetStartedActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TabLayout tab;
    private TextView tvNext, tvSkip;
    private ProgressDialog progressDialog;
    private ConstraintLayout clStarted;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_get_started);
        init();
    }

    private void init() {
        tab = findViewById(R.id.tabStart);
        viewPager = findViewById(R.id.pagerStart);
        tvNext = findViewById(R.id.tvNext);
        tvSkip = findViewById(R.id.tvSkip);
        clStarted = findViewById(R.id.clStarted);
        progressDialog = new ProgressDialog(GetStartedActivity.this);
        adapter = new ViewPagerAdapter(GetStartedActivity.this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == adapter.getCount() - 1)  tvSkip.setVisibility(View.GONE);
                else tvSkip.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clStarted.setVisibility(View.INVISIBLE);
                progressDialog.show();
                progressDialog.setContentView(R.layout.custom_loading);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                startActivity(new Intent(GetStartedActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tab.getSelectedTabPosition() == adapter.getCount() - 1) {
                    clStarted.setVisibility(View.GONE);
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.custom_loading);
                    progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    startActivity(new Intent(GetStartedActivity.this, MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                } else viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        });
    }

    private class ViewPagerAdapter extends PagerAdapter {
        private String[] text = {
                "Welcome to Explore Bandung Raya",
                "Are you confused about where to go in Bandung Raya?",
                "You can see a lot of destination in Bandung Raya",
                "Enjoy!"
        };
        private int[] img = {
                R.drawable.ic_welcome,
                R.drawable.ic_question,
                R.drawable.ic_map,
                R.drawable.ic_nature
        };
        private Context context;

        public ViewPagerAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.layout_info, null);

            ImageView imgView = layout.findViewById(R.id.image_viewpager);
            TextView tvPager = layout.findViewById(R.id.text_viewpager);

            imgView.setImageResource(img[position]);
            tvPager.setText(text[position]);
            container.addView(layout);
            return layout;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}