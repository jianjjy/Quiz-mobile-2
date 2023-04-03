//Nama: Vellyn Natalie
//NIM: 03081210008
//Kelas: 21SI2

package com.lyn13.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lyn13.buku.model.User;

import javax.crypto.ExemptionMechanism;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().allowWritesOnUiThread(true).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);

        Button btnTambah = (Button) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, TambahActivity.class);
                startActivity(intent);
            }
        });

        Button btnCetak = (Button) findViewById(R.id.btnCetak);
        btnCetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, CetakHapusActivity.class);
                startActivity(intent);
            }
        });

    }


}