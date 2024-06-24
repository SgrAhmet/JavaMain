package com.ahmetayds.uygulamasinavi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Integer[] ogrencilerNo= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    String[] ogrencilerAd={

            "Ahmet", "Tolga", "Mehmet", "Umut", "Anil", "Melih", "Kerem", "Alperen", "Barış", "Berfin", "Beyza", "Cahit", "Defne", "Elif", "Furkan", "İlknur", "Murat", "Nilgün", "Rıdvan", "Keren"};

    String[] ogrencilerSoyad={

            "Günay", "Kıraç", "Aydın", "Tunçer", "Evren", "Abat", "Uzbay", "Gökcan", "Güler", "Kör", "Aflaz", "Duran", "Nayir", "Şimşek", "Ekşi", "Çetinkaya", "Çetinsoy", "Kömür", "Özlale", "Yiğit"};

    String[] ogrencilerKullaniciAdi={

            "ahmetgunay", "tolgakirac", "mehmetaydin", "umuttuncer", "anilevren", "melihabat", "keremuzbay", "alperengokcan", "barisguler", "berfinkor", "beyzaaflaz", "cahitduran", "defnenayir", "elifsimsek", "furkaneksi", "ilknurcetinkaya", "muratcetinsoy", "nilgunkomur", "ridvanozlale", "keremyigit"};



    String ogrenciSifre="12345";

    String ogretmenKullanıcıAdi = "ozlemaytekinadmin";

    String ogretmenSifre="54321";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dosyayaKaydet();
    }





    public void dosyayaKaydet(){
        SharedPreferences isimleriKaydet = this.getSharedPreferences("dosyam", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = isimleriKaydet.edit();

        for (int i = 0; i < ogrencilerAd.length;i++){
            String sira = String.valueOf(i);
            String anahtar1 = "no" + sira;
            String anahtar2 = "isim" + sira;
            String anahtar3 = "soyisim" + sira;
            String anahtar4 = "kullaniciAdi" + sira;
            String anahtar5 = anahtar1 + "kullanılanHak";

            editor.putInt(anahtar1,ogrencilerNo[i]);
            editor.putString(anahtar2,ogrencilerAd[i]);
            editor.putString(anahtar3,ogrencilerSoyad[i]);
            editor.putString(anahtar4,ogrencilerKullaniciAdi[i]);
            editor.putInt(anahtar5,0);
        }
        editor.putString("ogrenciSifre",ogrenciSifre);
        editor.putString("ogretmenKullanıcıAdi",ogretmenKullanıcıAdi);
        editor.putString("ogretmenSifre",ogretmenSifre);
        editor.apply();
    }




    public void ogretmenGirisiGit(View view){
        Intent sayfayaGit = new Intent(this, OgretmenGirisi.class);
        startActivity(sayfayaGit);
    }
    public void ogrenciGirisiGit(View view){
        Intent sayfayaGit = new Intent(this, OgrenciGirisi.class);
        startActivity(sayfayaGit);
    }

}