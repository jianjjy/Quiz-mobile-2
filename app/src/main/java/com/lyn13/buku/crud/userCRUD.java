package com.lyn13.buku.crud;

import android.util.Log;

import com.lyn13.buku.model.User;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class userCRUD {

    public void updateDataUser(Integer idbuku, String judul, String pengarang, String penerbit, Integer tahunTerbit) {
        Realm realm = Realm.getDefaultInstance();
        //Update data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    User user1 = realm.where(User.class).equalTo("idbuku", idbuku).findFirst();
                    user1.setJudul(judul);
                    user1.setPengarang(pengarang);
                    user1.setPenerbit(penerbit);
                    user1.setTahunTerbit(tahunTerbit);
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
    public void deleteDataUser(Integer idbuku) {
        Realm realm = Realm.getDefaultInstance();
        //Update data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", "ID Buku" + idbuku);
                    User user1 = realm.where(User.class).equalTo("idbuku", idbuku).findFirst();
                    user1.deleteFromRealm();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}
