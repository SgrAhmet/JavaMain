package com.ahmetayds.guessthecity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ahmetayds.guessthecity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }


    public void goToNormalOyun(View view){

        Intent goToNormalOyun = new Intent(this, normalOyun.class);
        startActivity(goToNormalOyun);
    }

    public void goToSureliOyun(View view){
        Intent goToSureliOyun = new Intent(this, sureliOyun.class);
        startActivity(goToSureliOyun);
    }


}