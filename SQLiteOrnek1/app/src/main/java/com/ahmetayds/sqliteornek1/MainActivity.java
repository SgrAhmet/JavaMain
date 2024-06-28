package com.ahmetayds.sqliteornek1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.sqliteornek1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar (id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50),sifre VARCHAR(50))");

            Cursor cursor =veriTabani.rawQuery("SELECT * FROM kullanicilar",null);

            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
            int sifreler = cursor.getColumnIndex("sifre");



            while(cursor.moveToNext()){
                String kullanıciAdi = cursor.getString(kullanıciAdlari);
                String sifre = cursor.getString(sifreler);

                System.out.println("===============================");
                System.out.println("kullanici Adi : " + kullanıciAdi);
                System.out.println("sifre  : " + sifre);
                System.out.println("===============================");

            }

        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
        };




    }



    public void girisYap(View view){

        String girilenKullaniciAdi = binding.kullaniciAdiText.getText().toString();
        String girilenSifre = binding.sifreText.getText().toString();



        if(girilenKullaniciAdi.isEmpty() || girilenSifre.isEmpty()){
            Toast.makeText(this, "Kullanıcı Adı ve Şifre Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
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

                    Intent sayfayaGit = new Intent(this, ProfilSayfasi.class);
                    startActivity(sayfayaGit);
                }else{
                        Toast.makeText(this, "Kullanıcı Adı veya Şifre Yanlış", Toast.LENGTH_SHORT).show();
                    }

            }catch (Exception e){
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }
        }




    }

    public void kayitOl(View view){
        String yeniKullanıciAdi = binding.kullaniciAdi2Text.getText().toString();
        String yeniSifre = binding.sifre2Text.getText().toString();
        if(yeniKullanıciAdi.isEmpty() || yeniSifre.isEmpty()){
            Toast.makeText(this, "Kullanıcı Adı ve Şifre Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
        }else{
            try {
                SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
                veriTabani.execSQL("INSERT INTO kullanicilar (kullaniciAdi,sifre)VALUES('" + yeniKullanıciAdi+"','"+yeniSifre+"')");
                Toast.makeText(this, "Kullanıcı Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();

                binding.kullaniciAdi2Text.setText("");
                binding.sifre2Text.setText("");
            }catch (Exception e){
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }

        }







    }

}