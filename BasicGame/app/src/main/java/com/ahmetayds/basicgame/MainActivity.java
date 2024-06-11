package com.ahmetayds.basicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void goToVersion1(View view){
        Intent sayfa1 = new Intent(this, Version1.class) ;
        startActivity(sayfa1);
    }

    public void goToVersion2(View view){
        Intent sayfa2 = new Intent(this, Version2.class) ;
        startActivity(sayfa2);
    }


}
