//10 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.uas_akb_10118323.R;
import com.example.uas_akb_10118323.View.Activity.DetailDestinasiActivity;

public class WisataFragment extends Fragment {

    private Button btnLokasi;
    private CardView cvAlam, cvReligi, cvBudaya, cvKuliner, cvBelanja, cvRekreasi, cvLoading;
    private LinearLayout llResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_wisata, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        btnLokasi = root.findViewById(R.id.btnLokasi);
        cvAlam = root.findViewById(R.id.cvAlam);
        cvBelanja = root.findViewById(R.id.cvBelanja);
        cvBudaya = root.findViewById(R.id.cvBudaya);
        cvKuliner = root.findViewById(R.id.cvKuliner);
        cvRekreasi = root.findViewById(R.id.cvRekreasi);
        cvReligi = root.findViewById(R.id.cvReligi);
        cvLoading = root.findViewById(R.id.cvLoading);
        llResult = root.findViewById(R.id.llResult);

        cvLoading.setVisibility(View.VISIBLE);
        llResult.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        cvLoading.setVisibility(View.GONE);
        llResult.setVisibility(View.VISIBLE);
        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment(String.valueOf(btnLokasi.getText()));
                bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());
                bottomSheetFragment.setOnDismisslistener(new BottomSheetFragment.OnDismisslistener() {
                    @Override
                    public void onDismiss(String kota) {
                        btnLokasi.setText(kota);
                        bottomSheetFragment.dismiss();
                    }
                });
            }
        });
        cvAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailDestinasiActivity.class);
                intent.putExtra("selectedKota", String.valueOf(btnLokasi.getText()));
                intent.putExtra("selectedObject", "Alam");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cvReligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailDestinasiActivity.class);
                intent.putExtra("selectedKota", String.valueOf(btnLokasi.getText()));
                intent.putExtra("selectedObject", "Religi");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cvBudaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailDestinasiActivity.class);
                intent.putExtra("selectedKota", String.valueOf(btnLokasi.getText()));
                intent.putExtra("selectedObject", "Budaya");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cvKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailDestinasiActivity.class);
                intent.putExtra("selectedKota", String.valueOf(btnLokasi.getText()));
                intent.putExtra("selectedObject", "Kuliner");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cvBelanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailDestinasiActivity.class);
                intent.putExtra("selectedKota", String.valueOf(btnLokasi.getText()));
                intent.putExtra("selectedObject", "Belanja");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        cvRekreasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailDestinasiActivity.class);
                intent.putExtra("selectedKota", String.valueOf(btnLokasi.getText()));
                intent.putExtra("selectedObject", "Rekreasi");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}