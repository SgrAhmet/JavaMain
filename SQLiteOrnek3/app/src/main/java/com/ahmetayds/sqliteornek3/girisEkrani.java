package com.ahmetayds.sqliteornek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.sqliteornek3.databinding.ActivityGirisEkraniBinding;
import com.ahmetayds.sqliteornek3.databinding.ActivityKayitEkraniBinding;

public class girisEkrani extends AppCompatActivity {

    private ActivityGirisEkraniBinding binding;

    String adminKullaniciAdi = "admin";
    String  adminSifre = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_giris_ekrani);

        binding = ActivityGirisEkraniBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }




    public void girisKontrol(View view){


        String girilenKullaniciAdi = binding.editTextText.getText().toString();
        String girilenSifre = binding.editTextTextPassword2.getText().toString();

        if(girilenKullaniciAdi.isEmpty() || girilenSifre.isEmpty()){
            Toast.makeText(this, "Kullanıcı Adı veya Şifre Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
        }else {

            if(girilenKullaniciAdi.equals(adminKullaniciAdi) && girilenSifre.equals(adminSifre)){
                startActivity(new Intent(this, adminSayfasi.class));
                Toast.makeText(this, "Admin Giriş Yaptı", Toast.LENGTH_SHORT).show();
            }else{
                try {
                    SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
                    Cursor cursor =veriTabani.rawQuery("SELECT * FROM kullanicilar",null);
                    int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
                    int sifreler = cursor.getColumnIndex("sifre");

                    Boolean isLogin = false;

                    while(cursor.moveToNext()){
                        String kullanıciAdi = cursor.getString(kullanıciAdlari);
                        String sifre = cursor.getString(sifreler);

                        if(kullanıciAdi.toString().equalsIgnoreCase(girilenKullaniciAdi) && sifre.toString().equalsIgnoreCase(girilenSifre)){
                            isLogin = true;
                            break;
                        }
                    }

                    if(isLogin){
                        Toast.makeText(this, "Giriş Başarıyla Yapıldı", Toast.LENGTH_SHORT).show();
                        profilSayfasiGit(girilenKullaniciAdi,girilenSifre);
                    }else{
                        Toast.makeText(this, "Kullanıcı Adı veya Şifre Yanlış", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(this, "Bir Hata Oluştı!", Toast.LENGTH_SHORT).show();
                }
            }







        }



    }
    public void geriGit (View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void kayitEkraniGit (View view){
        startActivity(new Intent(this, kayitEkrani.class));
    }

    public void profilSayfasiGit(String girilenKullaniciAdi,String girilenSifre){
        Intent sayfayaGit = new Intent(this, profilSayfasi.class);
        sayfayaGit.putExtra("girilenKullaniciAdi",girilenKullaniciAdi);
        sayfayaGit.putExtra("girilenSifre",girilenSifre);
        startActivity(sayfayaGit);

    }
}