//14 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.Presenter.Interface;

import com.example.uas_akb_10118323.Presenter.Listener.OnGetDataListener;

public interface WisataInterface {
    void read(String kota, String objek, OnGetDataListener onGetDataListener);
}
