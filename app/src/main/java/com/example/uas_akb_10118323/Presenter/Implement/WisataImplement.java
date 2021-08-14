//14 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.Presenter.Implement;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.uas_akb_10118323.Presenter.Interface.WisataInterface;
import com.example.uas_akb_10118323.Presenter.Listener.OnGetDataListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class WisataImplement extends DatabaseImplement implements WisataInterface {
    @Override
    public void read(String kota, String objek, OnGetDataListener onGetDataListener) {
        onGetDataListener.onStart();
        String generatedKota = generateKota(kota);
        this.destinasi.child(generatedKota).child(objek).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    onGetDataListener.onSuccess(ds);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                onGetDataListener.onFailure();
            }
        });
    }

    private String generateKota(String kota) {
        String convertedKota = "";

        switch (kota) {
            case "kota bandung":
                convertedKota = "bandung";
                break;
            case "kota cimahi":
                convertedKota = "cimahi";
                break;
            case "kabupaten bandung barat":
                convertedKota = "kbb";
                break;
            case "kabupaten bandung":
                convertedKota = "kb";
                break;
        }

        return convertedKota;
    }
}
