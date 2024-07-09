package com.ahmetayds.hastaneuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityGecmisRandevularBinding;

public class gecmisRandevular extends AppCompatActivity {
    ActivityGecmisRandevularBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gecmis_randevular);

        binding = ActivityGecmisRandevularBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }


    public void gecmisRandevularGeriGit(View view){
        startActivity(new Intent(this, hastaAnaSayfa.class));
    }
}