package com.example.snavcalsma;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.snavcalsma.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);


//            Toast.makeText(this, "deneme", Toast.LENGTH_SHORT).show();

            Intent intent = getIntent();

            String  gelenVeri = intent.getStringExtra("gönderilenİsim");








           new CountDownTimer(1000,100){
                @Override
                public void onTick(long milisUntilFinshed){

                }
                @Override
                public void onFinish(){

                }
            }.start();




            handler = new Handler();

            runnable = new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(runnable,10);
                    

                }
            };
            handler.post(runnable);

            
        });

    }

    public void abc() {
        Intent sayfayaGit = new Intent(this,deneme.class);
        sayfayaGit.putExtra("gönderilenİsim",gönderilecekNesne);
        startActivity(sayfayaGit);
    }

}