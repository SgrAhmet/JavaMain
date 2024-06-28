package com.ahmetayds.kbs_uygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listele extends AppCompatActivity {

    ListView listView;
    ArrayList<Integer> idler = new ArrayList<>();
    ArrayList<String> isimler = new ArrayList<>();
    ArrayList<String> idlerveisimler = new ArrayList<>();
    String idveisim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        listView = findViewById(R.id.ogrenciler);

        try {
            SQLiteDatabase veriTabanı = this.openOrCreateDatabase("ogrenciler",MODE_PRIVATE,null);

            Cursor imlec = veriTabanı.rawQuery("SELECT * FROM ogrenciler",null);
            int idX = imlec.getColumnIndex("id");
            int isimX = imlec.getColumnIndex("isim");

            while (imlec.moveToNext()){
                idler.add(imlec.getInt(idX));
                isimler.add(imlec.getString(isimX));
                idveisim = String.valueOf(imlec.getInt(idX)+"-"+imlec.getString(isimX));
                idlerveisimler.add(idveisim);

            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,idlerveisimler);
            listView.setAdapter(adapter);
            imlec.close();



        }catch (Exception e){

        }

    }





    public void geriGit(View view){
        idler.clear();
        isimler.clear();
        idlerveisimler.clear();

    }

}