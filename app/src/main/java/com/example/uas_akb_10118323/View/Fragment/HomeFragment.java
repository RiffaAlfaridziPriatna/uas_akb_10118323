//10 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uas_akb_10118323.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private CarouselAdapter carouselAdapter;

    private Timer timer;
    private final long DELAY = 500;
    private final long PERIOD = 5000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        viewPager = root.findViewById(R.id.bannerPager);
        tabLayout = root.findViewById(R.id.tabBanner);
        carouselAdapter = new CarouselAdapter(getContext());
    }

    @Override
    public void onStart() {
        super.onStart();
        viewPager.setAdapter(carouselAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0, true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Handler handler = new Handler();
                Runnable update = new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem() == carouselAdapter.getCount() - 1) {
                            viewPager.setCurrentItem(0, true);
                        } else {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                        }
                    }
                };

                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(update);
                    }
                }, DELAY, PERIOD);
            }
        }, 5000);
    }

    private class CarouselAdapter extends PagerAdapter {
        private int[] banner = { R.drawable.satu, R.drawable.dua, R.drawable.tiga };
        private Context context;

        public CarouselAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.layout_banner, null);

            ImageView imgView = layout.findViewById(R.id.ivBanner);

            imgView.setImageResource(banner[position]);
            container.addView(layout);
            return layout;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}