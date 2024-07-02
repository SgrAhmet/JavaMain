package com.ahmetayds.marketotomasyonu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.ahmetayds.marketotomasyonu.databinding.ActivityUrunDetayBinding;

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
                Ssytem;
            }
        });




    }




    public void urunuKaydet (View view){

    }


    public void resimSec (View view){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

        }else{

        }



    }


    public void geriGit(View view){
        startActivity(new Intent(this, urunler.class));
    }
}