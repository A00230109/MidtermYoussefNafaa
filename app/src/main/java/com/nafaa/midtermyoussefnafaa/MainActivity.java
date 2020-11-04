package com.nafaa.midtermyoussefnafaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int sideUp;
    int checkId;
    String stSideUp;
    RadioGroup rdGroup;
    RadioButton rdBtnFour, rdBtnSix, rdBtnEight, rdBtnTen, rdBtnTwelve, rdBtnTwenty, rdBtnTrueTen;
    Button btn1Result, btn2Result;
    TextView txt1Result, txt2Result;
    ImageView imgView;
    Dice dice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdGroup = findViewById(R.id.rdGroup);
        rdBtnFour = findViewById(R.id.rdBtnFour);
        rdBtnSix = findViewById(R.id.rdBtnSix);
        rdBtnEight = findViewById(R.id.rdBtnEight);
        rdBtnTen = findViewById(R.id.rdBtnTen);
        rdBtnTwelve = findViewById(R.id.rdBtnTwelve);
        rdBtnTwenty = findViewById(R.id.rdBtnTwenty);

        rdBtnTrueTen = findViewById(R.id.rdBtnTrueTen);

        btn1Result = findViewById(R.id.btn1Result);
        btn2Result = findViewById(R.id.btn2Result);

        txt1Result = findViewById(R.id.txt1Result);
        txt2Result = findViewById(R.id.txt2Result);

        imgView = findViewById(R.id.imgView);
        // By default dice 4 is shown
        dice = new Dice(4);

        imgView.setImageResource(R.drawable.dice4);
        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // we clear the precedent object before creating another one
                dice = null;

                txt1Result.setText("");
                txt2Result.setText("");
                checkId = checkedId;
                switch (checkedId){
                    case R.id.rdBtnFour:
                        dice = new Dice(4);
                        imgView.setImageResource(R.drawable.dice4);
                        break;
                    case R.id.rdBtnSix:
                        dice = new Dice(6);
                        imgView.setImageResource(R.drawable.dice6);
                        break;
                    case R.id.rdBtnEight:
                        dice = new Dice(8);
                        imgView.setImageResource(R.drawable.dice8);
                        break;
                    case R.id.rdBtnTen:
                        dice = new Dice(10);
                        imgView.setImageResource(R.drawable.dice10);
                        break;
                    case R.id.rdBtnTrueTen:
                        dice = new Dice(10);
                        imgView.setImageResource(R.drawable.dicetrueten);
                        break;
                    case R.id.rdBtnTwelve:
                        dice = new Dice(12);
                        imgView.setImageResource(R.drawable.dice12);
                        break;
                    case R.id.rdBtnTwenty:
                        dice = new Dice(20);
                        imgView.setImageResource(R.drawable.dice20);
                        break;
                    }
            }
        });

        btn1Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkId == R.id.rdBtnTrueTen)
                    dice.roll(0);
                else
                    dice.roll(1);
                sideUp = dice.getSideUp();
                stSideUp = String.valueOf(sideUp)  ;
                txt1Result.setText(stSideUp);
                rotateDiceOnce();
            }
        });

        btn2Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkId == R.id.rdBtnTrueTen)
                    dice.roll(0);
                else
                    dice.roll(1);
                sideUp = dice.getSideUp();
                stSideUp = String.valueOf(sideUp)  ;
                txt2Result.setText(stSideUp);
                rotateDiceTwice();
                if (checkId == R.id.rdBtnTrueTen)
                    dice.roll(0);
                else
                    dice.roll(1);
                sideUp = dice.getSideUp();
                stSideUp = txt2Result.getText()+", "+sideUp;
                txt2Result.setText(stSideUp);
                rotateDiceTwice();

            }
        });
    }

    private void rotateDiceOnce(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imgView.startAnimation(anim);
    }

    private void rotateDiceTwice(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotatetwice);
        imgView.startAnimation(anim);
    }

}