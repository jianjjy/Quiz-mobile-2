package com.lyn13.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lyn13.buku.model.User;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class TambahActivity extends AppCompatActivity {

    EditText edtIdBuku, edtJudul, edtPengarang, edtPenerbit, edtTahunTerbit;
    Button btnSimpan;
    Integer idbuku;
    String Judul = "";
    String Pengarang = "";
    String Penerbit = "";
    Integer tahunTerbit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edtIdBuku = (EditText) findViewById(R.id.edtIdBuku);
        edtJudul = (EditText) findViewById(R.id.edtJudul);
        edtPengarang = (EditText) findViewById(R.id.edtPengarang);
        edtPenerbit = (EditText) findViewById(R.id.edtPenerbit);
        edtTahunTerbit = (EditText) findViewById(R.id.edtTahunTerbit);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idbuku = Integer.parseInt(edtIdBuku.getText().toString());
                Judul = edtJudul.getText().toString();
                Pengarang = edtPengarang.getText().toString();
                Penerbit = edtPenerbit.getText().toString();
                tahunTerbit = Integer.parseInt(edtTahunTerbit.getText().toString());

                tambahDataBuku(idbuku, Judul, Pengarang, Penerbit, tahunTerbit);
            }
        });
    }

    public void tambahDataBuku(Integer idbuku, String Judul, String Pengarang, String Penerbit, Integer tahunTerbit) {
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", "ID Buku" + idbuku + "Judul" + Judul + "Pengarang" + Pengarang + "Penerbit" + Penerbit + "Tahun Terbit" + tahunTerbit);
                    User user1 = realm.createObject(User.class, idbuku);
                    user1.setJudul(Judul);
                    user1.setPengarang(Pengarang);
                    user1.setPenerbit(Penerbit);
                    user1.setTahunTerbit(tahunTerbit);
                    finish();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}