package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        TextView textView = findViewById(R.id.textView6);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        auth = FirebaseAuth.getInstance();


    }



    public void giris(View view){
        String mail = binding.mailText.getText().toString();
        String sifre = binding.sifreText.getText().toString();

        if(mail.equals("") || sifre.equals("")){
            toast("Email yada Şifre Boş Bırakılamaz");
        }else{
//            toast("Mail : " + mail + "    " + "Şifre : " + sifre);

            auth.signInWithEmailAndPassword(mail,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    toast("başarılı");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    toast("Kulanıcı Adı yada Şifre Yanlış");
//                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }

    }
    public void kayit(View view){
        startActivity(new Intent(this, kayitSayfasi.class));
    }



    public void toast(String myString){
        Toast.makeText(this, myString, Toast.LENGTH_SHORT).show();
    }


}



























