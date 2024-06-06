package com.ahmetayds.loginpage2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText isimEditText;
    EditText soyisimEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isimEditText = findViewById(R.id.isimEditText);
        soyisimEditText = findViewById(R.id.soyisimEditText);
    }

    public void sayfaGecis2(View view){

        if(isimEditText.getText().toString().matches("") || soyisimEditText.getText().toString().matches("")){
            Toast.makeText(this,"Lütfen Veri Girişi Yapın",Toast.LENGTH_LONG).show();
        }else{
            String isim = isimEditText.getText().toString();
            String soyisim = soyisimEditText.getText().toString();



            Intent ikinciSayfayaGecis = new Intent(this, ProfilSayfasi.class);
            ikinciSayfayaGecis.putExtra("ilkVeri",isim);
            ikinciSayfayaGecis.putExtra("ikinciVeri",soyisim);
            startActivity(ikinciSayfayaGecis);
        }

    }
}