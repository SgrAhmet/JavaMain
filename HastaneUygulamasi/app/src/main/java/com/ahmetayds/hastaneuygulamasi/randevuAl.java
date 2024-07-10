package com.ahmetayds.hastaneuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityRandevuAlBinding;

public class randevuAl extends AppCompatActivity {

    private ActivityRandevuAlBinding binding;
    String[] hastaneler ={"Hastane Seçiniz...","Ankara Üniversitesi Hastanesi" , "Gazi Üniversitesi Hastanesi","Hacettepe Üniversitesi Hastanesi","İbn-i Sina Hastanesi"};
    String[] bolumler = {"Bölüm Seçiniz...","Ortopedi","Nöroloji","Dermatoloji","Dahiliye","Psikiyatri"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_randevu_al);
        binding = ActivityRandevuAlBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

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

        binding.hastaneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!binding.hastaneSpinner.getSelectedItem().equals(hastaneler[0])){

                    ArrayAdapter adapter2 = new ArrayAdapter(randevuAl.this, android.R.layout.simple_list_item_1,bolumler);
                    binding.bolumSpinner.setAdapter(adapter2);
                    binding.bolumSpinner.setVisibility(View.VISIBLE);

                    binding.hastaneSpinner.setBackgroundResource(R.drawable.border);
                }else{
                    binding.bolumSpinner.setVisibility(View.INVISIBLE);
                    binding.hastaneSpinner.setBackgroundResource(R.drawable.deneme_bos);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }




    public void gecmisRandevularGeriGit(View view){
        startActivity(new Intent(this, hastaAnaSayfa.class));
        finish();
    }
}