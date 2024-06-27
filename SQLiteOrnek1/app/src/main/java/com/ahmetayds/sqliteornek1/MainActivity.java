package com.ahmetayds.sqliteornek1;

import androidx.appcompat.app.AppCompatActivity;

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

        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
        };



        String deneme = "def";

        String deneme2 ="abc"+ ""+deneme+"";

        System.out.println(deneme2);   // abcdef



    }



    public void girisYap(View view){



    }

    public void kayitOl(View view){
        String yeniKullanıciAdi = binding.kullaniciAdi2Text.getText().toString();
        String yeniSifre = binding.kullaniciAdi2Text.getText().toString();
        if(yeniKullanıciAdi.isEmpty() || yeniSifre.isEmpty()){
            Toast.makeText(this, "Kullanıcı Adı ve Şifre Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
        }else{


            try {
                SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);

                veriTabani.execSQL("INSERT INTO kullanicilar (kullaniciAdi,sifre)VALUES('" + yeniKullanıciAdi+"','"+yeniSifre+"')");


                Toast.makeText(this, "Kullanıcı Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();

            }catch (Exception e){
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }

        }







    }

}