package com.lyn13.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lyn13.buku.crud.userCRUD;

public class EditActivity extends AppCompatActivity {

    EditText edtJudule, edtPengarange, edtPenerbite, edtTahunTerbite;
    TextView edtIdBukue;
    Button btnSimpane;
    Integer idbuku;
    String judul = "";
    String pengarang = "";
    String penerbit = "";
    Integer tahunTerbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtIdBukue = (TextView) findViewById(R.id.edtIdBukue);
        edtJudule = (EditText) findViewById(R.id.edtJudule);
        edtPengarange = (EditText) findViewById(R.id.edtPengarange);
        edtPenerbite = (EditText) findViewById(R.id.edtPenerbite);
        edtTahunTerbite = (EditText) findViewById(R.id.edtTahunTerbite);
        btnSimpane = (Button) findViewById(R.id.btnSimpane);


        edtIdBukue.setText(getIntent().getStringExtra("idbuku"));
        edtJudule.setText(getIntent().getStringExtra("judul"));
        edtPengarange.setText(getIntent().getStringExtra("pengarang"));
        edtPenerbite.setText(getIntent().getStringExtra("penerbit"));
        edtTahunTerbite.setText(getIntent().getStringExtra("tahunTerbit"));

        btnSimpane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idbuku = Integer.parseInt(edtIdBukue.getText().toString());
                judul = edtJudule.getText().toString();
                pengarang = edtPengarange.getText().toString();
                penerbit = edtPenerbite.getText().toString();
                tahunTerbit = Integer.parseInt(edtTahunTerbite.getText().toString());


//               Log.d("TAG", "Nama" + Nama + "Nomor Tlp" + NoTlp);
                userCRUD usercrud = new userCRUD();
                usercrud.updateDataUser(idbuku, judul, pengarang, penerbit, tahunTerbit);
                finish();
            }
        });

    }
}