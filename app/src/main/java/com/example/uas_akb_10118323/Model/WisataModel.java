//14 Agustus 2021 - 10118323 - Riffa Alfaridzi Priatna - IF8
package com.example.uas_akb_10118323.Model;

public class WisataModel {
    private String nama;
    private String alamat;
    private String rating;
    private String gambar;
    private String deskripsi;
    private String buka;
    private String longitude;
    private String latitude;

    public WisataModel(String nama, String alamat, String rating, String gambar, String deskripsi, String buka, String longitude, String latitude) {
        this.nama = nama;
        this.alamat = alamat;
        this.rating = rating;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.buka = buka;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getBuka() {
        return buka;
    }

    public void setBuka(String buka) {
        this.buka = buka;
    }
}
