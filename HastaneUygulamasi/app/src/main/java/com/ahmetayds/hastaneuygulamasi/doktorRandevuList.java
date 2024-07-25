package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityDoktorRandevuListBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class doktorRandevuList extends AppCompatActivity {
    ActivityDoktorRandevuListBinding binding;
    public FirebaseAuth auth;
    private FirebaseFirestore firestore;

    String girisYapanDoktorAdi;
    ArrayList<String> randevular = new ArrayList<>();
    ArrayList<String> hastaMailleri = new ArrayList<>();

    ArrayList<String> saatler = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_doktor_randevu_list);

        binding = ActivityDoktorRandevuListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        Intent gelenVeri = getIntent();
         girisYapanDoktorAdi =gelenVeri.getStringExtra("girisYapanDoktorAdi");


        Toast.makeText(this, girisYapanDoktorAdi, Toast.LENGTH_SHORT).show();

        firestore.collection("randevular").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {




                for(DocumentSnapshot dokuman : value.getDocuments()){
                    Map<String ,Object> gelenVeri = dokuman.getData();
                    String doktor = (String) gelenVeri.get("doktor");

                    if(doktor.equals(girisYapanDoktorAdi)){
                        String saat = String.valueOf(gelenVeri.get("saat"));
                        saatler.add(saat);
                        String HastaMaili = (String) gelenVeri.get("mail");
                        hastaMailleri.add(HastaMaili);



                    }
                }

                for(int i = 0;i<saatler.size();i++){
                    int finali = i;



                    firestore.collection("hastalar").addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {




                            for(DocumentSnapshot dokuman : value.getDocuments()){
                                Map<String ,Object> gelenVeri = dokuman.getData();

                                String denemeMaili = (String)gelenVeri.get("mail");

//                                for (int i = 0 ; i < hastaMailleri.size(); i++){
                                    if(hastaMailleri.get(finali).equals(denemeMaili)){

                                        System.out.println("i sayısı : " + finali);

                                        String hastaAdi = (String)gelenVeri.get("isim");
                                        String hastaSoyadi =(String)gelenVeri.get("soyisim");
                                        String eklenecek = hastaAdi + " " + hastaSoyadi + " " + "\n" + saatler.get(finali) + " " + hastaMailleri.get(finali);
                                        randevular.add(eklenecek);

                                    }
//                                }

//                                String hastaAdi = (String)gelenVeri.get("isim");
//                                String hastaSoyadi =(String)gelenVeri.get("soyisim");
//                                String eklenecek = hastaAdi + " " + hastaSoyadi + " " + "\n" + saatler.get(finali) + " " + hastaMailleri.get(finali);




                                ArrayAdapter adapter = new ArrayAdapter<>(doktorRandevuList.this, android.R.layout.simple_list_item_1,randevular);
                                binding.itemList.setAdapter(adapter);
                            }

                        }
                    });


                }

            }
        });





    }




    public void cikisYap(View view){
        startActivity(new Intent(this, doktorSistemGirisi.class));
        finish();
    }

}