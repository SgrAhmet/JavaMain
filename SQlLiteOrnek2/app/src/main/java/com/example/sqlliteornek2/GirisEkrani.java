package com.example.sqlliteornek2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GirisEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_giris_ekrani);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }


    public void GeriGit(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void kayitSayfasiGit(View view){
        Intent sayfayaGit = new Intent(this, KayitEkrani.class);
        startActivity(sayfayaGit);
    }
}