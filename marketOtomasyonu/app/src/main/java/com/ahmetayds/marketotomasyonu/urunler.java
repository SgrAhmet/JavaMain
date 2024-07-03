package com.ahmetayds.marketotomasyonu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ahmetayds.marketotomasyonu.databinding.ActivityUrunlerBinding;

import java.util.ArrayList;

public class urunler extends AppCompatActivity {

    public ActivityUrunlerBinding binding;

    ArrayList<Integer> idler = new ArrayList<>();
    ArrayList<String> urunAdlari = new ArrayList<>();
    ArrayList<String> yazilacakIfadeler = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_urunler);

        binding = ActivityUrunlerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("market_db" , MODE_PRIVATE ,null);
            Cursor imlec = veriTabani.rawQuery("SELECT * FROM urunler",null);
            int idX = imlec.getColumnIndex("id");
            int urunAdiX = imlec.getColumnIndex("urunAdi");

            while(imlec.moveToNext()){
                idler.add(imlec.getInt(idX));
                urunAdlari.add(imlec.getString(urunAdiX));
                yazilacakIfadeler.add(imlec.getInt(idX) + "-" + imlec.getString(urunAdiX));
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,yazilacakIfadeler);
            binding.urunler.setAdapter(adapter);
            imlec.close();

        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
        }


        binding.urunler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String secilen = yazilacakIfadeler.get(position);
                String[] parcala = secilen.split("-");
                int gosterilecekUrün = Integer.parseInt(parcala[0]);
                Intent sayfayaGit = new Intent(urunler.this, urunDetay.class);
                sayfayaGit.putExtra("id",gosterilecekUrün);
                sayfayaGit.putExtra("gelisSebebi","urunGoster");
                startActivity(sayfayaGit);
            }
        });

    }


    public void yeniUrun(View view){
        startActivity(new Intent(this, urunDetay.class));
    }
    public void cıkısYap(View view){
        startActivity(new Intent(this, MainActivity.class));
    }



}