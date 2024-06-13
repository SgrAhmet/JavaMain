package com.ahmetayds.eokul;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.eokul.databinding.ActivityDetailPageBinding;

import java.util.Random;


public class DetailPage extends AppCompatActivity {

    private ActivityDetailPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail_page);

        binding = ActivityDetailPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent gelenVeri = getIntent();
        String isim =gelenVeri.getStringExtra("ogrenciAdi");
        String kursAdi =gelenVeri.getStringExtra("kursAdi");
        String egitmenAdi =gelenVeri.getStringExtra("egitmenAdi");
        int gorselResId = gelenVeri.getIntExtra("gorsel", 0);





        binding.textView.setText(isim);
        binding.textView2.setText(kursAdi);
        binding.textView3.setText(egitmenAdi);
        if (gorselResId != 0) {
            binding.imageView.setImageResource(gorselResId);
        }



    }

    public void geriGit(View view){
        Intent geriGitme = new Intent(this,MainActivity.class);
        startActivity(geriGitme);
    }


    public void deneme(View view){
        Random myRandom = new Random();
        int rand1 = myRandom.nextInt(500);
        int rand2 = myRandom.nextInt(500);
        binding.buttonDeneme.setX(rand1);
        binding.buttonDeneme.setY(rand2);
    }
}