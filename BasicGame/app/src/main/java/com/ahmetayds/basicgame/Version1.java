package com.ahmetayds.basicgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Handler;
import android.widget.Toast;

import java.util.Random;


public class Version1 extends AppCompatActivity {

    TextView EnYuksekSkorTextView;

    TextView  KalanSureTextView;
    TextView SkorTextView;

    int skor;

    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;

    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version1);

        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);

        EnYuksekSkorTextView = findViewById(R.id.EnYuksekSkor);
        KalanSureTextView = findViewById(R.id.KalanSure);
        SkorTextView = findViewById(R.id.Skor);

        imageArray = new ImageView[]{imageView0,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};


        gorselGizle();


        SharedPreferences skorTut = Version1.this.getPreferences(Context.MODE_PRIVATE);
        int enYuksekSkor = skorTut.getInt("yuksekSkor",0);
        EnYuksekSkorTextView.setText("En Yüksek Skor : " + enYuksekSkor );

        new CountDownTimer(1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                KalanSureTextView.setText("Kalan Süre : " + millisUntilFinished/1000 );
            }

            @Override
            public void onFinish()
            {
                KalanSureTextView.setText("Süre Bitti");
                handler.removeCallbacks(runnable);
                for(ImageView resim : imageArray){
                    resim.setVisibility(View.INVISIBLE);
                }

                SharedPreferences skorTut = Version1.this.getPreferences(Context.MODE_PRIVATE);
                int enYuksekSkor = skorTut.getInt("yuksekSkor",0);
                if(skor >enYuksekSkor ){
                    SharedPreferences.Editor editor = skorTut.edit();
                    editor.putInt("yuksekSkor",skor);
                    editor.apply();



                    enYuksekSkor = skorTut.getInt("yuksekSkor",0);
                    EnYuksekSkorTextView.setText("En Yüksek Skor : " + enYuksekSkor );

                }

                AlertDialog.Builder mesaj = new AlertDialog.Builder(Version1.this);
                mesaj.setTitle("Yeniden Başla");
                mesaj.setMessage("Tekrar Oynamak İster Misin?");

                mesaj.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent bastanBasla = getIntent();
                        finish();
                        startActivity(bastanBasla);
                    }
                });

                mesaj.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Version1.this, "Oyun Bitti", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                mesaj.show();
            }
        }.start();

    }










//=========================Görsel Gizle =========================
    public void gorselGizle(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(runnable,500);

                for (ImageView resim : imageArray){
                    resim.setVisibility(View.INVISIBLE);
                }
                Random rastgele = new Random();
                int i = rastgele.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
            }
        };

        handler.post(runnable);
    }
//=========================Skor Arttır =========================
    public void skoruArttir(View view){
        skor++;
        SkorTextView.setText("Skor : " + skor);
    }
//=========================GERİ GİT =========================
    public void geriGit(View view){
        Intent geri = new Intent(this, MainActivity.class);
        startActivity(geri);
    }
}