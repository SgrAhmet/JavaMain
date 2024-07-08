package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityKayitSayfasiBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class kayitSayfasi extends AppCompatActivity {

    public  ActivityKayitSayfasiBinding binding;

    private FirebaseAuth auth;


    String[] sehirler = {
             "Şehir Seçiniz...", "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara",
            "Antalya", "Artvin", "Aydın", "Balıkesir", "Bilecik", "Bingöl",
            "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı",
            "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane",
            "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
            "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli",
            "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin",
            "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon",
            "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak",
            "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak",
            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye",
            "Düzce"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_kayit_sayfasi);

        binding = ActivityKayitSayfasiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();



        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sehirler);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.sehirSpinner.setAdapter(adapter);





    }




    public void hastaKayit(View view){
        String mail = binding.kayitMailText.getText().toString();
        String sifre = binding.kayitSifreText.getText().toString();
        String sifreTekrar = binding.kayitSifreTekrarText.getText().toString();
        String isim = binding.kayitIsimText.getText().toString();
        String soyisim = binding.kayitSoyisimText.getText().toString();
        String sehir = binding.sehirSpinner.getSelectedItem().toString();

        if(mail.equals("") ||sifre.equals("") ||sifreTekrar.equals("") ||isim.equals("") ||soyisim.equals("") ||sehir.equals(sehirler[0])){
            toast("Tüm Alanlar Doldurulmalıdır");

        }else{
            if(!sifre.equals(sifreTekrar)){
                toast("Şifreler Eşit değil");
            }else{
                auth.createUserWithEmailAndPassword(mail,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
//                        BAŞARILI

                        Intent giriseDon = new Intent(kayitSayfasi.this, MainActivity.class);
                        startActivity(giriseDon);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
//                        BAŞARISIZ
                        Toast.makeText(kayitSayfasi.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }


    }

    public void geriGit(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void toast(String myString){
        Toast.makeText(this, myString, Toast.LENGTH_SHORT).show();
    }
}