package com.ahmetayds.loginpage2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfilSayfasi extends AppCompatActivity {

    TextView veriAlanı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_sayfasi);

        veriAlanı = findViewById(R.id.veriAlanı);

//        Intent verial = getIntent();
        String gelenVeri1 =  getIntent().getStringExtra("ilkVeri");
        String gelenVeri2 =  getIntent().getStringExtra("ikinciVeri");

        veriAlanı.setText(gelenVeri1 + " " +gelenVeri2);
    }

    public void sayfaGecis1(View view){
        Intent birinciSayfayaGecis = new Intent(this, MainActivity.class);
        startActivity(birinciSayfayaGecis);
    }
}