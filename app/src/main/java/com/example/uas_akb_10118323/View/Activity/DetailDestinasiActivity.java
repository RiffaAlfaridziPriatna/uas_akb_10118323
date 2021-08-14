//14 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uas_akb_10118323.Model.WisataModel;
import com.example.uas_akb_10118323.Presenter.Adapter.ListDestinasiAdapter;
import com.example.uas_akb_10118323.Presenter.Implement.WisataImplement;
import com.example.uas_akb_10118323.Presenter.Listener.OnGetDataListener;
import com.example.uas_akb_10118323.R;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class DetailDestinasiActivity extends AppCompatActivity {

    private ImageView ivBack;
    private RecyclerView rvDestinasi;
    private ListDestinasiAdapter destinasiAdapter;
    private ArrayList<WisataModel> list;
    private CardView cvLoading;
    private TextView tvJudul;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_detail_destinasi);
        init();
    }

    private void init() {
        rvDestinasi = findViewById(R.id.rvDestinasi);
        ivBack = findViewById(R.id.ivBack);
        cvLoading = findViewById(R.id.cvLoading);
        tvJudul = findViewById(R.id.tvJudul);

        rvDestinasi.setVisibility(View.GONE);
        cvLoading.setVisibility(View.VISIBLE);
    }

    public void hidden() {
        cvLoading.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvJudul.setText("Destinasi " + getIntent().getStringExtra("selectedObject"));

        list = new ArrayList<>();
        WisataImplement wisataImplement = new WisataImplement();
        wisataImplement.read(
                getIntent().getStringExtra("selectedKota").toLowerCase(),
                getIntent().getStringExtra("selectedObject").toLowerCase(),
                new OnGetDataListener() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {
                        list.add(new WisataModel(
                                String.valueOf(dataSnapshot.child("name").getValue()),
                                String.valueOf(dataSnapshot.child("alamat").getValue()),
                                String.valueOf(dataSnapshot.child("rating").getValue()),
                                String.valueOf(dataSnapshot.child("gambar").getValue()),
                                String.valueOf(dataSnapshot.child("deskripsi").getValue()),
                                String.valueOf(dataSnapshot.child("buka").getValue()),
                                String.valueOf(dataSnapshot.child("longitude").getValue()),
                                String.valueOf(dataSnapshot.child("latitude").getValue())
                        ));
                        destinasiAdapter = new ListDestinasiAdapter(DetailDestinasiActivity.this, DetailDestinasiActivity.this, list);
                        rvDestinasi.setAdapter(destinasiAdapter);
                        rvDestinasi.setLayoutManager(new LinearLayoutManager(DetailDestinasiActivity.this, LinearLayoutManager.VERTICAL, false));
                        destinasiAdapter.notifyDataSetChanged();
                        rvDestinasi.setVisibility(View.VISIBLE);
                        cvLoading.setVisibility(View.GONE);
                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onFailure() {

                    }
                });

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
}