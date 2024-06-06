package com.ahmetayds.dortislemuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ToplamaSayfasi extends AppCompatActivity {

    Random myRandom = new Random();
    int skor = 0;

    TextView skorTextView;
    TextView soruTextView;
    EditText cevapEditText;

    ImageView wrongImg;
    ImageView correctImg;
    Button cevaplaButton;


    int sayi1;
    int sayi2;
    int cevap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplama_sayfasi);

        skorTextView = findViewById(R.id.textView);
        soruTextView = findViewById(R.id.textView2);
        cevapEditText = findViewById(R.id.editTextNumber);
        wrongImg = findViewById(R.id.wrongImg);
        correctImg= findViewById(R.id.correctImg);
        cevaplaButton =findViewById(R.id.cevaplaButton);

        skorTextView.setText("Skor : " + skor);

        sayi1 = myRandom.nextInt(10);
        sayi2 = myRandom.nextInt(10);

        cevap = sayi1 + sayi2;
        soruTextView.setText(sayi1 + " + "+sayi2+ " = ? ");
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
                cevap = sayi1 + sayi2;
                soruTextView.setText(sayi1 + " + "+sayi2+ " = ? ");
                cevapEditText.setText("");

                cevaplaButton.setEnabled(true);

                soruTextView.setVisibility(View.INVISIBLE);

                new CountDownTimer(700,100){

                    boolean toogle = false;
                    @Override
                    public void onTick(long milisUntilFinshed){

                        if(toogle){
                            correctImg.setVisibility(View.VISIBLE);
                            skorTextView.setVisibility(View.INVISIBLE);
                            toogle = false;
                        }else{
                            correctImg.setVisibility(View.INVISIBLE);
                            skorTextView.setVisibility(View.VISIBLE);
                            toogle = true;
                        }

                    }
                    @Override
                    public void onFinish(){
                        correctImg.setVisibility(View.INVISIBLE);
                        skorTextView.setVisibility(View.VISIBLE);
                        cevaplaButton.setEnabled(true);
                        soruTextView.setVisibility(View.VISIBLE);

                    }
                }.start();





            }else{

                skor--;
                skorTextView.setText("Skor : " + skor);
                sayi1 = myRandom.nextInt(10);
                sayi2 = myRandom.nextInt(10);
                cevap = sayi1 + sayi2;
                soruTextView.setText(sayi1 + " + "+sayi2+ " = ? ");
                cevapEditText.setText("");

                cevaplaButton.setEnabled(true);

                soruTextView.setVisibility(View.INVISIBLE);


                new CountDownTimer(700,100){

                    boolean toogle = false;
                    @Override
                    public void onTick(long milisUntilFinshed){

                        if(toogle){
                            wrongImg.setVisibility(View.VISIBLE);
                            skorTextView.setVisibility(View.INVISIBLE);
                            toogle = false;
                        }else{
                            wrongImg.setVisibility(View.INVISIBLE);
                            skorTextView.setVisibility(View.VISIBLE);
                            toogle = true;
                        }

                    }
                    @Override
                    public void onFinish(){
                        skorTextView.setVisibility(View.VISIBLE);
                        wrongImg.setVisibility(View.INVISIBLE);
                        cevaplaButton.setEnabled(true);
                        soruTextView.setVisibility(View.VISIBLE);

                    }
                }.start();



            }


        }

    }



    public void anaSayfa(View view){
            Intent anaSayfa = new Intent(this,MainActivity.class);
            startActivity(anaSayfa);
    }
}