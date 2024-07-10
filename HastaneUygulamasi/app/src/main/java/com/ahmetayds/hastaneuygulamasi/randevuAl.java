package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityRandevuAlBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class randevuAl extends AppCompatActivity {

    private ActivityRandevuAlBinding binding;
    String[] hastaneler ={"Hastane Seçiniz...","Ankara Üniversitesi Hastanesi" , "Gazi Üniversitesi Hastanesi","Hacettepe Üniversitesi Hastanesi","İbn-i Sina Hastanesi"};
    String[] bolumler = {"Bölüm Seçiniz...","Ortopedi","Nöroloji","Dermatoloji","Dahiliye","Psikiyatri"};

    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    ArrayList<String> doktorlar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_randevu_al);
        binding = ActivityRandevuAlBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        doktorlar.add("Doktorlar Seçiniz...");



//        String[] doktorlar = getIntent().getStringArrayExtra("doktorlar");
//
//        System.out.println(doktorlar[2]);

        binding.bolumSpinner.setVisibility(View.INVISIBLE);
        binding.doktorSpinner.setVisibility(View.INVISIBLE);
//        binding.textView9.setVisibility(View.INVISIBLE);
//        binding.textView10.setVisibility(View.INVISIBLE);
//        binding.textView11.setVisibility(View.INVISIBLE);
//        binding.textView13.setVisibility(View.INVISIBLE);
//        binding.textView15.setVisibility(View.INVISIBLE);
//        binding.textView16.setVisibility(View.INVISIBLE);
        binding.linearLayout.setVisibility(View.INVISIBLE);
        binding.randevuOlusturButton.setVisibility(View.INVISIBLE);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,hastaneler);
        binding.hastaneSpinner.setAdapter(adapter);


// ==========================HASTANE SEÇİM ALANI=================================
        binding.hastaneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!binding.hastaneSpinner.getSelectedItem().equals(hastaneler[0])){

                    ArrayAdapter adapter2 = new ArrayAdapter(randevuAl.this, android.R.layout.simple_list_item_1,bolumler);
                    binding.bolumSpinner.setAdapter(adapter2);
                    binding.bolumSpinner.setVisibility(View.VISIBLE);

                    binding.hastaneSpinner.setBackgroundResource(R.drawable.border);
// ==========================BÖLÜM SEÇİM ALANI=================================

                    binding.bolumSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(!binding.bolumSpinner.getSelectedItem().equals(bolumler[0])){
                                binding.doktorSpinner.setVisibility(View.VISIBLE);

                                String hastane = binding.hastaneSpinner.getSelectedItem().toString();
                                String bolum = binding.bolumSpinner.getSelectedItem().toString();
                                doktorlar.clear();
                                doktorlar.add("Doktorlar Seçiniz...");
                                firestore.collection("doktorlar").whereEqualTo("bolum",bolum).whereEqualTo("hastane",hastane).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                        for (DocumentSnapshot dokuman : value.getDocuments()){
                                            Map<String,Object> gelenVeri = dokuman.getData();
                                            String gelenDoktor = (String)dokuman.get("doktorAdi");

                                            doktorlar.add(gelenDoktor);

                                            ArrayAdapter adapter3 = new ArrayAdapter<>(randevuAl.this, android.R.layout.simple_list_item_1,doktorlar);
                                            binding.doktorSpinner.setAdapter(adapter3);

                                        }
                                    }
                                });

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

                                binding.doktorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if(!binding.doktorSpinner.getSelectedItem().equals(doktorlar.get(0).toString())){
                                                binding.linearLayout.setVisibility(View.VISIBLE);

                                                binding.doktorSpinner.setBackgroundResource(R.drawable.border);

                                        }else{
                                            binding.linearLayout.setVisibility(View.INVISIBLE);
                                            binding.doktorSpinner.setBackgroundResource(R.drawable.deneme_bos);

                                        }

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });


//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

                                binding.bolumSpinner.setBackgroundResource(R.drawable.border);

                            }else {
                                binding.doktorSpinner.setVisibility(View.INVISIBLE);
                                binding.linearLayout.setVisibility(View.INVISIBLE);
                                binding.bolumSpinner.setBackgroundResource(R.drawable.deneme_bos);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
// ==========================BÖLÜM SEÇİM ALANI=================================



                }else{
                    binding.bolumSpinner.setVisibility(View.INVISIBLE);
                    binding.doktorSpinner.setVisibility(View.INVISIBLE);
                    binding.linearLayout.setVisibility(View.INVISIBLE);
                    binding.hastaneSpinner.setBackgroundResource(R.drawable.deneme_bos);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
// ==========================HASTANE SEÇİM ALANI=================================



    }




    public void gecmisRandevularGeriGit(View view){
        startActivity(new Intent(this, hastaAnaSayfa.class));
        finish();
    }
}