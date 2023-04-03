package com.lyn13.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.lyn13.buku.adapter.UserAdapter;
import com.lyn13.buku.model.User;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class CetakHapusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak_hapus);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> users = realm.where(User.class).findAll();

        ArrayList<User> arrayofuser = new ArrayList<User>();
        arrayofuser.addAll(realm.copyFromRealm(users));
        realm.close();

        UserAdapter userAdapter = new UserAdapter(this, arrayofuser);
        ListView listView = (ListView) findViewById(R.id.listViewBuku);
        listView.setAdapter(userAdapter);
    }
}