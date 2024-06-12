package com.ahmetayds.eokul;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.eokul.databinding.ActivityDetailPageBinding;


public class DetailPage extends AppCompatActivity {

    private ActivityDetailPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail_page);

        binding = ActivityDetailPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);






    }
}