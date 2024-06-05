package com.ahmetayds.sayac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView sayacText;
    EditText editTextNumber;
    Button button;

    boolean toogle = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void islem(View view){
              sayacText = findViewById(R.id.sayacText);
              editTextNumber = findViewById(R.id.editTextNumber);
        if(editTextNumber.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(),"Lütfen Süre Girişi Yapınız",Toast.LENGTH_LONG).show();
        }else{
            if(!toogle){
                int sure = (Integer.parseInt(editTextNumber.getText().toString())) * 1000;
                new CountDownTimer(sure,1000){
                    @Override
                    public void onTick(long milisUntilFinshed){

                        long sure =(milisUntilFinshed/1000);
                        long saniye = 0;
                        long dakika = 0 ;
                        long saat = 0;

                        while(sure >= 60){
                            sure = sure - 60;
                            dakika++;
                        }
                        saniye = sure;

                        while(dakika >=60){
                            dakika = dakika - 60;
                            saat++;
                        }




//                        sayacText.setText("Kalan Süre : " +(sure+1));
                        sayacText.setText(saat + " : " +dakika + " : " + saniye);
                    }
                    @Override
                    public void onFinish(){
                        sayacText.setText("Süre Bitti");
                        toogle = false;
                    }
                }.start();
                toogle = true;
            }else{
                Toast.makeText(getApplicationContext(),"Süre Henüz Bitmedi",Toast.LENGTH_LONG).show();
            }
        }



//                button =findViewById(R.id.button);
//                button.setEnabled(false);
//
//                sayacText = findViewById(R.id.sayacText);
//                editTextNumber = findViewById(R.id.editTextNumber);
//                int sure = (Integer.parseInt(editTextNumber.getText().toString())) * 1000;
//                new CountDownTimer(sure,1000){
//                    @Override
//                    public void onTick(long milisUntilFinshed){
//                        sayacText.setText("Kalan Süre : " + (milisUntilFinshed/1000));
//                    }
//                    @Override
//                    public void onFinish(){
//                        sayacText.setText("Süre Bitti");
//                        button.setEnabled(true);
//                    }
//                }.start();




    }
}