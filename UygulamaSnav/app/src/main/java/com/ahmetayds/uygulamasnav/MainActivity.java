package com.ahmetayds.uygulamasnav;

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





    public void ogretmenGirisiGit(View view){
        Intent sayfayaGit = new Intent(this, OgretmenGirisi.class);
        startActivity(sayfayaGit);
    }

    public void ogrenciGirisiGit(View view){
        Intent sayfayaGit = new Intent(this, OgrenciGirisi.class);
        startActivity(sayfayaGit);
    }
}