package com.ahmetayds.uygulamasnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


import com.ahmetayds.uygulamasnav.databinding.ActivityOgrenciOyunBinding;

public class OgrenciOyun extends AppCompatActivity {

    String[] iller = {
            "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum",
            "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin",
            "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli",
            "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş",
            "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas",
            "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak",
            "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan",
            "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"
    };

    String[] plakalar = {
            "01", "02", "03", "04", "05", "06", "07", "08",
            "09", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30", "31", "32",
            "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45", "46", "47", "48",
            "49", "50", "51", "52", "53", "54", "55", "56",
            "57", "58", "59", "60", "61", "62", "63", "64",
            "65", "66", "67", "68", "69", "70", "71", "72",
            "73", "74", "75", "76", "77", "78", "79", "80",
            "81"
    };

    Random myRandom = new Random();

    private ActivityOgrenciOyunBinding binding;

    Runnable runnable;
    Handler handler;
    int time = 60;

    String randomSehir;
    String randomPlaka;
    int puan = 0;
    String oynayanOgrenci ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ogrenci_oyun);



        binding = ActivityOgrenciOyunBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.sayacTextView.setVisibility(View.INVISIBLE);
        binding.kalanHakTextView.setVisibility(View.VISIBLE);
        binding.sehirTextView.setVisibility(View.INVISIBLE);
        binding.plakaTahminEditText.setVisibility(View.INVISIBLE);
        binding.PuanTextView.setVisibility(View.INVISIBLE);
        binding.tahminButton.setVisibility(View.INVISIBLE);

        binding.PuanTextView.setText("Puan : "+ puan);



         oynayanOgrenci = getIntent().getStringExtra("ogrenciIsmi");



//=======================================================================
        SharedPreferences veriGetir =this.getPreferences(Context.MODE_PRIVATE);
        int gelenVeri = veriGetir.getInt(oynayanOgrenci,3);
        binding.kalanHakTextView.setText("Kalan Hak : " +gelenVeri);
//=======================================================================



    }


    public void tahminYap(View view){

        if(binding.plakaTahminEditText.getText().toString().matches(randomPlaka)){
            puan++;
            binding.PuanTextView.setText("Puan : "+ puan);
            binding.plakaTahminEditText.setText("");
        }else{
            puan--;
            binding.PuanTextView.setText("Puan : "+ puan);
            binding.plakaTahminEditText.setText("");
        }


        yeniSehir();

        System.out.println(randomSehir);
        System.out.println("----");
        System.out.println(randomPlaka);
    }

    public void yeniSehir(){
        int myRandomInt = myRandom.nextInt(iller.length);
        randomSehir = iller[myRandomInt];
        randomPlaka = plakalar[myRandomInt];


        binding.sehirTextView.setText(randomSehir + "  " + randomPlaka);
    }



    public void oyunuBaslatma(View view){

        SharedPreferences veriGetir =this.getPreferences(Context.MODE_PRIVATE);
        int gelenVeri = veriGetir.getInt(oynayanOgrenci,3);
        binding.kalanHakTextView.setText("Kalan Hak : " +gelenVeri);

        if(gelenVeri == 0){
            Intent  sayfayaGit = new Intent(this, MainActivity.class);
            startActivity(sayfayaGit);

            Toast.makeText(this, "Hakkınız Kalmamıştır", Toast.LENGTH_SHORT).show();
        }else {
            //======================================================================
            binding.oyunBaslatButton.setVisibility(View.INVISIBLE);

            binding.sayacTextView.setVisibility(View.VISIBLE);
            binding.kalanHakTextView.setVisibility(View.VISIBLE);
            binding.sehirTextView.setVisibility(View.VISIBLE);
            binding.plakaTahminEditText.setVisibility(View.VISIBLE);
            binding.PuanTextView.setVisibility(View.VISIBLE);
            binding.tahminButton.setVisibility(View.VISIBLE);
//=======================================================================

            time = 60;

            handler = new Handler();

            runnable = new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(runnable,1000);
                    binding.sayacTextView.setText("0:" + time);
                    if(time == -1){
                        oyunuBitir();
                    }
                    time--;
                }
            };
            handler.post(runnable);
            yeniSehir();
        }





    }

    public void oyunuBitir(){
//=======================================================================
        binding.oyunBaslatButton.setVisibility(View.VISIBLE);

        binding.sayacTextView.setVisibility(View.VISIBLE);
        binding.kalanHakTextView.setVisibility(View.INVISIBLE);
        binding.sehirTextView.setVisibility(View.INVISIBLE);
        binding.plakaTahminEditText.setVisibility(View.INVISIBLE);
        binding.PuanTextView.setVisibility(View.VISIBLE);
        binding.tahminButton.setVisibility(View.INVISIBLE);
//=======================================================================
        handler.removeCallbacks(runnable);
        binding.sayacTextView.setText("Süre Bitti!");
        puan = 0;
//=======================================================================

        SharedPreferences veriGetir =this.getPreferences(Context.MODE_PRIVATE);
        int gelenVeri = veriGetir.getInt(oynayanOgrenci,3);


        SharedPreferences veriKaydet =this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =veriKaydet.edit();
        editor.putInt(oynayanOgrenci,(gelenVeri - 1));
        editor.apply();


    }
    public void cıkısYapma(View view){
        handler.removeCallbacks(runnable);
        Intent  sayfayaGit = new Intent(this, MainActivity.class);
        startActivity(sayfayaGit);

    }
}