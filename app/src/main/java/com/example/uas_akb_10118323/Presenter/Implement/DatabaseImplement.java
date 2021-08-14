//12 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.Presenter.Implement;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseImplement {
    public FirebaseDatabase database;
    public DatabaseReference users;
    public DatabaseReference destinasi;

    public DatabaseImplement() {
        database = FirebaseDatabase.getInstance("https://uasakb-c663d-default-rtdb.asia-southeast1.firebasedatabase.app/");
        users = database.getReference("users");
        destinasi = database.getReference("destinasi");
    }
}
