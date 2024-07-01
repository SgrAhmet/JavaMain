package com.ahmetayds.kbs_uygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class sil extends AppCompatActivity {


    ListView listView;
    ArrayList<Integer> idler = new ArrayList<>();
    ArrayList<String> isimler = new ArrayList<>();
    ArrayList<String> idlerveisimler = new ArrayList<>();
    String idveisim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sil);


        listView = findViewById(R.id.ogrenciler2);
        
        try {

            SQLiteDatabase veriTabanı = this.openOrCreateDatabase("ogrenciler",MODE_PRIVATE,null);

            Cursor imlec = veriTabanı.rawQuery("SELECT * FROM ogrenciler",null);
            int idx =imlec.getColumnIndex("id");
            int isimx =imlec.getColumnIndex("isim");


            while (imlec.moveToNext()){
                idler.add(imlec.getInt(idx));
                isimler.add(imlec.getString(isimx));
                idveisim = String.valueOf(imlec.getInt(idx)+"-"+imlec.getString(isimx));
                idlerveisimler.add(idveisim);

            }

            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,idlerveisimler);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String deger = idlerveisimler.get(position);
                    String[] parcala =deger.split("-");
                    int silinecek = Integer.parseInt(parcala[0]);
                    veriTabanı.execSQL("DELETE FROM ogrenciler WHERE id ="+silinecek+"");
                    Intent sayfayıYenile = new Intent(sil.this, sil.class);
                    startActivity(sayfayıYenile);

                }
            });



            imlec.close();

            
        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
        }

    }




    public void geriGit(View view){
        idler.clear();
        isimler.clear();
        idlerveisimler.clear();

        startActivity(new Intent(this, MainActivity.class));
    }

}