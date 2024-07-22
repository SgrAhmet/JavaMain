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

public class UrunListeMusteri extends AppCompatActivity {

    ListView urunlerListesi;



    ArrayList<String > urunAdlari = new ArrayList<>();
    ArrayList<Integer > urunFiyatlari = new ArrayList<>();
    ArrayList<Integer > urunStoklari = new ArrayList<>();

    ArrayList<Integer> urunFotograflari = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_liste_musteri);

        urunlerListesi = findViewById(R.id.urunlerListesi);




        urunFotograflari.add(R.drawable.nobile_slim_smokin_beyaz_gomlek_3642_damatlik_gomlek_sarar_12016_36_b);
        urunFotograflari.add(R.drawable.heart);
        urunFotograflari.add(R.drawable.skirt);
        urunFotograflari.add(R.drawable.pants);
        urunFotograflari.add(R.drawable.socks);
        urunFotograflari.add(R.drawable.sneakers);
        urunFotograflari.add(R.drawable.belt);
        urunFotograflari.add(R.drawable.dress);
        urunFotograflari.add(R.drawable.coat);
        urunFotograflari.add(R.drawable.jacket);



        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);
//            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY AUTOINCREMENT, urunAdi VARCHAR(50),fiyat INTEGER, stokAdedi INTEGER)");
//
//            for (int i = 0 ; i < urunAdlari.size() ; i++){
//                System.out.println(urunAdlari.get(i));
//                System.out.println(urunFiyatlari.get(i));
//                System.out.println(urunStoklari.get(i));
//
//                veriTabani.execSQL("INSERT INTO urunler (urunAdi,fiyat,stokAdedi) VALUES ( '" + urunAdlari.get(i) +"','" + urunFiyatlari.get(i) +"','" + urunStoklari.get(i) + "')" );
//
//                System.out.println("==================ÜRÜN KAYDEDİLDİ===================  --" + i );
//
//            }

            Cursor cursor =veriTabani.rawQuery("SELECT * FROM urunler",null);

            int urunAdlariX = cursor.getColumnIndex("urunAdi");
            int fiyatlarX = cursor.getColumnIndex("fiyat");
            int stokAdedleriX = cursor.getColumnIndex("stokAdedi");


            while (cursor.moveToNext()){
                String urunAdi= cursor.getString(urunAdlariX);
                int urunFiyati = cursor.getInt(fiyatlarX);
                int stokAdedi = cursor.getInt(stokAdedleriX);
                urunAdlari.add(urunAdi);
                urunFiyatlari.add(urunFiyati);
                urunStoklari.add(stokAdedi);
            }


            ArrayAdapter arrayAdapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1,urunAdlari);
            urunlerListesi.setAdapter(arrayAdapter);





        }catch (Exception e){
            toast("Bir Hata Oluştu!!!");
        }


        urunlerListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent sayfayaGit = new Intent(UrunListeMusteri.this, MusteriUrunDetay.class);
                sayfayaGit.putExtra("urunAdi" , urunAdlari.get(position) );
                sayfayaGit.putExtra("urunFiyati" , urunFiyatlari.get(position) );
                sayfayaGit.putExtra("stokAdedi" , urunStoklari.get(position) );
                sayfayaGit.putExtra("urunFotograf" , urunFotograflari.get(position) );

                startActivity(sayfayaGit);
            }
        });


    }



    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, MusteriAnaSayfa.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}