package com.ahmetayds.hastaneuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityHastaAnaSayfaBinding;

public class hastaAnaSayfa extends AppCompatActivity {

    private ActivityHastaAnaSayfaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hasta_ana_sayfa);

        binding = ActivityHastaAnaSayfaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }



    public void randevuAl(View view){
        startActivity(new Intent(this, randevuAl.class));

    }

    public void gecmisRandevu(View view){
        startActivity(new Intent(this, gecmisRandevular.class));

    }

    public void cikis(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}