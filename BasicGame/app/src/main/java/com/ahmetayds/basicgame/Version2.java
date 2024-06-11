//package com.ahmetayds.basicgame;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.ImageView;
//
//import java.util.Random;
//
//public class Version2 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_version2);
//    }
//}

package com.ahmetayds.basicgame;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Random;

public class Version2 extends AppCompatActivity {


    TextView skor;
    TextView kalansure;
    int sayac = 0;
    int point;
    Random myRandom = new Random();

    Handler handler;
    Runnable runnable;

    Handler handler1;
    Runnable runnable1;

    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;

    ImageView ximageView0;
    ImageView ximageView1;
    ImageView ximageView2;
    ImageView ximageView3;
    ImageView ximageView4;
    ImageView ximageView5;
    ImageView ximageView6;
    ImageView ximageView7;
    ImageView ximageView8;

    Button Reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version2);

        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);

        ximageView0 = findViewById(R.id.ximageView0);
        ximageView1 = findViewById(R.id.ximageView1);
        ximageView2 = findViewById(R.id.ximageView2);
        ximageView3 = findViewById(R.id.ximageView3);
        ximageView4 = findViewById(R.id.ximageView4);
        ximageView5 = findViewById(R.id.ximageView5);
        ximageView6 = findViewById(R.id.ximageView6);
        ximageView7 = findViewById(R.id.ximageView7);
        ximageView8 = findViewById(R.id.ximageView8);

        kalansure =findViewById(R.id.kalanSure);

        skor = findViewById(R.id.skor);

        Reset = findViewById(R.id.Reset);

        imageView0.setVisibility(View.INVISIBLE);
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        imageView5.setVisibility(View.INVISIBLE);
        imageView6.setVisibility(View.INVISIBLE);
        imageView7.setVisibility(View.INVISIBLE);
        imageView8.setVisibility(View.INVISIBLE);

        ximageView0.setVisibility(View.INVISIBLE);
        ximageView1.setVisibility(View.INVISIBLE);
        ximageView2.setVisibility(View.INVISIBLE);
        ximageView3.setVisibility(View.INVISIBLE);
        ximageView4.setVisibility(View.INVISIBLE);
        ximageView5.setVisibility(View.INVISIBLE);
        ximageView6.setVisibility(View.INVISIBLE);
        ximageView7.setVisibility(View.INVISIBLE);
        ximageView8.setVisibility(View.INVISIBLE);

        Reset.setVisibility(View.INVISIBLE);


        kalansure.setText("Kalan Süre : " + ( 60 - sayac));


        point = 0;

        skor.setText("Skor : "+point);



        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,1000);

                int randNum1 = myRandom.nextInt(5);

                if(randNum1 == 0){

                    imageView0.setVisibility(View.INVISIBLE);
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                    imageView4.setVisibility(View.INVISIBLE);
                    imageView5.setVisibility(View.INVISIBLE);
                    imageView6.setVisibility(View.INVISIBLE);
                    imageView7.setVisibility(View.INVISIBLE);
                    imageView8.setVisibility(View.INVISIBLE);

                    int randNum = myRandom.nextInt(9);

                    switch (randNum) {
                        case 0:
                            ximageView0.setVisibility(View.VISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 1:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.VISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.VISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.VISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 4:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.VISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 5:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.VISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 6:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.VISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 7:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.VISIBLE);
                            ximageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 8:
                            ximageView0.setVisibility(View.INVISIBLE);
                            ximageView1.setVisibility(View.INVISIBLE);
                            ximageView2.setVisibility(View.INVISIBLE);
                            ximageView3.setVisibility(View.INVISIBLE);
                            ximageView4.setVisibility(View.INVISIBLE);
                            ximageView5.setVisibility(View.INVISIBLE);
                            ximageView6.setVisibility(View.INVISIBLE);
                            ximageView7.setVisibility(View.INVISIBLE);
                            ximageView8.setVisibility(View.VISIBLE);
                            break;
                    }

                }else{

                    ximageView0.setVisibility(View.INVISIBLE);
                    ximageView1.setVisibility(View.INVISIBLE);
                    ximageView2.setVisibility(View.INVISIBLE);
                    ximageView3.setVisibility(View.INVISIBLE);
                    ximageView4.setVisibility(View.INVISIBLE);
                    ximageView5.setVisibility(View.INVISIBLE);
                    ximageView6.setVisibility(View.INVISIBLE);
                    ximageView7.setVisibility(View.INVISIBLE);
                    ximageView8.setVisibility(View.INVISIBLE);

                    int randNum = myRandom.nextInt(9);


                    switch (randNum){
                        case 0 :
                            imageView0.setVisibility(View.VISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);
                            imageView2.setVisibility(View.INVISIBLE);
                            imageView3.setVisibility(View.INVISIBLE);
                            imageView4.setVisibility(View.INVISIBLE);
                            imageView5.setVisibility(View.INVISIBLE);
                            imageView6.setVisibility(View.INVISIBLE);
                            imageView7.setVisibility(View.INVISIBLE);
                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 1 :
                            imageView1.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);

                            imageView2.setVisibility(View.INVISIBLE);
                            imageView3.setVisibility(View.INVISIBLE);
                            imageView4.setVisibility(View.INVISIBLE);
                            imageView5.setVisibility(View.INVISIBLE);
                            imageView6.setVisibility(View.INVISIBLE);
                            imageView7.setVisibility(View.INVISIBLE);
                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 2 :
                            imageView2.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);

                            imageView3.setVisibility(View.INVISIBLE);
                            imageView4.setVisibility(View.INVISIBLE);
                            imageView5.setVisibility(View.INVISIBLE);
                            imageView6.setVisibility(View.INVISIBLE);
                            imageView7.setVisibility(View.INVISIBLE);
                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 3 :
                            imageView3.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);
                            imageView2.setVisibility(View.INVISIBLE);

                            imageView4.setVisibility(View.INVISIBLE);
                            imageView5.setVisibility(View.INVISIBLE);
                            imageView6.setVisibility(View.INVISIBLE);
                            imageView7.setVisibility(View.INVISIBLE);
                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 4 :
                            imageView4.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);
                            imageView2.setVisibility(View.INVISIBLE);
                            imageView3.setVisibility(View.INVISIBLE);

                            imageView5.setVisibility(View.INVISIBLE);
                            imageView6.setVisibility(View.INVISIBLE);
                            imageView7.setVisibility(View.INVISIBLE);
                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 5 :
                            imageView5.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);
                            imageView2.setVisibility(View.INVISIBLE);
                            imageView3.setVisibility(View.INVISIBLE);
                            imageView4.setVisibility(View.INVISIBLE);

                            imageView6.setVisibility(View.INVISIBLE);
                            imageView7.setVisibility(View.INVISIBLE);
                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 6 :
                            imageView6.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);
                            imageView2.setVisibility(View.INVISIBLE);
                            imageView3.setVisibility(View.INVISIBLE);
                            imageView4.setVisibility(View.INVISIBLE);
                            imageView5.setVisibility(View.INVISIBLE);

                            imageView7.setVisibility(View.INVISIBLE);
                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 7 :
                            imageView7.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);
                            imageView2.setVisibility(View.INVISIBLE);
                            imageView3.setVisibility(View.INVISIBLE);
                            imageView4.setVisibility(View.INVISIBLE);
                            imageView5.setVisibility(View.INVISIBLE);
                            imageView6.setVisibility(View.INVISIBLE);

                            imageView8.setVisibility(View.INVISIBLE);
                            break;
                        case 8 :
                            imageView8.setVisibility(View.VISIBLE);

                            imageView0.setVisibility(View.INVISIBLE);
                            imageView1.setVisibility(View.INVISIBLE);
                            imageView2.setVisibility(View.INVISIBLE);
                            imageView3.setVisibility(View.INVISIBLE);
                            imageView4.setVisibility(View.INVISIBLE);
                            imageView5.setVisibility(View.INVISIBLE);
                            imageView6.setVisibility(View.INVISIBLE);
                            imageView7.setVisibility(View.INVISIBLE);

                            break;
                    }

                }




            }

        };
        handler.post(runnable);






        handler1 = new Handler();

        runnable1 = new Runnable() {
            @Override
            public void run() {
                handler1.postDelayed(runnable1,1000);

                if(sayac == 60){
                    handler.removeCallbacks(runnable);
                    handler1.removeCallbacks(runnable1);

                    imageView0.setVisibility(View.VISIBLE);
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                    imageView4.setVisibility(View.VISIBLE);
                    imageView5.setVisibility(View.INVISIBLE);
                    imageView6.setVisibility(View.VISIBLE);
                    imageView7.setVisibility(View.INVISIBLE);
                    imageView8.setVisibility(View.VISIBLE);


                    ximageView0.setVisibility(View.INVISIBLE);
                    ximageView1.setVisibility(View.VISIBLE);
                    ximageView2.setVisibility(View.INVISIBLE);
                    ximageView3.setVisibility(View.VISIBLE);
                    ximageView4.setVisibility(View.INVISIBLE);
                    ximageView5.setVisibility(View.VISIBLE);
                    ximageView6.setVisibility(View.INVISIBLE);
                    ximageView7.setVisibility(View.VISIBLE);
                    ximageView8.setVisibility(View.INVISIBLE);



                    Reset.setVisibility(View.VISIBLE);



                }else{
                    sayac++;
                    kalansure.setText("Kalan Süre : " + ( 60 - sayac));
                }


            }

        };
        handler1.post(runnable1);


    }

    public void islem(View view){
        if(sayac ==60){
//            Toast.makeText(this, "Oyun Bitmiştir", Toast.LENGTH_SHORT).show();
            kalansure.setText("Oyun Bitmiştir");

        }else{
            imageView0.setVisibility(View.INVISIBLE);
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            imageView4.setVisibility(View.INVISIBLE);
            imageView5.setVisibility(View.INVISIBLE);
            imageView6.setVisibility(View.INVISIBLE);
            imageView7.setVisibility(View.INVISIBLE);
            point++;
            skor.setText("Skor : "+point);

        }

    }


    public void fail(View view){

        Reset.setVisibility(View.VISIBLE);
        kalansure.setText("Oyun Bitmiştir");
        handler.removeCallbacks(runnable);
        handler1.removeCallbacks(runnable1);

        sayac = 60 ;
            point = 0;
            skor.setText("Skor : "+point);

        imageView0.setVisibility(View.VISIBLE);
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.VISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.VISIBLE);
        imageView5.setVisibility(View.INVISIBLE);
        imageView6.setVisibility(View.VISIBLE);
        imageView7.setVisibility(View.INVISIBLE);
        imageView8.setVisibility(View.VISIBLE);


        ximageView0.setVisibility(View.INVISIBLE);
        ximageView1.setVisibility(View.VISIBLE);
        ximageView2.setVisibility(View.INVISIBLE);
        ximageView3.setVisibility(View.VISIBLE);
        ximageView4.setVisibility(View.INVISIBLE);
        ximageView5.setVisibility(View.VISIBLE);
        ximageView6.setVisibility(View.INVISIBLE);
        ximageView7.setVisibility(View.VISIBLE);
        ximageView8.setVisibility(View.INVISIBLE);

    }




//  ==============================================================  RESET AT ==============================================================

    public  void ResetThePage(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

//  ==============================================================  GERİ GİT ==============================================================
    public void geriGit(View view){
        Intent geri = new Intent(this, MainActivity.class);
        startActivity(geri);
    }


}
