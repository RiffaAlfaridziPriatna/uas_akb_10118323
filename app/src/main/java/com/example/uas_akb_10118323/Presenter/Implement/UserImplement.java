//13 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.Presenter.Implement;

import androidx.annotation.NonNull;

import com.example.uas_akb_10118323.Presenter.Interface.UserInterface;
import com.example.uas_akb_10118323.Presenter.Listener.OnGetDataListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class UserImplement extends DatabaseImplement implements UserInterface {

    @Override
    public void read(OnGetDataListener onGetDataListener) {
        onGetDataListener.onStart();
        this.users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                onGetDataListener.onSuccess(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                onGetDataListener.onFailure();
            }
        });
    }
}
