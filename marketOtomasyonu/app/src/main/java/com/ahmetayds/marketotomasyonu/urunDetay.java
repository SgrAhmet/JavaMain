package com.ahmetayds.marketotomasyonu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.marketotomasyonu.databinding.ActivityUrunDetayBinding;

public class urunDetay extends AppCompatActivity {

    public ActivityUrunDetayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_urun_detay);

        binding = ActivityUrunDetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void geriGit(View view){
        startActivity(new Intent(this, urunler.class));
    }
}