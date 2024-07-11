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

public class UrunlerListesi extends AppCompatActivity {

    ArrayList<String > urunAdlari = new ArrayList<>();
    ArrayList<Integer > urunFiyatlari = new ArrayList<>();
    ArrayList<Integer > urunStoklari = new ArrayList<>();

    ArrayList<Integer> urunFotograflari = new ArrayList<>();

//    ArrayList<String > listViewUrunAdlari = new ArrayList<>();
    ListView myListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urunler_listesi);


        myListView = findViewById(R.id.urunlerList);

//        urunAdlari.add("Gömlek");
//        urunAdlari.add("T-Shirt");
//        urunAdlari.add("Etek");
//        urunAdlari.add("Pantolon");
//        urunAdlari.add("Çorap");
//        urunAdlari.add("Ayakkabı");
//        urunAdlari.add("Kemer");
//        urunAdlari.add("Elbise");
//        urunAdlari.add("Mont");
//        urunAdlari.add("Ceket");
//

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






//        urunFiyatlari.add(250);
//        urunFiyatlari.add(150);
//        urunFiyatlari.add(100);
//        urunFiyatlari.add(350);
//        urunFiyatlari.add(50);
//        urunFiyatlari.add(250);
//        urunFiyatlari.add(75);
//        urunFiyatlari.add(550);
//        urunFiyatlari.add(650);
//        urunFiyatlari.add(350);
//
//        urunStoklari.add(150);
//        urunStoklari.add(1000);
//        urunStoklari.add(650);
//        urunStoklari.add(2500);
//        urunStoklari.add(1500);
//        urunStoklari.add(350);
//        urunStoklari.add(7500);
//        urunStoklari.add(2500);
//        urunStoklari.add(150);
//        urunStoklari.add(300);





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
            myListView.setAdapter(arrayAdapter);





        }catch (Exception e){
            toast("Bir Hata Oluştu!!!");
        }


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent sayfayaGit = new Intent(UrunlerListesi.this, UrunDetay.class);
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
        startActivity(new Intent(this, YonetimAnaSayfa.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================


}