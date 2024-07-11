package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AktifMusteriler extends AppCompatActivity {

    ListView aktifList;
    ArrayList<String > kullaniciAdlariArrayList = new ArrayList<>();

    ArrayList<String > isimArrayList = new ArrayList<>();
    ArrayList<String > soyisimAdlariArrayList = new ArrayList<>();
    ArrayList<String > cinsiyetArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktif_musteriler);

        aktifList = findViewById(R.id.aktifList);

        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);
            Cursor cursor =veriTabani.rawQuery("SELECT * FROM musteriler",null);

            int kullaniciAdiX = cursor.getColumnIndex("kullaniciAdi");
            int isimX = cursor.getColumnIndex("isim");
            int soyisimX = cursor.getColumnIndex("soyisim");
            int cinsiyetX = cursor.getColumnIndex("cinsiyet");

            int onayX = cursor.getColumnIndex("onay");

            while (cursor.moveToNext()){
                String kullaniciAdi= cursor.getString(kullaniciAdiX);
                String isim= cursor.getString(isimX);
                String soyisim= cursor.getString(soyisimX);
                String cinsiyet= cursor.getString(cinsiyetX);
                int onay = cursor.getInt(onayX);

                if(onay == 1){
                    kullaniciAdlariArrayList.add(kullaniciAdi);
                    isimArrayList.add(isim);
                    soyisimAdlariArrayList.add(soyisim);
                    cinsiyetArrayList.add(cinsiyet);
                }
            }



            ArrayAdapter arrayAdapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1,kullaniciAdlariArrayList);
            aktifList.setAdapter(arrayAdapter);


        }catch (Exception e){
            toast("Bir HAta Oluştu!!!");
        }

        aktifList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent sayfayaGit = new Intent(AktifMusteriler.this, AktifDetay.class);
                sayfayaGit.putExtra("kullaniciAdi" , kullaniciAdlariArrayList.get(position) );
                sayfayaGit.putExtra("isim" , isimArrayList.get(position) );
                sayfayaGit.putExtra("soyisim" , soyisimAdlariArrayList.get(position) );
                sayfayaGit.putExtra("cinsiyet" , cinsiyetArrayList.get(position) );

                startActivity(sayfayaGit);
            }
        });



    }






    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, YonetimAnaSayfa.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}