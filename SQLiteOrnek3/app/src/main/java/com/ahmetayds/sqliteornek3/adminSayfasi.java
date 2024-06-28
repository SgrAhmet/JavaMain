package com.ahmetayds.sqliteornek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class adminSayfasi extends AppCompatActivity {

    ArrayList<String> kullaniciIsimleri = new ArrayList<>();

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sayfasi);

        listView = findViewById(R.id.listView);



        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
            Cursor cursor =veriTabani.rawQuery("SELECT * FROM kullanicilar",null);

            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");


            while(cursor.moveToNext()){
                String kullanıciAdi = cursor.getString(kullanıciAdlari);
                kullaniciIsimleri.add(kullanıciAdi);
            }

            System.out.println(kullaniciIsimleri);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,kullaniciIsimleri);
            listView.setAdapter(adapter);
            cursor.close();


        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
        }



    }


    public void geriGit(View view){
        startActivity(new Intent(this, girisEkrani.class));
    }
}