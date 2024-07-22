package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityGecmisRandevularBinding;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class gecmisRandevular extends AppCompatActivity {
    ActivityGecmisRandevularBinding binding;

    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    ArrayList<String> yazdirilacak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gecmis_randevular);

        binding = ActivityGecmisRandevularBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        randevuGetir();

    }

    public void randevuGetir(){
        FirebaseUser aktifKullanici = auth.getCurrentUser();
        String mail = aktifKullanici.getEmail();

        firestore.collection("randevular").whereEqualTo("mail",mail).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                for (DocumentSnapshot dokuman : value.getDocuments()){
                    Map<String,Object> gelenVeri = dokuman.getData();

                    Timestamp tarih = (Timestamp) gelenVeri.get("olusturmaTarihi");
                    Date tarih2 = tarih.toDate();
                    DateFormat tarihFormati = new SimpleDateFormat("dd/MM/yyyy");
                    String yazilacakTarih=tarihFormati.format(tarih2);

//                    String tarih =(String)gelenVeri.get("tarih");
                    String hastane =(String)gelenVeri.get("hastane");
                    String bolum =(String)gelenVeri.get("bolum");
                    String doktor =(String)gelenVeri.get("doktor");
                    String saat = (String)gelenVeri.get("saat");

//                    yazdirilacak.add(tarih + "-" + hastane + "-" + bolum + "-" + doktor );

                    yazdirilacak.add("\nOluşturulma Tarihi  : "+yazilacakTarih+"\n"+hastane+"\n"+"Bölüm : " +bolum+"\n"+"Doktor : " +doktor+ "\n" +"Saat : " +saat+"\n        ");

                }
                ArrayAdapter adapter = new ArrayAdapter(gecmisRandevular.this, android.R.layout.simple_list_item_1,yazdirilacak);
                binding.gecmisRandevuList.setAdapter(adapter);



            }
        });

    }







    public void gecmisRandevularGeriGit(View view){
        startActivity(new Intent(this, hastaAnaSayfa.class));
        finish();
    }


}