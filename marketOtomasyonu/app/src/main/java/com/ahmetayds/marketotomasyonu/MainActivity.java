package com.ahmetayds.marketotomasyonu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.marketotomasyonu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("market_db",MODE_PRIVATE,null);
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY AUTOINCREMENT ,urunAdi VARCHAR(50), urunFiyati VARCHAR(50), stokAdedi INTEGER,gorsel BLOB)");
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar (id INTEGER PRIMARY KEY AUTOINCREMENT ,kullaniciAdi VARCHAR(50), sifre VARCHAR(50))");

            Cursor imlec = veriTabani.rawQuery("SELECT * FROM kullanicilar" , null);
            int kullaniciAdiX = imlec.getColumnIndex("kullaniciAdi");
            boolean check = false;
            while (imlec.moveToNext()){
                if (imlec.getString(kullaniciAdiX).matches("admin") || imlec.getString(kullaniciAdiX).matches("admin2")){
                    check = true;
                    break;
                }
            }
            if (!check) {
                adminKaydet();
            }
        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!!", Toast.LENGTH_SHORT).show();
        }
    }







    public void girisYap(View view){
        String girilenKullaniciAdi = binding.kullaniciAdiText.getText().toString();
        String girilenSifre = binding.sifreText.getText().toString();

        if(girilenKullaniciAdi.equals("") || girilenSifre.equals("")){
            Toast.makeText(this, "Kullanıcı Adı veya Şifre Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
        }else{

            try {

                SQLiteDatabase veriTabani = this.openOrCreateDatabase("market_db",MODE_PRIVATE,null);
                Cursor imlec = veriTabani.rawQuery("SELECT * FROM kullanicilar",null);
                int kullaniciAdiX = imlec.getColumnIndex("kullaniciAdi");
                int sifreX = imlec.getColumnIndex("sifre");
                boolean isMember = false;

                while (imlec.moveToNext()){
                    if(girilenKullaniciAdi.equalsIgnoreCase(imlec.getString(kullaniciAdiX)) && girilenSifre.equalsIgnoreCase(imlec.getString(sifreX))){
                        isMember = true;
                        break;
                    }
                }

                if(isMember){
                    startActivity(new Intent(this, urunler.class));
                }else{
                    Toast.makeText(this, "Kullanıcı Adı veya Şifre Yanlış", Toast.LENGTH_SHORT).show();
                }



            }catch (Exception e){
                Toast.makeText(this, "Bir Hata Oluştu!!", Toast.LENGTH_SHORT).show();
            }



        }


    }


    public void adminKaydet(){
        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("market_db",MODE_PRIVATE,null);
            veriTabani.execSQL("INSERT INTO  kullanicilar (kullaniciAdi , sifre) VALUES ('admin','123456')");
            veriTabani.execSQL("INSERT INTO  kullanicilar (kullaniciAdi , sifre) VALUES ('admin2','123456')");
        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!! asdasdas", Toast.LENGTH_SHORT).show();
        }
    }

}