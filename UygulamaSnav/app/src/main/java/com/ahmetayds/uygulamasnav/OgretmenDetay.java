package com.ahmetayds.uygulamasnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.ahmetayds.uygulamasnav.databinding.ActivityOgretmenDetayBinding;
import com.ahmetayds.uygulamasnav.databinding.ActivityOgretmenGirisiBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OgretmenDetay extends AppCompatActivity {

    private ActivityOgretmenDetayBinding binding;

    String[] isimler;
    String[] sifreler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ogretmen_detay);

        binding = ActivityOgretmenDetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        isimler = getIntent().getStringArrayExtra("isimler");
       sifreler = getIntent().getStringArrayExtra("sifreler");

        ArrayList<String> newIsimler = new ArrayList<>();

        for (int i = 0;i < isimler.length;i++){
            newIsimler.add(isimler[i]);
        }


//        SharedPreferences veriGetir =this.getPreferences(Context.MODE_PRIVATE);
//        int gelenVeri = veriGetir.getInt("yusufaydos",3);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, isimler);


        binding.myListView.setAdapter(adapter);



        binding.myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Intent ekstraSayfasınaGit = new Intent(MainActivity.this,DetailPage.class);
                Intent ekstraSayfasınaGit = new Intent(OgretmenDetay.this, OgretmenEkstra.class);
                ekstraSayfasınaGit.putExtra("isim",newIsimler.get(position));
                startActivity(ekstraSayfasınaGit);
            }
        });


    }
}