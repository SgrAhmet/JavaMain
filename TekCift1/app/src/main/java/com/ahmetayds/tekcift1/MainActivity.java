package com.ahmetayds.tekcift1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);

    }


    public void islem(View view){
        int number = Integer.parseInt(editTextNumber.getText().toString());
        ArrayList myArrayList = new ArrayList<Integer>();
        for(int i = 1 ; i <= number ; i++){
            if(i % 2 == 0){
                myArrayList.add(i);
            }
        }
        textView.setText(myArrayList.toString());
    }

    public void islem2(View view){
        int number = Integer.parseInt(editTextNumber.getText().toString());
        ArrayList myArrayList = new ArrayList<Integer>();

        for(int i = 1 ; i <= number ; i++){
            if(i % 2 != 0){
                myArrayList.add(i);
            }
        }

        textView.setText(myArrayList.toString());

    }


    public void islem3(View view){

        if(editTextNumber.getText().toString().matches("")){
            textView.setText("Lütfen Sayı Giriniz");

        }else{
            int number = Integer.parseInt(editTextNumber.getText().toString());
            ArrayList myArrayList = new ArrayList<Integer>();

            for(int i = 1 ; i <= number ; i++){
                int count = 0;

                for (int j = 1 ; j<= i ; j++){
                    if(i % j == 0){
                        count++;
                    }

                }
                if(count == 2){
                    myArrayList.add(i);
                }
            }

            textView.setText(myArrayList.toString());


        }

    }

}