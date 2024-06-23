//package com.ahmetayds.uygulamasnav;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//
//    ArrayList<OgrenciData> ogrenciDataArray = new ArrayList<>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        OgrenciData ogrenci1 = new OgrenciData("ahmetaydos","12345");
//        OgrenciData ogrenci2 = new OgrenciData("yusufaydos","12345");
//        OgrenciData ogrenci3 = new OgrenciData("furkanaydos","12345");
//        OgrenciData ogrenci4 = new OgrenciData("zeynepaydos","12345");
//
//        ogrenciDataArray.add(ogrenci1);
//        ogrenciDataArray.add(ogrenci2);
//        ogrenciDataArray.add(ogrenci3);
//        ogrenciDataArray.add(ogrenci4);
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
//    public void ogretmenGirisiGit(View view){
//        Intent sayfayaGit = new Intent(this, OgretmenGirisi.class);
//        startActivity(sayfayaGit);
//    }
//
//
//    public void ogrenciGirisiGit(View view){
//        Intent sayfayaGit = new Intent(this, OgrenciGirisi.class);
//        sayfayaGit.putExtra("ogrenciDataArray",ogrenciDataArray);
//        startActivity(sayfayaGit);
//    }
//}

package com.ahmetayds.uygulamasnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String[] isimler = {"ahmetaydos", "yusufaydos", "furkanaydos","zeynepaydos"};
    String[] sifreler = {"12345", "12345","12345","12345"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    public void ogretmenGirisiGit(View view){
        Intent sayfayaGit = new Intent(this, OgretmenGirisi.class);
        sayfayaGit.putExtra("isimler",isimler);
        sayfayaGit.putExtra("sifreler",sifreler);
        startActivity(sayfayaGit);
    }

    public void ogrenciGirisiGit(View view){
        Intent sayfayaGit = new Intent(this, OgrenciGirisi.class);
        sayfayaGit.putExtra("isimler",isimler);
        sayfayaGit.putExtra("sifreler",sifreler);
        startActivity(sayfayaGit);
    }
}