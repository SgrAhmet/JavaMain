//package com.ahmetayds.uygulamasnav;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//
//import com.ahmetayds.uygulamasnav.databinding.ActivityOgrenciGirisiBinding;
//
//import java.util.ArrayList;
//
//public class OgrenciGirisi extends AppCompatActivity {
//
//    private ActivityOgrenciGirisiBinding binding;
//
//    ArrayList<OgrenciData> ogrenciDataArray = new ArrayList<>();
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_ogrenci_girisi);
//
//        binding = ActivityOgrenciGirisiBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
//
//
////        OgrenciData ogrenci1 = new OgrenciData("ahmetaydos","12345");
////        OgrenciData ogrenci2 = new OgrenciData("yusufaydos","12345");
////        OgrenciData ogrenci3 = new OgrenciData("furkanaydos","12345");
////        OgrenciData ogrenci4 = new OgrenciData("zeynepaydos","12345");
////
////        ogrenciDataArray.add(ogrenci1);
////        ogrenciDataArray.add(ogrenci2);
////        ogrenciDataArray.add(ogrenci3);
////        ogrenciDataArray.add(ogrenci4);
//
//
//
//        ArrayList<OgrenciData>  ogrenciDataArray = getIntent().getParcelableArrayListExtra("ogrenciDataArray");
//
//
//
//
//
//    }
//
//
//
//
//
//
//    public void OgrenciOyunGit(View view){
//
//        if(binding.kullanCAdiEditText.getText().toString().matches("")||binding.sifreEditText.getText().toString().matches("")){
//            Toast.makeText(this, "Lütfen Kullanıcı Adı ve Şifrenizi Giriniz", Toast.LENGTH_SHORT).show();
//        }else{
//            boolean loginChecked = false;
//
//            for (int i = 0;i< ogrenciDataArray.size();i++ ){
//                if(binding.kullanCAdiEditText.getText().toString().matches(ogrenciDataArray.get(i).kullanıcıAdi.toString()) && binding.sifreEditText.getText().toString().matches(ogrenciDataArray.get(i).sifre.toString())){
//                    Intent sayfayaGit = new Intent(this, OgrenciOyun.class);
//                    sayfayaGit.putExtra("ogrenciIsmi" , ogrenciDataArray.get(i).kullanıcıAdi);
//                    startActivity(sayfayaGit);
//                    loginChecked = true;
//                }
//            }
//            if(!loginChecked){
//                Toast.makeText(this, "Kullanıcı Adı veya Şifre Yanlış", Toast.LENGTH_SHORT).show();
//            }
//
//
//
//        }
//
//    }
//
//    public void geriGitme(View view){
//        Intent sayfayaGit = new Intent(this, MainActivity.class);
//        startActivity(sayfayaGit);
//    }
//}

package com.ahmetayds.uygulamasnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.uygulamasnav.databinding.ActivityOgrenciGirisiBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class OgrenciGirisi extends AppCompatActivity {

    private ActivityOgrenciGirisiBinding binding;

    ArrayList<OgrenciData> ogrenciDataArray = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ogrenci_girisi);

        binding = ActivityOgrenciGirisiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        String[] isimler = getIntent().getStringArrayExtra("isimler");
        String[] sifreler = getIntent().getStringArrayExtra("sifreler");



//        OgrenciData ogrenci1 = new OgrenciData("ahmetaydos","12345");
//        OgrenciData ogrenci2 = new OgrenciData("yusufaydos","12345");
//        OgrenciData ogrenci3 = new OgrenciData("furkanaydos","12345");
//        OgrenciData ogrenci4 = new OgrenciData("zeynepaydos","12345");
//
//        ogrenciDataArray.add(ogrenci1);
//        ogrenciDataArray.add(ogrenci2);
//        ogrenciDataArray.add(ogrenci3);
//        ogrenciDataArray.add(ogrenci4);



        for (int i = 0; i < isimler.length; i++) {
            OgrenciData ogrenci = new OgrenciData(isimler[i], sifreler[i]);
            ogrenciDataArray.add(ogrenci);
        }





    }






    public void OgrenciOyunGit(View view){

        if(binding.kullanCAdiEditText.getText().toString().matches("")||binding.sifreEditText.getText().toString().matches("")){
            Toast.makeText(this, "Lütfen Kullanıcı Adı ve Şifrenizi Giriniz", Toast.LENGTH_SHORT).show();
        }else{
            boolean loginChecked = false;

            for (int i = 0;i< ogrenciDataArray.size();i++ ){
                if(binding.kullanCAdiEditText.getText().toString().matches(ogrenciDataArray.get(i).kullanıcıAdi.toString()) && binding.sifreEditText.getText().toString().matches(ogrenciDataArray.get(i).sifre.toString())){
                    Intent sayfayaGit = new Intent(this, OgrenciOyun.class);
                    sayfayaGit.putExtra("ogrenciIsmi" , ogrenciDataArray.get(i).kullanıcıAdi);
                    startActivity(sayfayaGit);
                    loginChecked = true;
                }
            }
            if(!loginChecked){
                Toast.makeText(this, "Kullanıcı Adı veya Şifre Yanlış", Toast.LENGTH_SHORT).show();
            }



        }

    }

    public void geriGitme(View view){
        Intent sayfayaGit = new Intent(this, MainActivity.class);
        startActivity(sayfayaGit);
    }
}