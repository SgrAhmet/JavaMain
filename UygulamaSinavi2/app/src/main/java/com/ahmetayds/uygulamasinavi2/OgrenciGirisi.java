package com.ahmetayds.uygulamasinavi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OgrenciGirisi extends AppCompatActivity {

    EditText kullaniciAdiEditText;
    EditText sifreEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_girisi);

        kullaniciAdiEditText = findViewById(R.id.kullaniciAdiEditText);
        sifreEditText = findViewById(R.id.sifreEditText);
    }

    public void girisYap(View view){
        if(kullaniciAdiEditText.getText().toString().isEmpty() || sifreEditText.getText().toString().isEmpty()){
            Toast.makeText(this, "Kullanıcı Adı veya Şifre Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
        }else{
            SharedPreferences giris = this.getSharedPreferences("dosyam", Context.MODE_PRIVATE);
            for(int i= 0 ; i < 20 ; i++){
                String sira = String.valueOf(i);
                String anahtar = "kullaniciAdi" + sira;
                String  anahtar2 = "no" + sira +"KullanılanHak";
                String gelenKullaniciAdi = giris.getString(anahtar,"");
                int gelenHak = giris.getInt(anahtar2,-1);

                System.out.println("i is a : " + i);
                if(gelenKullaniciAdi.matches(kullaniciAdiEditText.getText().toString()) && sifreEditText.getText().toString().matches("12345")){
                        if(gelenHak > 2){
                            Toast.makeText(this, "Kullanıcı Tüm Haklarını Bitirmiştir", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent oyunaGit = new Intent(this, OgrenciOyun.class);
                            startActivity(oyunaGit);
                        }
                }else{
                    Toast.makeText(this, "Kullanıcı Bulunamadı", Toast.LENGTH_SHORT).show();
//                    break;
                }

            }
        }
    }

    public void ogrenciGirisiGeriGit(View view){
        Intent sayfayaGit = new Intent(this, MainActivity.class);
        startActivity(sayfayaGit);
    }
}