package com.ahmetayds.random2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    View myBackground;
    TextView P1Budget;
    TextView P2Budget;

    TextView name1;
    TextView name2;

    EditText P1Bet;
    EditText P2Bet;

    Button gamblingButton;

    int P1BudgetInt = 100;
    int P2BudgetInt = 100;

    int P1BetInt;
    int P2BetInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBackground = findViewById(R.id.myBackground);

        P1Budget = findViewById(R.id.P1Budget);
        P2Budget = findViewById(R.id.P2Budget);

        P1Bet = findViewById(R.id.P1Bet);
        P2Bet = findViewById(R.id.P2Bet);

        gamblingButton = findViewById(R.id.gamblingButton);

        name1= findViewById(R.id.name1);
        name2= findViewById(R.id.name2);


    }

    public void gambling(View view){

        if(P1Bet.getText().toString().matches("")|| P2Bet.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(),"Lütfen Bet Miktarı Giriniz", Toast.LENGTH_LONG).show();
        }else{
                    P1BetInt = Integer.parseInt(P1Bet.getText().toString());
        P2BetInt = Integer.parseInt(P2Bet.getText().toString());


            if(P1BudgetInt <= 0 || P2BudgetInt <= 0){



                Toast.makeText(getApplicationContext(),"Oyun Bitmiştir", Toast.LENGTH_LONG).show();
            }else{
                if(P1BetInt > P1BudgetInt || P2BetInt > P2BudgetInt){
                    Toast.makeText(getApplicationContext(),"Bütçenizden Daha Fazla Oynayamazsınız", Toast.LENGTH_LONG).show();
                }else{

                            System.out.println("P1BudgetInt " +P1BudgetInt);
                            System.out.println("P2BudgetInt " +P2BudgetInt);
                            System.out.println("P1BetInt " + P1BetInt);
                            System.out.println("P2BetInt " + P2BetInt);


                    gamblingButton.setEnabled(false);


                    Random myRandom = new Random();

                    int randomNum = myRandom.nextInt(2); // 0 ya da 1

                    int sure;
                    if(randomNum==0){
                        sure = 2000;
                    }else{
                        sure = 2150;
                    }


                    new CountDownTimer(sure,150){
                        String color = "red";
                        @Override
                        public void onTick(long milisUntilFinshed){


                            if(color == "red"){
                                myBackground.setBackgroundResource(R.color.myGreen);
                                color = "green";
                            }else{
                                myBackground.setBackgroundResource(R.color.myRed);
                                color = "red";
                            }

                        }
                        @Override
                        public void onFinish(){
                            gamblingButton.setEnabled(true);
                            if(color == "red"){
                                Toast.makeText(getApplicationContext(),"Player 1 Wins", Toast.LENGTH_LONG).show();
                                P1BetInt = Integer.parseInt(P1Bet.getText().toString());
                                P2BetInt = Integer.parseInt(P2Bet.getText().toString());

                                P1BudgetInt = P1BudgetInt + P1BetInt;

                                P1Budget.setText(Integer.toString(P1BudgetInt) + " $");

                                P2BudgetInt = P2BudgetInt - P2BetInt;
                                P2Budget.setText(Integer.toString(P2BudgetInt) + " $");



                                new CountDownTimer(1000,100){

                                    @Override
                                    public void onTick(long milisUntilFinshed){

                                        String innerColor = "black";

                                        if(innerColor == "black"){
                                            name1.setBackgroundResource(R.color.white);
                                            innerColor = "white";
                                        }else{
                                            name1.setBackgroundResource(R.color.black);
                                            innerColor = "black";
                                        }


                                    }
                                    @Override
                                    public void onFinish(){

                                    }
                                }.start();





                            }else{
                                Toast.makeText(getApplicationContext(),"Player 2 Wins", Toast.LENGTH_LONG).show();
                                P1BetInt = Integer.parseInt(P1Bet.getText().toString());
                                P2BetInt = Integer.parseInt(P2Bet.getText().toString());

                                P2BudgetInt = P2BudgetInt + P2BetInt;

                                P2Budget.setText(Integer.toString(P2BudgetInt) + " $");

                                P1BudgetInt = P1BudgetInt - P1BetInt;
                                P1Budget.setText(Integer.toString(P1BudgetInt) + " $");


                                new CountDownTimer(1000,100){

                                    @Override
                                    public void onTick(long milisUntilFinshed){

                                        String innerColor = "white";

                                        if(innerColor == "black"){
                                            name2.setBackgroundResource(R.color.white);
                                            innerColor = "white";
                                        }else{
                                            name2.setBackgroundResource(R.color.black);
                                            innerColor = "black";
                                        }


                                    }
                                    @Override
                                    public void onFinish(){


                                    }
                                }.start();




                            }

                            System.out.println("P1BudgetInt " +P1BudgetInt);
                            System.out.println("P2BudgetInt " +P2BudgetInt);
                            System.out.println("P1BetInt " + P1BetInt);
                            System.out.println("P2BetInt " + P2BetInt);

                        }
                    }.start();
                }
            }
        }


















    }
}