package com.example.braintrainer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button butAdd;
    Button butSub;
//    Button butMul;
//    Button butDiv;

    int timeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butAdd = findViewById(R.id.butAdd);
        butAdd.setOnClickListener(this);
        butSub = findViewById(R.id.butSub);
        butSub.setOnClickListener(this);
//        butMul = findViewById(R.id.butMult);
//        butDiv = findViewById(R.id.butDiv);

        timeLeft = 1000;

        CountDownTimer countDownTimer = new CountDownTimer(1000, 250) {
            @Override
            public void onTick(long millisUntilFinished) {


                if (timeLeft == 1000) {
                    butAdd.animate().alpha(1).setDuration(500);
                } else if (timeLeft == 750) {
                    butSub.animate().alpha(1).setDuration(500);
//                } else if(timeLeft == 500){
//                    butMul.animate().alpha(1).setDuration(500);
//                    butDiv.animate().alpha(1).setDuration(750);
                }

                timeLeft = timeLeft - 250;
            }


            @Override
            public void onFinish() {

            }
        }.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                //about
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
                break;
//            case R.id.create:
//                //create
//                break;

        }
        return super.onOptionsItemSelected(item);
    }


//    public void goAdd(View view) {
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
////        builder.setTitle("Difficulty");
////        builder.setMessage("Choose a difficulty");
////
//        builder.setPositiveButton("Addition", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(View view) {
               if(view.equals(butAdd)){ Intent intent1 = new Intent(MainActivity.this, add.class);
                startActivity(intent1);
            }if(view.equals(butSub)){
                    Intent intent1 = new Intent(MainActivity.this, sub.class);
                    startActivity(intent1);
               }
            }
//        });

//        builder.setNegativeButton("Hard", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent2 = new Intent(MainActivity.this, add.class);
//                startActivity(intent2);
//            }
//        });


//        builder.show();
//
//    }

//    public void goSub(View view) {
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
////        builder.setTitle("Difficulty");
////        builder.setMessage("Choose a difficulty");
//
//        builder.setPositiveButton("Subtraction", new DialogInterface.OnClickListener() {


//            @Override
//            public void onClick( view) {
//                Intent intent1 = new Intent(MainActivity.this, sub.class);
//                startActivity(intent1);
//            }
//        });

//        builder.setNegativeButton("Hard", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent2 = new Intent(MainActivity.this, sub.class);
//                startActivity(intent2);
//            }
//        });


//        builder.show();
//
//    }
//    public void goMult(View view){
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle("Difficulty");
//        builder.setMessage("Choose a difficulty");
//
//        builder.setPositiveButton("Easy", new DialogInterface.OnClickListener() {
//
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent1 = new Intent(MainActivity.this, mul.class);
//                startActivity(intent1);
//            }
//        });
//
//        builder.setNegativeButton("Hard", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent2 = new Intent(MainActivity.this, mul.class);
//                startActivity(intent2);
//            }
//        });
//
//        builder.show();
//
//    }
//    public void goDiv(View view){
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle("Not available!");
//        builder.setMessage("Division section is still under development!");
//
//        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        builder.show();
//
//    }
//
//    private void showAlertDialog() {
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle("Difficulty");
//        builder.setMessage("Choose a difficulty");
//
//        builder.setPositiveButton("Easy", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //easy
//            }
//        });
//
//        builder.setNegativeButton("Hard", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //hard
//            }
//        });
//
//
//        builder.show();
//
//    }
}

