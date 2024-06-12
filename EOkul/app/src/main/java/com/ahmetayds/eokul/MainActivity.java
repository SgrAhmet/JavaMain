package com.ahmetayds.eokul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.ahmetayds.eokul.databinding.ActivityDetailPageBinding;
import com.ahmetayds.eokul.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;




    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        DetailData ogrenci1 = new DetailData("Erbay","Android Studio","Özlem Aytekin", R.drawable.ogrenci1);
        DetailData ogrenci2 = new DetailData("Ömer","Android Studio","Özlem Aytekin",R.drawable.ogrenci2);
        DetailData ogrenci3 = new DetailData("Berkan","Android Studio","Özlem Aytekin",R.drawable.ogrenci3);
        DetailData ogrenci4 = new DetailData("Şiir","Android Studio","Özlem Aytekin",R.drawable.ogrenci4);

        ArrayList<DetailData> detailDataArray = new ArrayList<>();

        detailDataArray.add(ogrenci1);
        detailDataArray.add(ogrenci2);
        detailDataArray.add(ogrenci3);
        detailDataArray.add(ogrenci4);







    }

    public void goToDetail(View view){
        Intent detailSayfasınaGit = new Intent(this,DetailPage.class);
        startActivity(detailSayfasınaGit);
    }





}