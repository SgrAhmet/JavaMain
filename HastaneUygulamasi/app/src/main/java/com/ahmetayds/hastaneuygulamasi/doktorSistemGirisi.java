package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityDoktorSistemGirisiBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class doktorSistemGirisi extends AppCompatActivity {
    ActivityDoktorSistemGirisiBinding binding;
    public FirebaseAuth auth;
    private FirebaseFirestore firestore;
    boolean giris = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_doktor_sistem_girisi);
        binding = ActivityDoktorSistemGirisiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

    }

    public void doktorSistemGiris(View view){
        String kullaniciAdi = binding.doktorKullaniciAdiText.getText().toString();
        String sifre = binding.doktorSifreText.getText().toString();


        firestore.collection("doktorlar").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                for(DocumentSnapshot dokuman : value.getDocuments()){
                    Map<String , Object> geleVeri =dokuman.getData();
                    String doktorAdi =(String)geleVeri.get("doktorKullaniciAdi");

                    if(doktorAdi.equals(kullaniciAdi) && sifre.equals("123456")){
                        giris = true;
                        break;
                    }
                }



                if(giris){
//                    GİRİS BARASİLİ
                    startActivity(new Intent(doktorSistemGirisi.this, doktorRandevuList.class));
                    finish();

                }else{
                    Toast.makeText(doktorSistemGirisi.this, "Kullanıcı Adı ya da Şifre Yanlış", Toast.LENGTH_SHORT).show();
                }




            }
        });








//        if(kullaniciAdi.isEmpty() || sifre.isEmpty()){
//            Toast.makeText(this, "Hiçbir Alan Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
//        }

    }


    public void geriGitDoktorSistem(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

}