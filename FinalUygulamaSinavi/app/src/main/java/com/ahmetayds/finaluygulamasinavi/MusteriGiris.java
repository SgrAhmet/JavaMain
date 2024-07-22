package com.ahmetayds.finaluygulamasinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.finaluygulamasinavi.databinding.ActivityMusteriGirisBinding;

public class MusteriGiris extends AppCompatActivity {

    ActivityMusteriGirisBinding binding;

    int girilenOnay ;


    String girilenKullaniciAdiA;
    String girilenSifreA;
    String girilenIsim;
    String girilenSoyisim;
    String girilenCinsiyet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_musteri_giris);

        binding = ActivityMusteriGirisBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



    }







    public void musteriGirisYap(View view){

        try {

            String girilenKullaniciAdi = binding.editTextText2.getText().toString();
            String  girilenSifre = binding.editTextTextPassword2.getText().toString();

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("final_db" ,MODE_PRIVATE,null);
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS musteriler (id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50),sifre VARCHAR(50),isim VARCHAR(50),soyisim VARCHAR(50) , cinsiyet VARCHAR(50) , onay INTEGER)");

            Cursor cursor =veriTabani.rawQuery("SELECT * FROM musteriler",null);

            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
            int isimX = cursor.getColumnIndex("isim");
            int soyisimX = cursor.getColumnIndex("soyisim");
            int cinsiyetX = cursor.getColumnIndex("cinsiyet");
            int sifreler = cursor.getColumnIndex("sifre");
            int onaylar = cursor.getColumnIndex("onay");




            if(girilenKullaniciAdi.isEmpty() || girilenSifre.isEmpty()){
                toast("Hiçbir Alanı Boş Bırakmayınız");
            }else{

                Boolean isLogin = false;

                while (cursor.moveToNext()){
                    String kullaniciAdi = cursor.getString(kullanıciAdlari);
                    String sifre = cursor.getString(sifreler);
                    String isim = cursor.getString(isimX);
                    String soyisim = cursor.getString(soyisimX);
                    String cinsiyet = cursor.getString(cinsiyetX);



                    if(girilenKullaniciAdi.equals(kullaniciAdi) && girilenSifre.equals(sifre)){
                        isLogin = true;
                        girilenOnay = cursor.getInt(onaylar);

                        girilenKullaniciAdiA = kullaniciAdi;
                        girilenSifreA = sifre;
                        girilenIsim = isim;
                        girilenSoyisim = soyisim;
                        girilenCinsiyet = cinsiyet;
                        break;
                    }

                }

                if(isLogin){

                    if(girilenOnay == 0){
                        toast("Onay Aşamasındasınız");
                    }else{

//                        startActivity(new Intent(this, MusteriAnaSayfa.class));
                        Intent sayfayaGit = new Intent(this,MusteriAnaSayfa.class);
                        sayfayaGit.putExtra("girilenKullaniciAdi",girilenKullaniciAdiA);
                        sayfayaGit.putExtra("girilenSifre",girilenSifreA);
                        sayfayaGit.putExtra("girilenIsim",girilenIsim);
                        sayfayaGit.putExtra("girilenSoyisim",girilenSoyisim);
                        sayfayaGit.putExtra("girilenCinsiyet",girilenCinsiyet);
                        startActivity(sayfayaGit);
                    }

                }else{
                    toast("Kullanıcı Bulunamadı");
                }

            }






        }catch (Exception e){
            toast("Bir Hata Oluştuasdasdsad!!!");
        }





    }
    public void kayitEkraniGit(View view){
        startActivity(new Intent(this, MusteriKayitOl.class));
    }

    //==========GERİ GİT VE TOAST=================
    public void geriGit(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
    public void toast(String mySt){
        Toast.makeText(this, mySt, Toast.LENGTH_SHORT).show();
    }
    //==========GERİ GİT VE TOAST=================
}