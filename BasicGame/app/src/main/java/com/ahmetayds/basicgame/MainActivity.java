package com.ahmetayds.basicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView2;

    int cookies = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2= findViewById(R.id.textView2);
        textView2.setText(""+cookies);
    }

    public void islem(View view){
        cookies++;
        textView2.setText(""+cookies);

    }
}
