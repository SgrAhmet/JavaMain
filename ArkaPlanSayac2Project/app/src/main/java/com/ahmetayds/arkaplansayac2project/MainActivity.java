//package com.ahmetayds.arkaplansayac2project;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//
//    TextView sayacTextView;
//    TextView turTextView;
//    Button baslatButton;
//    Button turButton;
//    Button  durdurButton;
//    Button sifirlaButton;
//
//    Runnable runnable;
//    Handler handler;
//
//
//    int miliSecond = 0;
//    int second = 0;
//    int minute = 0;
//
//    ArrayList<String> turListe = new ArrayList<String>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        baslatButton=findViewById(R.id.baslatButton);
//        turButton=findViewById(R.id.turButton);
//        durdurButton=findViewById(R.id.durdurButton);
//        sifirlaButton =findViewById(R.id.sifirlaButton);
//        sayacTextView = findViewById(R.id.sayacTextView);
//        turTextView= findViewById(R.id.turTextView);
//
//
//        durdurButton.setEnabled(false);
//        turButton.setEnabled(false);
//        sifirlaButton.setEnabled(false);
//
//        sayacTextView.setText("0"+minute+" : 0"+ second + " . " +miliSecond);
//        turTextView.setText("");
//    }
//
//
//    public void baslat(View view){
//        baslatButton.setEnabled(false);
//        durdurButton.setEnabled(true);
//        turButton.setEnabled(true);
//        sifirlaButton.setEnabled(false);
//
//        baslatButton.setText("Devam et");
//
//
//        handler = new Handler();
//
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                handler.postDelayed(runnable,10);
//                second++;
//                if(second > 60){
//                    minute++;
//                    second = second - 60;
//                }
//                if(second < 10){
//                    sayacTextView.setText("0"+minute+ " : 0"+ second);
//                }else{
//                    if(minute < 10){
//                        sayacTextView.setText("0"+minute+ " : "+ second);
//                    }else{
//                        sayacTextView.setText(""+minute+ " : "+ second);
//                    }
//                }
//            }
//        };
//        handler.post(runnable);
//
//    }
//
//    public void tur(View view){
//        turTextView.setText("");
//        turListe.add(sayacTextView.getText().toString());
//        for (int i = 0; i< turListe.size();i++){
//            turTextView.setText(turTextView.getText().toString() + (i+1) + ".  "+ turListe.get(i) + "\n");
//        }
//    }
//
//    public void durdur(View view){
//        baslatButton.setEnabled(true);
//        durdurButton.setEnabled(false);
//        turButton.setEnabled(false);
//        sifirlaButton.setEnabled(true);
//
//
//        handler.removeCallbacks(runnable);
//    }
//
//    public void sıfırla(View view){
//        second = 0;
//        minute = 0;
//        sayacTextView.setText("0"+minute+" : 0"+ second);
//        handler.removeCallbacks(runnable);
//        sifirlaButton.setEnabled(false);
//
//        turTextView.setText("");
//        turListe.clear();
//
//        baslatButton.setText("Başlat");
//
//
//    }
//
//}



package com.ahmetayds.arkaplansayac2project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView sayacTextView;
    TextView turTextView;
    Button baslatButton;
    Button turButton;
    Button  durdurButton;
    Button sifirlaButton;

    Runnable runnable;
    Handler handler;


    int miliSecond = 0;
    int second = 0;
    int minute = 0;

    ArrayList<String> turListe = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baslatButton=findViewById(R.id.baslatButton);
        turButton=findViewById(R.id.turButton);
        durdurButton=findViewById(R.id.durdurButton);
        sifirlaButton =findViewById(R.id.sifirlaButton);
        sayacTextView = findViewById(R.id.sayacTextView);
        turTextView= findViewById(R.id.turTextView);



        durdurButton.setEnabled(false);
        turButton.setEnabled(false);
        sifirlaButton.setEnabled(false);

        sayacTextView.setText("0"+minute+" : 0"+ second + " . 0" +miliSecond);
        turTextView.setText("");



    }


    public void baslat(View view){
        baslatButton.setEnabled(false);
        durdurButton.setEnabled(true);
        turButton.setEnabled(true);
        sifirlaButton.setEnabled(false);

        baslatButton.setText("Devam et");


        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,10);
                miliSecond++;
                if(miliSecond > 59){
                    second++;
                    miliSecond = miliSecond - 60;
                }

                if(second > 59){
                    minute++;
                    second = second -60;
                }

                String miliSecondText ;
                String secondText ;
                String minuteText ;

                if(miliSecond < 10){
                    miliSecondText = "0" + miliSecond;
                }else{
                    miliSecondText = ""+ miliSecond;
                }

                if(second < 10){
                    secondText = "0" + second;
                }else{
                    secondText = ""+ second;
                }

                if(minute < 10){
                    minuteText = "0" + minute;
                }else{
                    minuteText = ""+ minute;
                }



                sayacTextView.setText(""+minuteText+" : "+ secondText + " . " +miliSecondText);


            }
        };
        handler.post(runnable);

    }

    public void tur(View view){
        turTextView.setText("");
        turListe.add(sayacTextView.getText().toString());
        for (int i = 0; i< turListe.size();i++){
            turTextView.setText(turTextView.getText().toString() + (i+1) + ".  "+ turListe.get(i) + "\n");
        }

        if(turListe.size() >14){
            turTextView.setTextSize(10);
        }

    }

    public void durdur(View view){
        baslatButton.setEnabled(true);
        durdurButton.setEnabled(false);
        turButton.setEnabled(false);
        sifirlaButton.setEnabled(true);


        handler.removeCallbacks(runnable);
    }

    public void sıfırla(View view){
        second = 0;
        minute = 0;
        miliSecond= 0;
        sayacTextView.setText("0"+minute+" : 0"+ second + " . 0" +miliSecond);
        handler.removeCallbacks(runnable);
        sifirlaButton.setEnabled(false);

        turTextView.setText("");
        turListe.clear();

        baslatButton.setText("Başlat");
        turTextView.setTextSize(24);


    }

}