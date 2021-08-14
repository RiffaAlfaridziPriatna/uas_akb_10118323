//14 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uas_akb_10118323.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private CardView cvLoading;
    private ImageView ivBack, ivGambar;
    private TextView tvDestinasi, tvAlamat, tvBuka, tvDeskripsi;
    private AppCompatRatingBar ratingBar;
    private LatLng latLng;
    private ScrollView scrollDetail;
    private GoogleMap map;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_detail);
        init();
    }

    private void init() {
        cvLoading = findViewById(R.id.cvLoading);
        ivBack = findViewById(R.id.ivBack);
        ivGambar = findViewById(R.id.ivGambar);
        tvDestinasi = findViewById(R.id.tvDestinasi);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvBuka = findViewById(R.id.tvBuka);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        ratingBar = findViewById(R.id.ratingBar);
        scrollDetail = findViewById(R.id.scrollDetail);

        scrollDetail.setVisibility(View.GONE);
        cvLoading.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Picasso.get().load(getIntent().getStringExtra("gambar")).into(ivGambar, new Callback() {
            @Override
            public void onSuccess() {
                scrollDetail.setVisibility(View.VISIBLE);
                cvLoading.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(DetailActivity.this, "Error downloading image!", Toast.LENGTH_SHORT).show();
            }
        });
        ratingBar.setRating(Float.parseFloat(getIntent().getStringExtra("rating")));
        tvDestinasi.setText(getIntent().getStringExtra("destinasi"));
        tvAlamat.setText(getIntent().getStringExtra("lokasi"));
        tvBuka.setText(getIntent().getStringExtra("buka"));
        tvDeskripsi.setText(getIntent().getStringExtra("deskripsi"));
        latLng = new LatLng(Double.parseDouble(getIntent().getStringExtra("latitude")), Double.parseDouble(getIntent().getStringExtra("longitude")));

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        supportMapFragment.getMapAsync(this);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng latLng = new LatLng(this.latLng.latitude, this.latLng.longitude);
        map.addMarker(new MarkerOptions().position(latLng).title("Coba"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
    }
}