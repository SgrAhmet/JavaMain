package com.ahmetayds.dortislemuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CikarmaSayfasi extends AppCompatActivity {

    Random myRandom = new Random();
    int skor = 0;

    TextView skorTextView;
    TextView soruTextView;
    EditText cevapEditText;

    int sayi1;
    int sayi2;
    int cevap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cikarma_sayfasi);

        skorTextView = findViewById(R.id.textView);
        soruTextView = findViewById(R.id.textView2);
        cevapEditText = findViewById(R.id.editTextNumber);

        skorTextView.setText("Skor : " + skor);

        sayi1 = myRandom.nextInt(10);
        sayi2 = myRandom.nextInt(10);

        cevap = sayi1 - sayi2;
        soruTextView.setText(sayi1 + " - "+sayi2+ " = ? ");

    }



    public void islem(View view){

        if(cevapEditText.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(),"Lütfen Cevap Girin", Toast.LENGTH_LONG).show();
        }else{

            if(Integer.parseInt(cevapEditText.getText().toString()) == cevap){
                skor++;
                skorTextView.setText("Skor : " + skor);
                sayi1 = myRandom.nextInt(10);
                sayi2 = myRandom.nextInt(10);
                cevap = sayi1 - sayi2;
                soruTextView.setText(sayi1 + " - "+sayi2+ " = ? ");
                cevapEditText.setText("");
            }else{
                Toast.makeText(getApplicationContext(),"Yanlış Cevap Girdiniz", Toast.LENGTH_LONG).show();
                skor--;
                skorTextView.setText("Skor : " + skor);
                sayi1 = myRandom.nextInt(10);
                sayi2 = myRandom.nextInt(10);
                cevap = sayi1 - sayi2;
                soruTextView.setText(sayi1 + " - "+sayi2+ " = ? ");
                cevapEditText.setText("");
            }


        }

    }

    public void anaSayfa(View view){
        Intent anaSayfa = new Intent(this,MainActivity.class);
        startActivity(anaSayfa);
    }
}