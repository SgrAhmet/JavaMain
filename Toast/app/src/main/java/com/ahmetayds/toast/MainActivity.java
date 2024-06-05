package com.ahmetayds.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText myEditText;
    TextView myTextView ;
    TextView biggerTextView;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = findViewById(R.id.myEditText);
        myTextView = findViewById(R.id.myTextView);
        myButton = findViewById(R.id.myButton);
        biggerTextView = findViewById(R.id.biggerTextView);

        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myTextView.setText(s.toString());
                myButton.setText(s.toString());
                biggerTextView.setText(s.toString());


            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


public void sonucIslem(View view){

    if(myEditText.getText().toString().matches("")){
        Toast.makeText(this,"Lütfen Not Girişi Yapınız!",Toast.LENGTH_SHORT).show();
    }else{

            if(Integer.parseInt(myEditText.getText().toString()) > 100){
                 Toast.makeText(this,"Notunuz 100'den Büyük Olamaz!",Toast.LENGTH_SHORT).show();
             }else{
                String message = "Notunuz : " + myEditText.getText().toString();
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
                System.out.println("deneme değişikliği");
            }

    }





}

}