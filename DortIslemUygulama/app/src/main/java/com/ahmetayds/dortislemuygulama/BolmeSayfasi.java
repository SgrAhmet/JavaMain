package com.ahmetayds.dortislemuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BolmeSayfasi extends AppCompatActivity {

    Random myRandom = new Random();
    int skor = 0;

    TextView skorTextView;
    TextView soruTextView;
    EditText cevapEditText;

    int sayi1;
    int sayi2;
    int kat;
    int cevap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolme_sayfasi);

        skorTextView = findViewById(R.id.textView);
        soruTextView = findViewById(R.id.textView2);
        cevapEditText = findViewById(R.id.editTextNumber);

        skorTextView.setText("Skor : " + skor);

        sayi1 = myRandom.nextInt(50) + 1;
        kat =  myRandom.nextInt(5) + 1;
        sayi2 =  sayi1 * kat;

        cevap = sayi2 / sayi1;
        soruTextView.setText(sayi2 + " / "+sayi1+ " = ? ");
    }

    public void islem(View view){

        if(cevapEditText.getText().toString().matches("")){
//            Toast.makeText(getApplicationContext(),"Lütfen Cevap Girin", Toast.LENGTH_LONG).show();
        }else{

            if(Integer.parseInt(cevapEditText.getText().toString()) == cevap){
                skor++;
                skorTextView.setText("Skor : " + skor);

                sayi1 = myRandom.nextInt(50) + 1;
                kat =  myRandom.nextInt(5) + 1;
                sayi2 =  sayi1 * kat;

                cevap = sayi2 / sayi1;
                soruTextView.setText(sayi2 + " / "+sayi1+ " = ? ");
                cevapEditText.setText("");
            }else{
//                Toast.makeText(getApplicationContext(),"Yanlış Cevap Girdiniz", Toast.LENGTH_LONG).show();
                skor--;
                skorTextView.setText("Skor : " + skor);
                sayi1 = myRandom.nextInt(50) + 1;
                kat =  myRandom.nextInt(5) + 1;
                sayi2 =  sayi1 * kat;
                cevap = sayi2 / sayi1;
                soruTextView.setText(sayi2 + " / "+sayi1+ " = ? ");
                cevapEditText.setText("");
            }


        }

    }

    public void anaSayfa(View view){
        Intent anaSayfa = new Intent(this,MainActivity.class);
        startActivity(anaSayfa);
    }

}