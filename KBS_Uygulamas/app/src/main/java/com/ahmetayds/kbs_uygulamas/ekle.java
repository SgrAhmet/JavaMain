package com.ahmetayds.kbs_uygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ekle extends AppCompatActivity {

    EditText isimText;
    EditText soyisimText;
    EditText yasText;
    EditText sinifText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);
    }



    public void ekle(View view){
        if (isimText .getText().toString().isEmpty() || soyisimText.getText().toString().isEmpty()){
            Toast.makeText(this, "Hiçbir Alan Boş Geçilemez", Toast.LENGTH_SHORT).show();
        }else{
            try {

                String isim = isimText.getText().toString();
                String soyisim = soyisimText.getText().toString();
                int yas= Integer.parseInt(yasText.getText().toString());
                String sinif = sinifText.getText().toString();

                SQLiteDatabase veriTabanı = this.openOrCreateDatabase("ogrenciler",MODE_PRIVATE,null);
                veriTabanı.execSQL("INSERT INTO ogrenciler (isim,soyisim,yas,sınıf) VALUES ('" + isim + "'");

                Toast.makeText(this, "Öğrenci Başarıyla Eklenmiştir", Toast.LENGTH_SHORT).show();

                isimText.setText("");
                soyisimText.setText("");
                yasText.setText("");
                sinifText.setText("");



            }catch (Exception e){
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }




        }
    }

}