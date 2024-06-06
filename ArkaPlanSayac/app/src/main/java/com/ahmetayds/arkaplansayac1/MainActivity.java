package com.ahmetayds.arkaplansayac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sayacText;
    Button startButton;
    Button stopButton;
    Runnable runnable;
    Handler handler;
    int number = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayacText = findViewById(R.id.sayacText);
        stopButton = findViewById(R.id.stopButton);
        startButton = findViewById(R.id.startButton);
        sayacText.setText("Süre : "+ number);

    }

    public void sayaciBaslat(View view){
        startButton.setEnabled(false);
        handler = new Handler();
        runnable = new Runnable(){

            @Override
            public void run(){
                number++;
                sayacText.setText("Süre : "+number);
                handler.postDelayed(runnable,1000);
            }

        };
        handler.post(runnable);
    }

    public void sayaciDurdur(View view){


         handler.removeCallbacks(runnable);
//        number = 0;
        startButton.setEnabled(true);


    }


}