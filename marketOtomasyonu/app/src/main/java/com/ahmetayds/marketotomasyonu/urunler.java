package com.ahmetayds.marketotomasyonu;

import androidx.annotation.NonNull;
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

    int counter = 0;

    public ActivityUrunlerBinding binding;

    ArrayList<Integer> idler = new ArrayList<>();
    ArrayList<String> urunAdlari = new ArrayList<>();
    ArrayList<String> urunFiyatlari = new ArrayList<>();
    ArrayList<String> urunStoklari = new ArrayList<>();
    ArrayList<String> yazilacakIfadeler = new ArrayList<>();

    ArrayList<byte[]> urunGorselleri = new ArrayList<>();


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
            int urunFiyatiX = imlec.getColumnIndex("urunFiyati");
            int stokAdediX = imlec.getColumnIndex("stokAdedi");

            int gorselX = imlec.getColumnIndex("gorsel");




            while(imlec.moveToNext()){

                counter += 1;

                idler.add(imlec.getInt(idX));
                urunAdlari.add(imlec.getString(urunAdiX));
                yazilacakIfadeler.add(counter + "-" + imlec.getString(urunAdiX));


                urunStoklari.add(Integer.toString(imlec.getInt(stokAdediX)));
                urunFiyatlari.add(imlec.getString(urunFiyatiX));

                urunGorselleri.add(imlec.getBlob(gorselX));


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

                String gidecekUrunAdi = urunAdlari.get(position);
                String gidecekUrunFiyati = urunFiyatlari.get(position);
                String gidecekStogu = urunStoklari.get(position);

                Integer gidecekId = idler.get(position);

                byte[] gidecekUrunGorseli = urunGorselleri.get(position);

                Intent sayfayaGit = new Intent(urunler.this, urunDetay.class);

                sayfayaGit.putExtra("gidecekUrunId" , gidecekId);
                sayfayaGit.putExtra("urunAdi",gidecekUrunAdi);
                sayfayaGit.putExtra("gidecekUrunFiyati",gidecekUrunFiyati);
                sayfayaGit.putExtra("gidecekStogu",gidecekStogu);
                sayfayaGit.putExtra("gidecekUrunGorseli", gidecekUrunGorseli);
                sayfayaGit.putExtra("gelisSebebi",true);

                startActivity(sayfayaGit);
            }
        });

    }




    public void urunKaydet(View view){
        Intent urunEkle = new Intent(this, urunDetay.class);
        urunEkle.putExtra("gelisSebebi","urunEkle");
        startActivity(urunEkle);
    }
    public void yeniUrun(View view){
        startActivity(new Intent(this, urunDetay.class));
    }
    public void cıkısYap(View view){
        startActivity(new Intent(this, MainActivity.class));
    }


    public void toast(String myString,Boolean isShort){
        if (isShort){
            Toast.makeText(this, myString, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, myString, Toast.LENGTH_LONG).show();
        }
    }

}