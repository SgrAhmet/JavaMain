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




    public void deneme(View view){

        new CountDownTimer(500,100){

                int cart = 2;

            @Override
            public void onTick(long milisUntilFinshed){
                System.out.println("sayaç çalıştı");

                if(cart == 1){
                    binding.imageView4.setScaleX(2);
                    binding.imageView4.setScaleY(2);
                    cart = 2;
                }else{
                    binding.imageView4.setScaleX(1);
                    binding.imageView4.setScaleY(1);
                    cart = 1;

                }



            }
            @Override
            public void onFinish(){
                System.out.println("sayaç Bitti XXXXX");
                binding.imageView4.setScaleX(1);
                binding.imageView4.setScaleY(1);


            }
        }.start();

    }

}