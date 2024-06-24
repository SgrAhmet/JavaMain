package com.ahmetayds.guessthecity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.guessthecity.databinding.ActivityNormalOyunBinding;
import com.ahmetayds.guessthecity.databinding.ActivitySureliOyunBinding;

import java.util.ArrayList;
import java.util.Random;


public class sureliOyun extends AppCompatActivity {

    private ActivitySureliOyunBinding binding;

    Random myRandom = new Random();

    String[] iller = {"Adana", "Adiyaman", "Afyonkarahisar", "Agri", "Amasya", "Ankara", "Antalya", "Artvin", "Aydin", "Balikesir", "Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur", "Bursa", "Canakkale", "Cankiri", "Corum", "Denizli", "Diyarbakir", "Edirne", "Elazig", "Erzincan", "Erzurum", "Eskisehir", "Gaziantep", "Giresun", "Gumushane", "Hakkari", "Hatay", "Isparta", "Mersin", "Istanbul", "Izmir", "Kars", "Kastamonu", "Kayseri", "Kirklareli", "Kirsehir", "Kocaeli", "Konya", "Kutahya", "Malatya", "Manisa", "Kahramanmaras", "Mardin", "Mugla", "Mus", "Nevsehir", "Nigde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdag", "Tokat", "Trabzon", "Tunceli", "Sanliurfa", "Usak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kirikkale", "Batman", "Sirnak", "Bartin", "Ardahan", "Igdir", "Yalova", "Karabuk", "Kilis", "Osmaniye", "Duzce"};

    String randomCity;
    String randomHiddenCity = "";

    ArrayList<String> randomCityLetters = new ArrayList<>();

    int totalPuan = 0;
    int questionPuan;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sureli_oyun);
        binding = ActivitySureliOyunBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sureliSehirSec();
        binding.puanTextView.setText("Puan : " + totalPuan);

    }


    public void sureliSehirSec(){

        questionPuan = 0 ;

        randomCity = "";
        randomHiddenCity = "";
        randomCityLetters.clear();

//===========================Create randomCity============================================
        randomCity = iller[ myRandom.nextInt(iller.length)];
//        randomCity = "ankara";
        randomCity = randomCity.toLowerCase();
//========================================================================================





//===============================Create randomHiddenCity====================================

        for(int i =0; i<randomCity.length();i++){
            randomHiddenCity += "*";
        }

        binding.textView4.setText(randomHiddenCity);
//========================================================================================



//=======================Create randomCityLetters==========================================
        for(int i = 0 ; i < randomCity.length();i++){
            Boolean check = true;
            String letter = randomCity.substring(i,(i+1));
            for (int j = 0;j<randomCityLetters.size();j++){
                if (randomCityLetters.get(j).toLowerCase().matches(letter.toLowerCase())){
                    check = false;
                }
            }
            if(check){
                randomCityLetters.add(letter);
            }
        }
//========================================================================================


//========================================================================================
         questionPuan = randomCityLetters.size() ;
//========================================================================================


    }

    public void sureliOyunHarfAL (View view){
        String randomLetter = randomCityLetters.get(myRandom.nextInt(randomCityLetters.size()));
        randomCityLetters.remove(randomLetter);
        for(int i=0 ; i<randomCity.length() ; i ++){
            if(randomCity.substring(i,(i+1)).matches(randomLetter)){
                System.out.println(randomCity.substring(i,(i+1)));
                randomHiddenCity = randomHiddenCity.substring(0,i) + randomLetter + randomHiddenCity.substring((i+1),randomHiddenCity.length());
            }
        }
        binding.textView4.setText(randomHiddenCity.toUpperCase());

        questionPuan--;

        System.out.println(questionPuan);
    }

    public void sureliOyunTahminEt(View view){
        String tahminText = binding.editTextText2.getText().toString().toLowerCase();

        if(tahminText.matches(randomCity)){
            Toast.makeText(this, "Doğru Tahmin", Toast.LENGTH_SHORT).show();
            sureliSehirSec();
//            totalPuan = totalPuan + questionPuan;
            System.out.println("total Puan : " + totalPuan);
            System.out.println("questionPuan : " +questionPuan);
            binding.puanTextView.setText("Puan : " + questionPuan);
        }else{
            Toast.makeText(this, "Yanlış Tahmin", Toast.LENGTH_SHORT).show();
        }

    }

    public void goToMainPage(View view){
        Intent goToMainPage = new Intent(this, MainActivity.class);
        startActivity(goToMainPage);
    }
}