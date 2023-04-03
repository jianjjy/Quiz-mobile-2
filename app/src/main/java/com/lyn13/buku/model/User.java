package com.lyn13.buku.model;


import androidx.annotation.Size;

import org.w3c.dom.Text;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

@RealmClass
public class User extends RealmObject {
    @PrimaryKey
    @Size(max = 99999999999L)
    private Integer idbuku;

    @Required
    private String judul;

    @Required
    @Size(max = 200)
    private String pengarang, penerbit;

    @Required
    @Size(max = 9999)
    private Integer tahunTerbit;

    public User() {
    }

    public User(Integer idbuku, String judul, String pengarang, String penerbit, Integer tahunTerbit) {
        this.idbuku = idbuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
    }

    public Integer getidbuku() {
        return idbuku;
    }

    public void setidbuku(Integer idbuku) {
        this.idbuku = idbuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public Integer getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(Integer tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
}
