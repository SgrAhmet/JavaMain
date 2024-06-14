package com.ahmetayds.guessthecity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmetayds.guessthecity.databinding.ActivityNormalOyunBinding;

import java.util.ArrayList;
import java.util.Random;

public class normalOyun extends AppCompatActivity {
    private ActivityNormalOyunBinding binding;

//    String[] iller = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"};
    String[] iller = {"Adana", "Adiyaman", "Afyonkarahisar", "Agri", "Amasya", "Ankara", "Antalya", "Artvin", "Aydin", "Balikesir", "Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur", "Bursa", "Canakkale", "Cankiri", "Corum", "Denizli", "Diyarbakir", "Edirne", "Elazig", "Erzincan", "Erzurum", "Eskisehir", "Gaziantep", "Giresun", "Gumushane", "Hakkari", "Hatay", "Isparta", "Mersin", "Istanbul", "Izmir", "Kars", "Kastamonu", "Kayseri", "Kirklareli", "Kirsehir", "Kocaeli", "Konya", "Kutahya", "Malatya", "Manisa", "Kahramanmaras", "Mardin", "Mugla", "Mus", "Nevsehir", "Nigde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdag", "Tokat", "Trabzon", "Tunceli", "Sanliurfa", "Usak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kirikkale", "Batman", "Sirnak", "Bartin", "Ardahan", "Igdir", "Yalova", "Karabuk", "Kilis", "Osmaniye", "Duzce"};

    Random  myRandom = new Random();
    String randomCity;
    String hiddenRandomCity = "";
//    String randomCityLetters = "";
    ArrayList<Character> randomCityLetters = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_normal_oyun);

        binding = ActivityNormalOyunBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);






        sehirSec();


    }

    public void goToMainPage(View view){
        Intent goToMainPage = new Intent(this, MainActivity.class);
        startActivity(goToMainPage);
    }





    public void sehirSec(){
        hiddenRandomCity = "";
//        randomCity = iller[ myRandom.nextInt(iller.length)] ;
        randomCity = "Ankara";
        for(int i = 0; i < randomCity.length();i++){
            hiddenRandomCity += " *";
        }

        binding.textView2.setText(hiddenRandomCity + " " + randomCity);



        for( char harf : randomCity.toCharArray()){
            randomCityLetters.add(harf);
        }

        System.out.println(randomCityLetters);


    }





    public void harfAl(View view){


    ;


        hiddenRandomCity = "";



        String letter =  randomCityLetters.get(myRandom.nextInt(randomCityLetters.size())).toString().toLowerCase();

        for(int i = 0 ;i < randomCity.length();i++){
            if(letter.toLowerCase().charAt(0) == randomCity.toLowerCase().charAt(i)){
                hiddenRandomCity += letter;
            }else{
                hiddenRandomCity += " *";
            }
        }



        binding.textView2.setText(hiddenRandomCity + " " + randomCity);

    }





    public void guessButton(View view){
        if(binding.editTextText.getText().toString().toLowerCase().matches(randomCity.toLowerCase())){
            Toast.makeText(this, "Doğru Tahmin", Toast.LENGTH_SHORT).show();
//            Intent intent = getIntent();
//            finish();
//            startActivity(intent);
            sehirSec();

        }else{
            Toast.makeText(this, "Yanlış Tahmin", Toast.LENGTH_SHORT).show();

        }
    }

}