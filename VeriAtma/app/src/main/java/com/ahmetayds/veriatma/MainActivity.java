package com.ahmetayds.veriatma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ArrayList<String> myNameList = new ArrayList<String>();
    ArrayList<Integer> myNoteList = new ArrayList<Integer>();

    EditText IsimEditText;
    EditText notEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IsimEditText = findViewById(R.id.IsimEditText);
        notEditText = findViewById(R.id.notEditText);
    }

    public void listeEkle(View view){

        if(IsimEditText.getText().toString().matches("") || notEditText.getText().toString().matches("")){
            Toast.makeText(this, "Lütfen Veri Girişi Yapınız", Toast.LENGTH_SHORT).show();
        }else{
            String isim =IsimEditText.getText().toString();
            int note = Integer.parseInt(notEditText.getText().toString()) ;
            myNameList.add(isim);
            myNoteList.add(note);
            System.out.println(myNameList);
            System.out.println(myNoteList);
            Toast.makeText(this, isim +  " kişisi eklendi", Toast.LENGTH_SHORT).show();
        }
        IsimEditText.setText("");
        notEditText.setText("");
    }

    public void ikinciSayfayagecis(View view){
        Intent ikinciSayfa=new Intent(this, NotlarSayfasi.class);
        ikinciSayfa.putExtra("isimListe",myNameList);
        ikinciSayfa.putExtra("notListe",myNoteList);
        startActivity(ikinciSayfa);
    }
}