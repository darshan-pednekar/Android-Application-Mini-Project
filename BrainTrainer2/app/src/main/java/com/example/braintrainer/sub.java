package com.example.braintrainer;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Random;

public class sub extends MainActivity{

    TextView displayedQ;
    TextView score;
    TextView remainingTimeLeft;
    TextView status;

//    MainActivity mainAct = new MainActivity();

    int k = 21;
    int timeLeft;
    int a = 2;
    int b = 1;
    int answer = a - b;
    int rightAnswers = 0;
    int totalAnswers = 0;

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button play;

    Boolean isPlaying = false;

    ArrayList<Button> buttonArrayList = new ArrayList<Button>();

//    MediaPlayer wrongAns;
//    MediaPlayer rightAns;

    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

//        wrongAns = MediaPlayer.create(SubClass.this, R.raw.incorrect);
//        rightAns = MediaPlayer.create(SubClass.this, R.raw.correct);


        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeLeft = (int) (millisUntilFinished / 1000);
                remainingTimeLeft.setText(String.valueOf(timeLeft) + "s");

            }

            @Override
            public void onFinish() {

                remainingTimeLeft.setText("0s");
                play.setText("Play Again");
                isPlaying = false;
                notClickable();
                displayedQ.setVisibility(View.INVISIBLE);

                final AlertDialog.Builder builder = new AlertDialog.Builder(sub.this);
                builder.setCancelable(false);
                builder.setTitle("Time is up!");
                builder.setMessage("You scored" + " " + score.getText().toString() + "! ");

                builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("Try something else", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent2 = new Intent(sub.this, MainActivity.class);
                        startActivity(intent2);
                    }
                });


                builder.show();

            }
        };

        buttonArrayList.add(b1);
        buttonArrayList.add(b2);
        buttonArrayList.add(b3);
        buttonArrayList.add(b4);

        displayedQ = findViewById(R.id.displayedQuestion);
        score = findViewById(R.id.textCorrectAnswers);
        remainingTimeLeft = findViewById(R.id.textTimeLeft);
        status= findViewById(R.id.textStatus);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);


        play = findViewById(R.id.buttonPlay);


        displayedQ.setText(String.valueOf(a) + " - " + String.valueOf(b));
        displayedQ.setVisibility(View.INVISIBLE);
        status.setVisibility(View.INVISIBLE);

        notClickable();

        resetChoices();

        setRandomPossibleAnswer();

        checkIfPossibleIsRight();

    }


    public void onAnswerGiven(View view){
        answer = a - b;

        if (view.getTag().equals("Correct")){

            answeredRight();

        } else if (view.getTag().equals("Incorrect")){

            answeredWrong();

        }

        resetChoices();
        setRandomPossibleAnswer();
        checkIfPossibleIsRight();

    }

    public void playGame(View view) {

        if (isPlaying == false) {
            isPlaying = true;
            play.setText("Stop");
            displayedQ.setVisibility(View.VISIBLE);
            countDownTimer.start();
            status.setVisibility(View.VISIBLE);
            rightAnswers = 0;
            totalAnswers = 0;
            score.setText("0/0");
            isClickable();

        } else {
            isPlaying = false;
            play.setText("Play");
            displayedQ.setVisibility(View.INVISIBLE);
            timeLeft = 30000;
            remainingTimeLeft.setText("30s");
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            status.setText("");
            status.setVisibility(View.INVISIBLE);
            score.setText("0/0");
            rightAnswers = 0;
            totalAnswers = 0;
            notClickable();
        }
    }

    public void answeredRight(){

        status.setText("Correct!");
        rightAnswers++;
        totalAnswers++;
        score.setText(String.valueOf(rightAnswers) + "/" + String.valueOf(totalAnswers));
//        rightAns.seekTo(0);
//        rightAns.start();
        nextQuestion();

    }

    public void answeredWrong(){

        status.setText("Wrong!");
        totalAnswers++;
        score.setText(String.valueOf(rightAnswers) + "/" + String.valueOf(totalAnswers));
//        wrongAns.seekTo(0);
//        wrongAns.start();
        nextQuestion();

    }

    public void nextQuestion(){


        final int random = new Random().nextInt((k + 5)); //nextInt(61) --> [0, 60] + 20 => [20, 80]

        a = random;

        final int random2 = new Random().nextInt((k)) ;

        b = random2;

        answer = a - b;
        displayedQ.setText(String.valueOf(a) + " - " + String.valueOf(b));

    }

    public void setRandomPossibleAnswer(){

        Random random = new Random();
        int randomInt = random.nextInt(4);
        if (randomInt == 0){
            b1.setTag("Correct");
        } else if (randomInt == 1){
            b2.setTag("Correct");
        } else if (randomInt == 2){
            b3.setTag("Correct");
        } else if (randomInt == 3){
            b4.setTag("Correct");
        }
    }

    public void checkIfPossibleIsRight(){

        int r1 = answer + new Random().nextInt(10 - 5);
        int r2 = answer + new Random().nextInt(5) - 10;
        int r3 = answer + new Random().nextInt(20 + 10);

        while (r1 == answer || r2 == answer || r3 == answer){
            r1 = answer + new Random().nextInt(10 - 5);
            r2 = answer + new Random().nextInt(5) - 10;
            r3 = answer + new Random().nextInt(20 + 10);
        }

        if (b1.getTag().equals("Correct")){

            b1.setText(String.valueOf(answer));
            b2.setText(String.valueOf(r1));
            b3.setText(String.valueOf(r2));
            b4.setText(String.valueOf(r3));

        } else if (b2.getTag().equals("Correct")){
            b2.setText(String.valueOf(answer));
            b1.setText(String.valueOf(r1));
            b3.setText(String.valueOf(r2));
            b4.setText(String.valueOf(r3));
        } else if (b3.getTag().equals("Correct")) {
            b3.setText(String.valueOf(answer));
            b1.setText(String.valueOf(r1));
            b2.setText(String.valueOf(r2));
            b4.setText(String.valueOf(r3));
        }  else if (b4.getTag().equals("Correct")) {
            b4.setText(String.valueOf(answer));
            b1.setText(String.valueOf(r1));
            b2.setText(String.valueOf(r2));
            b3.setText(String.valueOf(r3));
        }
    }


    public void resetChoices(){

        b1.setTag("Incorrect");
        b2.setTag("Incorrect");
        b3.setTag("Incorrect");
        b4.setTag("Incorrect");

    }

    public void notClickable(){
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);
    }

    public void isClickable(){
        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);
        b4.setClickable(true);
    }

}
