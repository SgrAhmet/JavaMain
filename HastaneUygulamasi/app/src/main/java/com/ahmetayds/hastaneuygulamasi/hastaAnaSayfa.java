package com.ahmetayds.hastaneuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityHastaAnaSayfaBinding;

import java.util.Date;

public class hastaAnaSayfa extends AppCompatActivity {

    private ActivityHastaAnaSayfaBinding binding;
    String[] doktorlar ;

    Boolean isWorking = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hasta_ana_sayfa);

        binding = ActivityHastaAnaSayfaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        doktorlar =  getIntent().getStringArrayExtra("doktorlar");


    }



    public void randevuAl(View view){

        Intent sayfayaGit = new Intent(this,randevuAl.class);
        sayfayaGit.putExtra("doktorlar",doktorlar);
        startActivity(sayfayaGit);
//        startActivity(new Intent(this, randevuAl.class));



    }

    public void gecmisRandevu(View view){
        startActivity(new Intent(this, gecmisRandevular.class));



    }

    public void cikis(View view){
        startActivity(new Intent(this, MainActivity.class));
    }




    public void imageRotation(View view){

        if(!isWorking){
            isWorking = true;
            new CountDownTimer(1300,10){
                int degree = 0;
                @Override
                public void onTick(long milisUntilFinshed){

                    binding.imageView4.setRotationY(degree);
                    degree = degree + 10;

                }
                @Override
                public void onFinish(){
                    binding.imageView4.setRotationY(0);
                    isWorking = false;
                }
            }.start();
        }




    }

}