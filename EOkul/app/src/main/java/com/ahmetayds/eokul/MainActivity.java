package com.ahmetayds.eokul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.ahmetayds.eokul.databinding.ActivityDetailPageBinding;
import com.ahmetayds.eokul.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

        DetailData ogrenci1 = new DetailData("Ömer","Android Studio","Özlem Aytekin", R.drawable.ogrenci1);
        DetailData ogrenci2 = new DetailData("Erbay","Android Studio","Özlem Aytekin",R.drawable.ogrenci2);
        DetailData ogrenci3 = new DetailData("Berkan","Android Studio","Özlem Aytekin",R.drawable.ogrenci3);
        DetailData ogrenci4 = new DetailData("Şiir","Android Studio","Özlem Aytekin",R.drawable.ogrenci4);

        ArrayList<DetailData> detailDataArray = new ArrayList<>();


        detailDataArray.add(ogrenci1);
        detailDataArray.add(ogrenci2);
        detailDataArray.add(ogrenci3);
        detailDataArray.add(ogrenci4);




//
//        ArrayList<String> detailDataArray = new ArrayList<>();
//
//        detailDataArray.add(ogrenci1.isim);
//        detailDataArray.add(ogrenci2.isim);
//        detailDataArray.add(ogrenci3.isim);
//        detailDataArray.add(ogrenci4.isim);

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,detailDataArray);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, detailDataArray.stream().map(DetailData -> DetailData.isim).collect(Collectors.toList()));

        binding.isimlerListesi.setAdapter(arrayAdapter);





        binding.isimlerListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detailSayfasınaGit = new Intent(MainActivity.this,DetailPage.class);
                detailSayfasınaGit.putExtra("ogrenciAdi",detailDataArray.get(position).isim);
                detailSayfasınaGit.putExtra("kursAdi",detailDataArray.get(position).kursAdi);
                detailSayfasınaGit.putExtra("egitmenAdi",detailDataArray.get(position).egitmenAdi);
                detailSayfasınaGit.putExtra("gorsel",detailDataArray.get(position).gorsel);
                startActivity(detailSayfasınaGit);
            }
        });




    }







}