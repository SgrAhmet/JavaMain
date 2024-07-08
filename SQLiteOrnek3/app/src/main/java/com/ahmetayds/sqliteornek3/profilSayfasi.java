package com.ahmetayds.sqliteornek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.sqliteornek3.databinding.ActivityProfilSayfasiBinding;

public class profilSayfasi extends AppCompatActivity {

    int[] widgetGroup1 = {R.id.view,R.id.evetButton,R.id.hayırButton,R.id.textView21};
    int[] widgetGroup2 = {
            R.id.button5,
            R.id.textView3,
            R.id.textView4,
            R.id.textView5,
            R.id.textView6,
            R.id.textView7,
            R.id.textView8,
            R.id.imageView,
            R.id.textView10,
            R.id.textView11,
            R.id.textView17,
            R.id.textView18,
            R.id.textView19,
            R.id.textView20,
            R.id.imageView2
    };

    private ActivityProfilSayfasiBinding binding;
    Boolean IsAdmin;
    String girilenKullaniciAdi;
    String girilenSifre ;
    String girilenIsim ;
    String girilenSoyisim ;
    String girilenEmail ;
    String girilenTelefon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profil_sayfasi);

        binding = ActivityProfilSayfasiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


         girilenKullaniciAdi = getIntent().getStringExtra("girilenKullaniciAdi");
         IsAdmin = getIntent().getBooleanExtra("IsAdmin",false);

        System.out.println("Is Admin : " + IsAdmin);


        if (IsAdmin){
            binding.button5.setText("Geri Git");
        }





        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);
            Cursor cursor =veriTabani.rawQuery("SELECT * FROM kullanicilar",null);

            int kullanıciAdlari = cursor.getColumnIndex("kullaniciAdi");
            int sifreler = cursor.getColumnIndex("sifre");
            int isimler = cursor.getColumnIndex("isim");
            int soyisimker = cursor.getColumnIndex("soyisim");
            int emailler = cursor.getColumnIndex("email");
            int telefonlar = cursor.getColumnIndex("telefon");



            while(cursor.moveToNext()){
                String kullanıciAdi = cursor.getString(kullanıciAdlari);
                String sifre = cursor.getString(sifreler);
                String isim = cursor.getString(isimler);
                String soyisim = cursor.getString(soyisimker);
                String email = cursor.getString(emailler);
                String telefon = cursor.getString(telefonlar);


                System.out.println(kullanıciAdi);



                if(girilenKullaniciAdi.matches(kullanıciAdi)){


                    System.out.println("worked");

                    girilenSifre = sifre;
                     girilenIsim = isim ;
                     girilenSoyisim = soyisim;
                     girilenEmail = email;
                     girilenTelefon = telefon;
                }

            }
        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
        }


        binding.textView3.setText(girilenIsim);
        binding.textView4.setText(girilenSoyisim);
        binding.textView5.setText(girilenKullaniciAdi);
        binding.textView6.setText(girilenSifre);
        binding.textView7.setText(girilenEmail);
        binding.textView8.setText(girilenTelefon);








    }


    public void geriGit (View view){

        if(IsAdmin){
            startActivity(new Intent(this, adminSayfasi.class));
        }else{
            startActivity(new Intent(this, MainActivity.class));
        }

    }

    public void düzenlemeSayfasiGit(View view){
        Intent sayfayaGit = new Intent(this, duzenlemeSayfasi.class);
        sayfayaGit.putExtra("girilenKullaniciAdi",girilenKullaniciAdi);
        startActivity(sayfayaGit);
    }

    public void deleteImg(View view){
        closeGroup2();
        openGroup1();
    }

    public void hayırButton(View view){
        closeGroup1();
        openGroup2();
    }

    public void evetButton(View view){
        kullaniciSil();
        geriGit(view);
    }



//=========================Kullanıcı Silme====================

    public void kullaniciSil(){

        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanıcılar_db" ,MODE_PRIVATE,null);

            veriTabani.execSQL("DELETE FROM kullanicilar WHERE kullaniciAdi = '" + girilenKullaniciAdi + "'");


        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
        }
    }


//============================================================
    public void closeGroup1(){
        for (int id : widgetGroup1) {
            View view = findViewById(id);
            view.setVisibility(View.INVISIBLE);
        }
    }

    public void openGroup1(){
        for (int id : widgetGroup1) {
            View view = findViewById(id);
            view.setVisibility(View.VISIBLE);}
    }
    public void closeGroup2(){
        for (int id : widgetGroup2) {
            View view = findViewById(id);
            view.setVisibility(View.INVISIBLE);
        }
    }
    public void openGroup2(){
        for (int id : widgetGroup2) {
            View view = findViewById(id);
            view.setVisibility(View.VISIBLE);
        }
    }
//============================================================


}