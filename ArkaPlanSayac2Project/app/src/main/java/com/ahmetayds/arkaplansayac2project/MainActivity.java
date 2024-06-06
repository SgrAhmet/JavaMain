package com.ahmetayds.arkaplansayac2project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


    int number = 0;

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

        sayacTextView.setText("Süre : "+ number);
        turTextView.setText("");
    }


    public void baslat(View view){
        baslatButton.setEnabled(false);
        durdurButton.setEnabled(true);
        turButton.setEnabled(true);
        sifirlaButton.setEnabled(false);


        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,1000);
                number++;
                sayacTextView.setText("Süre : "+ number);
            }
        };
        handler.post(runnable);

    }

    public void tur(View view){
        turTextView.setText("");
        turListe.add(Integer.toString(number));
        for (int i = 0; i< turListe.size();i++){
//            turTextView.setText((i+1) + ". "+ turListe.get(i) + "\n");

            turTextView.setText(turTextView.getText().toString() + (i+1) + ".  "+ turListe.get(i) + "\n");
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
        number = 0;
        sayacTextView.setText("Süre : "+ number);
        handler.removeCallbacks(runnable);
        sifirlaButton.setEnabled(false);

        turTextView.setText("");
        turListe.clear();

    }

}