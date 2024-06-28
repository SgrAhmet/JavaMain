package com.ahmetayds.sqliteornek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.sqliteornek3.databinding.ActivityProfilSayfasiBinding;

public class profilSayfasi extends AppCompatActivity {

    private ActivityProfilSayfasiBinding binding;

    String girilenKullaniciAdi;
    String girilenSifre ;
    String girilenIsim ;
    String girilenSoyisim ;
    String girilenEmail ;
    String girilenTelefon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profil_sayfasi);

        binding = ActivityProfilSayfasiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


         girilenKullaniciAdi = getIntent().getStringExtra("girilenKullaniciAdi");





        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
            Cursor cursor =veriTabani.rawQuery("SELECT * FROM kullanicilar",null);

            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
            int sifreler = cursor.getColumnIndex("sifre");
            int isimler = cursor.getColumnIndex("isim");
            int soyisimker = cursor.getColumnIndex("soyisim");
            int emailler = cursor.getColumnIndex("email");
            int telefonlar = cursor.getColumnIndex("telefon");



            while(cursor.moveToNext()){
                String kullanıciAdi = cursor.getString(kullanıciAdlari);
                String sifre = cursor.getString(sifreler);
                String isim = cursor.getString(isimler);
                String soyisim = cursor.getString(soyisimker);
                String email = cursor.getString(emailler);
                String telefon = cursor.getString(telefonlar);


                System.out.println(kullanıciAdi);



                if(girilenKullaniciAdi.matches(kullanıciAdi)){


                    System.out.println("worked");

                    girilenSifre = sifre;
                     girilenIsim = isim ;
                     girilenSoyisim = soyisim;
                     girilenEmail = email;
                     girilenTelefon = telefon;
                }

            }
        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
        }


        binding.textView3.setText(girilenIsim);
        binding.textView4.setText(girilenSoyisim);
        binding.textView5.setText(girilenKullaniciAdi);
        binding.textView6.setText(girilenSifre);
        binding.textView7.setText(girilenEmail);
        binding.textView8.setText(girilenTelefon);


    }


    public void geriGit (View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void düzenlemeSayfasiGit(View view){
        Intent sayfayaGit = new Intent(this, duzenlemeSayfasi.class);
        sayfayaGit.putExtra("girilenKullaniciAdi",girilenKullaniciAdi);
        startActivity(sayfayaGit);
    }
}