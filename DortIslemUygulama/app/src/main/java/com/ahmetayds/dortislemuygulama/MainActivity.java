package com.ahmetayds.dortislemuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ToplamaGecis(View view){
        Intent ToplamaSayfası = new Intent(this,ToplamaSayfasi.class);
        startActivity(ToplamaSayfası);
    }

    public void CikarmaGecis(View view){
        Intent CikarmaSayfasi = new Intent(this,CikarmaSayfasi.class);
        startActivity(CikarmaSayfasi);
    }

    public void CarpmaGecis(View view){
        Intent CarpmaSayfasi = new Intent(this,CarpmaSayfasi.class);
        startActivity(CarpmaSayfasi);
    }

    public void BolmeGecis(View view){
        Intent BolmeSayfasi = new Intent(this,BolmeSayfasi.class);
        startActivity(BolmeSayfasi);
    }

    public void deneme(View view){
        System.out.println("buton çalıştı");
    }

}