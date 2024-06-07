package com.ahmetayds.loginpage3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editTextText;
    EditText editTextText2;
    EditText editTextText3;
    EditText editTextText4;
    EditText editTextTextPassword;

    EditText editTextTextPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextText= findViewById(R.id.editTextText);
        editTextText2= findViewById(R.id.editTextText2);
        editTextText3= findViewById(R.id.editTextText3);
        editTextText4= findViewById(R.id.editTextText4);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);



    }


    public void girisYap(View view){

        SharedPreferences veriGetir =this.getPreferences(Context.MODE_PRIVATE);
        String isim = veriGetir.getString("isim","");
        String soyisim = veriGetir.getString("soyisim","");
        String kullanıcıAdı = veriGetir.getString("kullanıcıAdı","");
        String şifre = veriGetir.getString("şifre","");


        if(editTextText.getText().toString().matches("")||editTextTextPassword.getText().toString().matches("")){
            Toast.makeText(this, "Kullanıcı Adı ya da Şifre Boş Bırakılamaz ", Toast.LENGTH_SHORT).show();
        }else{
//            if(kullanıcıAdı == editTextText.getText().toString() || şifre == editTextTextPassword.getText().toString()){
//                Intent ikinciSayfayaGit = new Intent(this, MainActivity2.class);
//                ikinciSayfayaGit.putExtra("isim",isim);
//                ikinciSayfayaGit.putExtra("soyisim",soyisim);
//                startActivity(ikinciSayfayaGit);
//            }else{
//                Toast.makeText(this, "Kullanıcı Adı ya da Şifre Yanlış", Toast.LENGTH_SHORT).show();
//            }

            System.out.println("kullanıcı adı : "  +kullanıcıAdı+ "  "+  editTextText.getText().toString());
            System.out.println("şifre  : "  +şifre+ "  "+  editTextTextPassword.getText().toString());

        }







    }

    public void kayitOl(View view){

//===================================Veri Gönderme===========================

        SharedPreferences veriKaydet =this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =veriKaydet.edit();

        editor.putString("isim",editTextText2.getText().toString());
        editor.putString("soyisim",editTextText3.getText().toString());
        editor.putString("kullanıcıAdı",editTextText4.getText().toString());
        editor.putString("şifre",editTextTextPassword2.getText().toString());

        editor.apply();






    }
}