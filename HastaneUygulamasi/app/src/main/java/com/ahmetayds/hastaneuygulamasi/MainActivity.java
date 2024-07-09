package com.ahmetayds.hastaneuygulamasi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmetayds.hastaneuygulamasi.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private FirebaseAuth auth;
    public FirebaseFirestore firestore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();



        TextView textView = findViewById(R.id.textView6);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        yukleme();

    }



    public void giris(View view){
        String mail = binding.mailText.getText().toString();
        String sifre = binding.sifreText.getText().toString();

        if(mail.equals("") || sifre.equals("")){
            toast("Email yada Şifre Boş Bırakılamaz");
        }else{
//            toast("Mail : " + mail + "    " + "Şifre : " + sifre);

            auth.signInWithEmailAndPassword(mail,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    toast("Giriş Başarılı");
                    startActivity(new Intent(MainActivity.this, hastaAnaSayfa.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
//                    toast("Kulanıcı Adı yada Şifre Yanlış");
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }

    }


    public void doktorHastaneKayıt(){
        String[] hastaneler ={"Ankara Üniversitesi Hastanesi" , "Gazi Üniversitesi Hastanesi","Hacettepe Üniversitesi Hastanesi","İbn-i Sina Hastanesi"};
        String[] bolumler = {"Ortopedi","Nöroloji","Dermatoloji","Dahiliye","Psikiyatri"};
        String[] doktorlar = {
                "Prof. Dr. Ayşe Yılmaz", "Op. Dr. Mehmet Aksoy", "Doç. Dr. Zeynep Kaya",
                "Uzm. Dr. Mustafa Demir", "Dr. Elif Korkmaz", "Prof. Dr. Ali Çelik",
                "Uzm. Dr. Fatma Öztürk", "Dr. Emre Yıldırım", "Doç. Dr. Aylin Şahin",
                "Prof. Dr. Taksim Delisi Cenk", "Prof. Dr. Nihan Akın", "Uzm. Dr. Mahmut Tuncer",
                "Dr. Melis Çetin", "Prof. Dr. Ertan Yılmaz", "Doç. Dr. Sema Başar",
                "Op. Dr. Serkan Yıldız", "Uzm. Dr. Ayşe Nur", "Dr. Mehmet Yılmaz",
                "Prof. Dr. Selin Demir", "Op. Dr. Yıldız Tilbe "
        };

        for(int i = 0;i<doktorlar.length;i++){

            HashMap<String,Object> veriKaydet = new HashMap<>();
            veriKaydet.put("doktorAdi",doktorlar[i]);
            veriKaydet.put("hastane",hastaneler[i%hastaneler.length]);
            veriKaydet.put("bolum",bolumler[i%bolumler.length]);

//            System.out.println("=========   " + i + "  ===========");
//            System.out.println("doktor adı : " + doktorlar[i]);
//            System.out.println("hastaneler : " + hastaneler[i%hastaneler.length]);
//            System.out.println("bolum  : " + bolumler[i%bolumler.length]);


            firestore.collection("doktorlar").add(veriKaydet).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    toast("Kaydedilemeyen Doktor Mevcut");
                    finish();
                }
            });

        }



    }

    public void yukleme(){

        firestore.collection("doktorlar").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null){
                    Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }
                int i = 0;
                for(DocumentSnapshot dokuman : value.getDocuments()){
                    i++;

//  ============================??????????????????????????????============================
                }

                if(i == 0){
                    doktorHastaneKayıt();
                }
            }
        });

    }

    public void kayit(View view){
        startActivity(new Intent(this, kayitSayfasi.class));
    }



    public void toast(String myString){
        Toast.makeText(this, myString, Toast.LENGTH_SHORT).show();
    }


}



























