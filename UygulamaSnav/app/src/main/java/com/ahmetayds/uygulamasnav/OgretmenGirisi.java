package com.ahmetayds.uygulamasnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.ahmetayds.uygulamasnav.databinding.ActivityOgretmenGirisiBinding;

import java.util.ArrayList;

public class OgretmenGirisi extends AppCompatActivity {

    private ActivityOgretmenGirisiBinding binding;

    ArrayList<OgretmenData> ogretmenDataArray = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ogretmen_girisi);

        binding = ActivityOgretmenGirisiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        OgretmenData ogretmen1 = new OgretmenData("ozlemaytekinadmin","54321");
        OgretmenData ogretmen2 = new OgretmenData("mahmuttunceradmin","54321");

        ogretmenDataArray.add(ogretmen1);
        ogretmenDataArray.add(ogretmen2);

    }





    public void OgretmenDetayGit(View view){
        if(binding.kullanCAdiEditText.getText().toString().matches("")||binding.sifreEditText.getText().toString().matches("")){
            Toast.makeText(this, "Lütfen Kullanıcı Adı ve Şifrenizi Giriniz", Toast.LENGTH_SHORT).show();
        }else{
            boolean loginChecked = false;
            for (int i = 0;i< ogretmenDataArray.size();i++ ){
                if(binding.kullanCAdiEditText.getText().toString().matches(ogretmenDataArray.get(i).kullaniciAdi.toString()) || binding.sifreEditText.getText().toString().matches(ogretmenDataArray.get(i).sifre.toString())){
                    Intent sayfayaGit = new Intent(this, OgretmenDetay.class);
                    startActivity(sayfayaGit);
                    loginChecked = true;
                }else{
                    loginChecked =false;
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