package com.ahmetayds.veriatma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class NotlarSayfasi extends AppCompatActivity {

    EditText editTextTextMultiLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar_sayfasi);

        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);

        ArrayList gelenVeri1 = getIntent().getStringArrayListExtra("isimListe");
        ArrayList gelenveri2 = getIntent().getIntegerArrayListExtra("notListe");


        for(int i = 0 ; i < gelenVeri1.size();i++){
            editTextTextMultiLine.setText(editTextTextMultiLine.getText().toString()  + gelenVeri1.get(i)   + "  "+ gelenveri2.get(i)+ "\n");
        }
    }

    public void ilkSayfayaGecis(View view){
        Intent ilkSayfa = new Intent(this, MainActivity.class);
        startActivity(ilkSayfa);
    }

}