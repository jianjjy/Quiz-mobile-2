package com.lyn13.buku.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lyn13.buku.EditActivity;
import com.lyn13.buku.R;
import com.lyn13.buku.crud.userCRUD;
import com.lyn13.buku.model.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, List<User> objects) {
        super(context, 0, objects);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listviewbuku, parent, false);
        }

        TextView txvIdBuku = (TextView) convertView.findViewById(R.id.txvIdBuku);
        TextView txvJudul= (TextView) convertView.findViewById(R.id.txvJudul);
        TextView txvPengarang= (TextView) convertView.findViewById(R.id.txvPengarang);
        TextView txvPenerbit = (TextView) convertView.findViewById(R.id.txvPenerbit);
        TextView txvTahunTerbit= (TextView) convertView.findViewById(R.id.txvTahunTerbit);

        txvIdBuku.setText(user.getidbuku().toString());
        txvJudul.setText(user.getJudul());
        txvPengarang.setText(user.getPengarang());
        txvPenerbit.setText(user.getPenerbit());
        txvTahunTerbit.setText(user.getTahunTerbit().toString());

        Button BtnEdit = (Button) convertView.findViewById(R.id.BtnEdit);
        BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), EditActivity.class);
                intent.putExtra("idbuku", user.getidbuku().toString());
                intent.putExtra("judul", user.getJudul());
                intent.putExtra("pengarang", user.getPengarang());
                intent.putExtra("penerbit", user.getPenerbit());
                intent.putExtra("tahunTerbit", user.getTahunTerbit().toString());
                getContext().startActivity(intent);
            }
        });

        Button BtnDelete = (Button) convertView.findViewById(R.id.BtnDelete);
        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCRUD usercrud = new userCRUD();
                usercrud.deleteDataUser(user.getidbuku());
                notifyDataSetChanged();
            }
        });

        return convertView;

    }

}
