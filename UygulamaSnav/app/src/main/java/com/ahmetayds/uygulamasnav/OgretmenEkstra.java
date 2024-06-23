package com.ahmetayds.uygulamasnav;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ahmetayds.uygulamasnav.databinding.ActivityOgretmenDetayBinding;
import com.ahmetayds.uygulamasnav.databinding.ActivityOgretmenEkstraBinding;

public class OgretmenEkstra extends AppCompatActivity {

    private ActivityOgretmenEkstraBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOgretmenEkstraBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_ogretmen_ekstra);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        String isim =getIntent().getStringExtra("isim");

        SharedPreferences veriGetir = this.getPreferences(Context.MODE_PRIVATE);
        int kalanHak = veriGetir.getInt(isim,3);

        binding.textView4.setText(isim);
        binding.textView8.setText(kalanHak + " ");

    }


    public void geriGit(View view){
        Intent geriSayfayaGit = new Intent(this,OgretmenDetay.class);
        startActivity(geriSayfayaGit);
    }
}