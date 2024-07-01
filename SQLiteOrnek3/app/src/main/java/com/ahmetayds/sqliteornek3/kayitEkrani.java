package com.ahmetayds.sqliteornek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.sqliteornek3.databinding.ActivityKayitEkraniBinding;

public class kayitEkrani extends AppCompatActivity {

    private ActivityKayitEkraniBinding binding;

    Boolean isSamePerson = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_kayit_ekrani);

        binding = ActivityKayitEkraniBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }



    public void kayitOlFunc(View view){
        String yeniIsim = binding.editTextText2.getText().toString();
        String yeniSoyIsim = binding.editTextText3.getText().toString();
        String yeniKullaniciAdi = binding.editTextText4.getText().toString();
        String yeniSifre = binding.editTextTextPassword.getText().toString();
        String yeniEmail = binding.editTextTextEmailAddress.getText().toString();


        if(yeniIsim.equals("") || yeniSoyIsim.equals("") || yeniKullaniciAdi.equals("") || yeniSifre.equals("") || yeniEmail.equals("") || binding.editTextPhone.getText().toString().matches("")){
            Toast.makeText(this, "Hiçbir Alanı Boş Bırakmayınız", Toast.LENGTH_SHORT).show();
        }else{


//            try {
//
//                SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
//                Cursor cursor =veriTabani.rawQuery("SELECT * FROM kullanicilar",null);
//
//                int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
//
//                while(cursor.moveToNext()){
//
//                    String kullanıciAdi = cursor.getString(kullanıciAdlari);
//
//                    if(kullanıciAdi.matches(yeniKullaniciAdi)){
//                        isSamePerson = true;
//                    }
//
//
//
//                }
//
//
//
//            }catch (Exception e){
//                Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
//            }



// ============================================================================================================================================
//            basariliKayit();


            if(isSamePerson){
                Toast.makeText(this, "Bu Kullanıcı Adı Daha Önce Alınmış", Toast.LENGTH_SHORT).show();
            }else{
                try {
                    int yeniTelefon = Integer.valueOf(binding.editTextPhone.getText().toString());


                    SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
                    veriTabani.execSQL("INSERT INTO kullanicilar (kullaniciAdi, sifre, isim, soyisim, email, telefon) VALUES ('" + yeniKullaniciAdi + "','" + yeniSifre + "','" + yeniIsim + "','" + yeniSoyIsim + "','" + yeniEmail + "'," + yeniTelefon + ")");
                    Toast.makeText(this, "Kullanıcı Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();

                    binding.editTextText2.setText("");
                    binding.editTextText3.setText("");
                    binding.editTextText4.setText("");
                    binding.editTextTextPassword.setText("");
                    binding.editTextTextEmailAddress.setText("");
                    binding.editTextPhone.setText("");

                }catch (Exception e){
                    Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
                }
            }


// ============================================================================================================================================

        }





    }




    public void geriGit (View view){
        startActivity(new Intent(this, MainActivity.class));
    }

}