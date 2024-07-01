package com.ahmetayds.marketotomasyonu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.marketotomasyonu.databinding.ActivityUrunlerBinding;

public class urunler extends AppCompatActivity {

    public ActivityUrunlerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_urunler);
        binding = ActivityUrunlerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }


    public void yeniUrun(View view){
        startActivity(new Intent(this, urunDetay.class));
    }
}