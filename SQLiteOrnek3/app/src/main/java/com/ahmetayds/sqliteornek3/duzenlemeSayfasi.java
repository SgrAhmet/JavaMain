package com.ahmetayds.sqliteornek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.sqliteornek3.databinding.ActivityDuzenlemeSayfasiBinding;

public class duzenlemeSayfasi extends AppCompatActivity {

    private ActivityDuzenlemeSayfasiBinding binding;

    String girilenKullaniciAdi;
    String girilenSifre ;
    String girilenIsim ;
    String girilenSoyisim ;
    String girilenEmail ;
    String girilenTelefon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_duzenleme_sayfasi);

        binding = ActivityDuzenlemeSayfasiBinding.inflate(getLayoutInflater());
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


        binding.editTextText2.setText(girilenIsim);
        binding.editTextText3.setText(girilenSoyisim);
        binding.editTextText4.setText(girilenKullaniciAdi);
        binding.editTextTextPassword.setText(girilenSifre);
        binding.editTextTextEmailAddress.setText(girilenEmail);
        binding.editTextPhone.setText(girilenTelefon);


    }





    public void güncelle (View view){

        String yeniIsim = binding.editTextText2.getText().toString();
        String yeniSoyisim = binding.editTextText3.getText().toString();
        String yeniKullaniciAdi = binding.editTextText4.getText().toString();
        String yeniSifre = binding.editTextTextPassword.getText().toString();
        String yeniEmail = binding.editTextTextEmailAddress.getText().toString();
        String yeniTelefon = binding.editTextPhone.getText().toString();


        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);

            veriTabani.execSQL("UPDATE kullanicilar SET sifre = '" + yeniSifre + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE kullanicilar SET isim = '" + yeniIsim + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE kullanicilar SET kullaniciAdi = '" + yeniKullaniciAdi + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE kullanicilar SET soyisim = '" + yeniSoyisim + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE kullanicilar SET email = '" + yeniEmail + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");
            veriTabani.execSQL("UPDATE kullanicilar SET telefon = '" + yeniTelefon + "' WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");

            girilenKullaniciAdi = yeniKullaniciAdi;

            Toast.makeText(this, "Kullanıcı Bilgileri Güncellendi", Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
        }




    }
    public void geriGitProfil (View view){
        Intent sayfayaGit = new Intent(this, profilSayfasi.class);
        sayfayaGit.putExtra("girilenKullaniciAdi",girilenKullaniciAdi);
        startActivity(sayfayaGit);
    }
}