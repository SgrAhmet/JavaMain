package com.ahmetayds.marketotomasyonu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.marketotomasyonu.databinding.ActivityUrunDetayBinding;
import com.google.android.material.snackbar.Snackbar;

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

                if(o){
// ====================İZİN VERİLDİ=============================================
                   Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   galeriLauncher.launch(galeriyeGit);
                }else {
// ====================İZİN VERİLMEDİ===========================================
                    Toast.makeText(urunDetay.this, "Galeri İzini Verilmemiştir", Toast.LENGTH_SHORT).show();
                }
//                Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                galeriLauncher.launch(galeriyeGit);
            }
        });




    }




    public void urunuKaydet (View view){

    }


    public void resimSec (View view){

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


//    public Bitmap resimKucult(Bitmap gorsel,int maximumBoyut) {
//        return ;
//    }

    public void geriGit(View view){
        startActivity(new Intent(this, urunler.class));
    }
}