package com.ahmetayds.marketotomasyonu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.Toast;

import com.ahmetayds.marketotomasyonu.databinding.ActivityUrunDetayBinding;
import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;
import java.security.Permission;

public class urunDetay extends AppCompatActivity {

    ActivityResultLauncher<Intent> galeriLauncher ;
//    ActivityResultLauncher<Permission> izinLauncher ;
    ActivityResultLauncher<String> izinLauncher ;

    Bitmap secilenGorsel;

    public ActivityUrunDetayBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_urun_detay);

        binding = ActivityUrunDetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        galeriLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK){
                    Intent galeridenGelen = o.getData();
                    if (galeridenGelen != null){
                        Uri gorselData = galeridenGelen.getData();
                        try {
                            if(Build.VERSION.SDK_INT >= 28){
                                ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(),gorselData);
                                secilenGorsel = ImageDecoder.decodeBitmap(source);
                                binding.gorsel.setImageBitmap(secilenGorsel);
                            }else{
                                secilenGorsel = MediaStore.Images.Media.getBitmap(getContentResolver(),gorselData);
                                binding.gorsel.setImageBitmap(secilenGorsel);
                            }
                        }catch (Exception e){
                            Toast.makeText(urunDetay.this, "Görsel Seçerken Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });



        izinLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean o) {

//                if(o){
//// ====================İZİN VERİLDİ=============================================
//                   Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                   galeriLauncher.launch(galeriyeGit);
//                }else {
//// ====================İZİN VERİLMEDİ===========================================
//                    Toast.makeText(urunDetay.this, "Galeri İzini Verilmemiştir", Toast.LENGTH_SHORT).show();
//                }
                Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galeriLauncher.launch(galeriyeGit);
            }
        });





        Intent gelenVeri = getIntent();
        Boolean gelisSebebi = getIntent().getBooleanExtra("gelisSebebi",false);

        if (gelisSebebi){
//==================================================================================================
            String gelenUrunAdi =gelenVeri.getStringExtra("urunAdi");
            String gelenUrunFiyati =gelenVeri.getStringExtra("gidecekUrunFiyati");
            String gelenStok =gelenVeri.getStringExtra("gidecekStogu");
//==================================================================================================
            binding.urunAdiText.setText(gelenUrunAdi);
            binding.fiyatText.setText(gelenUrunFiyati);
            binding.stokText.setText(gelenStok);
//==================================================================================================
            byte[] gelenUrunGorseli = getIntent().getByteArrayExtra("gidecekUrunGorseli");
            Bitmap olusanGorsel = BitmapFactory.decodeByteArray(gelenUrunGorseli,0,gelenUrunGorseli.length);
            binding.gorsel.setImageBitmap(olusanGorsel);
//==================================================================================================
            binding.button3.setVisibility(View.INVISIBLE);
//==================================================================================================
            binding.urunAdiText.setEnabled(false);
            binding.fiyatText.setEnabled(false);
            binding.stokText.setEnabled(false);

            binding.gorsel.setAlpha(150);
//==================================================================================================

            binding.deleteButton.setVisibility(View.VISIBLE);
            binding.editButton.setVisibility(View.VISIBLE);


        }else {
//            toast("urunlerden gelmedi",true);

        }


    }






    public void resimSec (View view){

        Intent gelenVeri = getIntent();
        Boolean gelisSebebi = gelenVeri.getBooleanExtra("gelisSebebi",false);

        if(!gelisSebebi){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                    // İzin verilmemişse buraya girilecek kod
                    Snackbar.make(view,"Galeri İzni Vermeniz Gerekmektedir.",Snackbar.LENGTH_INDEFINITE).setAction("İzin Ver",new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            izinLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);
                        }
                    }).show();
                }else{
                    // İzin verilmişse buraya girilecek kod
                    Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    galeriLauncher.launch(galeriyeGit);
                }
            }else{
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    // İzin verilmemişse buraya girilecek kod

                    Snackbar.make(view,"Galeri İzni Vermeniz Gerekmektedir.",Snackbar.LENGTH_INDEFINITE).setAction("İzin Ver",new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            izinLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
                        }
                    }).show();
                }else{
                    // İzin verilmişse buraya girilecek kod
                    Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    galeriLauncher.launch(galeriyeGit);

                }

            }
        }





    }


    public Bitmap resimKucult(Bitmap gorsel,int maximumBoyut) {
        int genislik = gorsel.getWidth();
        int yukseklik = gorsel.getHeight();
        float oran =(float) genislik / (float) yukseklik;

        if(genislik>yukseklik){
// ====================Yatay Resim
            genislik = maximumBoyut;
            yukseklik=(int)(genislik/oran);
        }else{
// ====================Dikey Resim

            yukseklik = maximumBoyut;
            genislik=(int)(yukseklik/oran);

        }

        return  Bitmap.createScaledBitmap(gorsel,genislik,yukseklik,true);
    }




    public void urunuKaydet (View view){

        String urunAdi = binding.urunAdiText.getText().toString();
        int fiyat = Integer.parseInt(binding.fiyatText.getText().toString());
        int stok = Integer.parseInt(binding.stokText.getText().toString());

        Bitmap kucukResim = resimKucult(secilenGorsel,300);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        kucukResim.compress(Bitmap.CompressFormat.PNG,50,outputStream);
        byte[] resimDizisi = outputStream.toByteArray();


        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("market_db", MODE_PRIVATE,null);
        String sql = "INSERT INTO urunler(urunAdi,urunFiyati,stokAdedi,gorsel) VALUES(?,?,?,?)";
        SQLiteStatement sqlDurum = veriTabani.compileStatement(sql);



            sqlDurum.bindString(1, urunAdi);
            sqlDurum.bindLong(2, fiyat);
            sqlDurum.bindLong(3, stok);
            sqlDurum.bindBlob(4, resimDizisi);

            // Sorguyu çalıştırma
            sqlDurum.execute();

//            Toast.makeText(this, "Ürün başarıyla eklendi", Toast.LENGTH_SHORT).show();

            toast("Ürün Başarıyla Eklendi",true);

            Intent urunlereGit = new Intent(urunDetay.this,urunler.class);
            urunlereGit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(urunlereGit);



        }catch (Exception e){
            Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
        }





//        if(urunAdi.matches("") || (binding.fiyatText.getText().toString().matches("") ||binding.stokText.getText().toString().matches("") )){
//            Toast.makeText(this, "Hiçbir Alan Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
//        }



    }


    public void urunEdit(View view){
        toast("edit urun", true);
    }

    public void urunSil(View view){
        Intent gelenVeri = getIntent();
        Integer gidecekId = gelenVeri.getIntExtra("gidecekUrunId",-1);

        toast(String.valueOf(gidecekId),true);


        try {

            SQLiteDatabase veriTabani = this.openOrCreateDatabase("market_db" ,MODE_PRIVATE,null);
            veriTabani.execSQL("DELETE FROM urunler WHERE id = " + gidecekId );

            Intent sayfayaGit = new Intent(this, urunler.class);
            startActivity(sayfayaGit);

        }catch (Exception e){
            toast("Bir Hata Oluştu!",true);
        }


    }

    public void geriGit(View view){
        startActivity(new Intent(this, urunler.class));
    }


    public void toast(String myString, @NonNull Boolean isShort){
        if (isShort){
            Toast.makeText(this, myString, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, myString, Toast.LENGTH_LONG).show();
        }
    }


}