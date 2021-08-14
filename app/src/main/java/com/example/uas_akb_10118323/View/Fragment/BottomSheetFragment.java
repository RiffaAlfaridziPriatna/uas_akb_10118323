//13 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.View.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.uas_akb_10118323.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    private OnDismisslistener onDismisslistener;
    private Button btnBandung, btnCimahi, btnKbb, btnKb;
    private String kotaSelected;

    public void setOnDismisslistener(OnDismisslistener onDismisslistener) {
        this.onDismisslistener = onDismisslistener;
    }

    public interface OnDismisslistener{
        public void onDismiss(String kota);
    }

    public BottomSheetFragment(String kotaSelected) {
        this.kotaSelected = kotaSelected;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.bottom_sheet, container, false);
        btnBandung = root.findViewById(R.id.btnBandung);
        btnCimahi = root.findViewById(R.id.btnCimahi);
        btnKbb = root.findViewById(R.id.btnKbb);
        btnKb = root.findViewById(R.id.btnKb);

        if (kotaSelected.toLowerCase().equals("kota bandung"))
            btnBandung.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24, 0);
        else if (kotaSelected.toLowerCase().equals("kota cimahi"))
            btnCimahi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24, 0);
        else if (kotaSelected.toLowerCase().equals("kabupaten bandung barat"))
            btnKbb.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24, 0);
        else
            btnKb.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24, 0);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnBandung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDismisslistener.onDismiss(String.valueOf(btnBandung.getText()));
            }
        });
        btnCimahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDismisslistener.onDismiss(String.valueOf(btnCimahi.getText()));
            }
        });
        btnKbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDismisslistener.onDismiss(String.valueOf(btnKbb.getText()));
            }
        });
        btnKb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDismisslistener.onDismiss(String.valueOf(btnKb.getText()));
            }
        });
    }
}
