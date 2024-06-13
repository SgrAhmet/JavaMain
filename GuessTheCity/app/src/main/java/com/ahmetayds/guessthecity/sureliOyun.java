package com.ahmetayds.guessthecity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.guessthecity.databinding.ActivityNormalOyunBinding;
import com.ahmetayds.guessthecity.databinding.ActivitySureliOyunBinding;


public class sureliOyun extends AppCompatActivity {

    private ActivitySureliOyunBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sureli_oyun);

        binding = ActivitySureliOyunBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }


    public void goToMainPage(View view){
        Intent goToMainPage = new Intent(this, MainActivity.class);
        startActivity(goToMainPage);
    }
}