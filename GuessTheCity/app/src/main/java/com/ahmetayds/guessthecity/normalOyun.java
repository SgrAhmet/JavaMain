package com.ahmetayds.guessthecity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmetayds.guessthecity.databinding.ActivityNormalOyunBinding;

import java.util.Random;

public class normalOyun extends AppCompatActivity {
    private ActivityNormalOyunBinding binding;

    String[] iller = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"};

    Random  myRandom = new Random();
    String randomCity;
    String hiddenRandomCity = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_normal_oyun);

        binding = ActivityNormalOyunBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);








        randomCity = iller[ myRandom.nextInt(iller.length)] ;



        for(int i = 0; i < randomCity.length();i++){
            hiddenRandomCity += " *";
        }

        binding.textView2.setText(hiddenRandomCity + " " + randomCity);










    }


    public void goToMainPage(View view){
        Intent goToMainPage = new Intent(this, MainActivity.class);
        startActivity(goToMainPage);
    }

    public void guessButton(View view){
        if(binding.editTextText.getText().toString().toLowerCase().matches(randomCity.toLowerCase())){
            Toast.makeText(this, "Doğru", Toast.LENGTH_SHORT).show();
        }
    }

}