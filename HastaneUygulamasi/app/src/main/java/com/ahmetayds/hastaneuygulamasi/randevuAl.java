package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityRandevuAlBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class randevuAl extends AppCompatActivity {

    private ActivityRandevuAlBinding binding;
    String[] hastaneler ={"Hastane Seçiniz...","Ankara Üniversitesi Hastanesi" , "Gazi Üniversitesi Hastanesi","Hacettepe Üniversitesi Hastanesi","İbn-i Sina Hastanesi"};
    String[] bolumler = {"Bölüm Seçiniz...","Ortopedi","Nöroloji","Dermatoloji","Dahiliye","Psikiyatri"};

    TextView textView9, textView11, textView15, textView10, textView13, textView16;

    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    ArrayList<String> doktorlar = new ArrayList<>();

    String secilenSaat ;
    int zaman = 0;
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

                                            binding.randevuOlusturButton.setVisibility(View.INVISIBLE);
                                            setBackgroundZero();


                                            System.out.println("agjıelrahgkdsfngvbjkesbngjrsbg");
                                            String doktor = binding.doktorSpinner.getSelectedItem().toString();
                                            System.out.println(doktor);
                                            firestore.collection("randevular").whereEqualTo("doktor",doktor).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                                @Override
                                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                                    for (DocumentSnapshot dokuman : value.getDocuments()){
                                                        Map<String ,Object> gelenVeri = dokuman.getData();
                                                        String saat = String.valueOf(gelenVeri.get("saat"));

                                                        System.out.println("yeni kod :    Saat  : " + saat);

                                                        if(saat.equals("9.00")){

                                                        }

                                                        if(saat.equals("10.00")){

                                                        }

                                                        if(saat.equals("11.00")){

                                                        }

                                                        if(saat.equals("13.00")){

                                                        }

                                                        if(saat.equals("15.00")){

                                                        }

                                                        if(saat.equals("16.00")){

                                                        }

                                                    }
                                                }
                                            });
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

                                binding.randevuOlusturButton.setVisibility(View.INVISIBLE);
                                setBackgroundZero();
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

                    binding.randevuOlusturButton.setVisibility(View.INVISIBLE);
                    setBackgroundZero();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
// ==========================HASTANE SEÇİM ALANI=================================


        textView9 = findViewById(R.id.textView9);
        textView11 = findViewById(R.id.textView11);
        textView15 = findViewById(R.id.textView15);
        textView10 = findViewById(R.id.textView10);
        textView13 = findViewById(R.id.textView13);
        textView16 = findViewById(R.id.textView16);


        View.OnClickListener textViewClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tıklanan TextView'i belirleme
                TextView clickedTextView = (TextView) v;

                // TextView'in içindeki metni alıp Toast mesajı olarak gösterme
                String saat = clickedTextView.getText().toString();
                secilenSaat = saat;
                saatSec(clickedTextView);
            }
        };

        textView9.setOnClickListener(textViewClickListener);
        textView11.setOnClickListener(textViewClickListener);
        textView15.setOnClickListener(textViewClickListener);
        textView10.setOnClickListener(textViewClickListener);
        textView13.setOnClickListener(textViewClickListener);
        textView16.setOnClickListener(textViewClickListener);




    }




    public void saatSec (TextView myTextView){

        binding.randevuOlusturButton.setVisibility(View.VISIBLE);

        setBackgroundZero();

        myTextView.setBackgroundResource(R.drawable.border);
    }

    public void setBackgroundZero(){
        textView9.setBackgroundResource(0);
        textView11.setBackgroundResource(0);
        textView15.setBackgroundResource(0);
        textView15.setBackgroundResource(0);
        textView10.setBackgroundResource(0);
        textView13.setBackgroundResource(0);
        textView16.setBackgroundResource(0);
    }


    public void randevuEkle(){
        String hastane = binding.hastaneSpinner.getSelectedItem().toString();
        String bolum = binding.bolumSpinner.getSelectedItem().toString();
        String doktor = binding.doktorSpinner.getSelectedItem().toString();
        FirebaseUser aktifKullanici = auth.getCurrentUser();
        String mail = aktifKullanici.getEmail();

        String text = hastane + "," + bolum + "," + doktor + ","+ mail + "," +secilenSaat;


        HashMap<String,Object> veriGonder = new HashMap<>();
        veriGonder.put("mail",mail);
        veriGonder.put("hastane",hastane);
        veriGonder.put("bolum",bolum);
        veriGonder.put("doktor",doktor);
        veriGonder.put("saat",secilenSaat);
        veriGonder.put("olusturmaTarihi", FieldValue.serverTimestamp());

        firestore.collection("randevular").add(veriGonder).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(randevuAl.this, "Randevu Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(randevuAl.this,hastaAnaSayfa.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(randevuAl.this, "Randevu Oluşturulamadı", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void randevuOlustur(View view){
        String hastane = binding.hastaneSpinner.getSelectedItem().toString();
        String bolum = binding.bolumSpinner.getSelectedItem().toString();
        String doktor = binding.doktorSpinner.getSelectedItem().toString();
        binding.textView2.setText(hastane);
        binding.textView3.setText(bolum);
        binding.textView4.setText(doktor);
        binding.textView7.setText(secilenSaat);

        closeAll();
    }



    public void closeAll(){
        binding.hastaneSpinner.setVisibility(View.INVISIBLE);
        binding.bolumSpinner.setVisibility(View.INVISIBLE);
        binding.doktorSpinner.setVisibility(View.INVISIBLE);
        binding.linearLayout.setVisibility(View.INVISIBLE);
        binding.randevuOlusturButton.setVisibility(View.INVISIBLE);
//        binding.button6.setVisibility(View.INVISIBLE);

        binding.view3.setVisibility(View.VISIBLE);
        binding.textView2.setVisibility(View.VISIBLE);
        binding.textView3.setVisibility(View.VISIBLE);
        binding.textView4.setVisibility(View.VISIBLE);
        binding.textView7.setVisibility(View.VISIBLE);
        binding.button8.setVisibility(View.VISIBLE);
        binding.imageView5.setVisibility(View.VISIBLE);

    }

    public void openAll(){
        binding.hastaneSpinner.setVisibility(View.VISIBLE);
        binding.bolumSpinner.setVisibility(View.VISIBLE);
        binding.doktorSpinner.setVisibility(View.VISIBLE);
        binding.linearLayout.setVisibility(View.VISIBLE);
        binding.randevuOlusturButton.setVisibility(View.VISIBLE);
//        binding.button6.setVisibility(View.VISIBLE);

        binding.view3.setVisibility(View.INVISIBLE);
        binding.textView2.setVisibility(View.INVISIBLE);
        binding.textView3.setVisibility(View.INVISIBLE);
        binding.textView4.setVisibility(View.INVISIBLE);
        binding.textView7.setVisibility(View.INVISIBLE);
        binding.button8.setVisibility(View.INVISIBLE);
        binding.imageView5.setVisibility(View.INVISIBLE);
    }

    public void closeButton (View view){
        openAll();
    }

    public void onaylaButton (View view){
        randevuEkle();
    }

    public void gecmisRandevularGeriGit(View view){
        startActivity(new Intent(this, hastaAnaSayfa.class));
        finish();
    }
}