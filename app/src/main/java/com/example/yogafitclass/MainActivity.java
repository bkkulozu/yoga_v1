package com.example.yogafitclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiding title bar using code
        getSupportActionBar().hide();

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }

    public void onClick(View view) {
        intent = new Intent(this, SecondActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);

    }

    public void BtnClick(View view) {
        intent = new Intent(this, ExerciseActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }

    public void CheckClick(View view) {
        intent = new Intent(this, FavouriteActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);

    }

   /* public void btnProfile(View view) {
        intent = new Intent(this, ProfileActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    } */


    public void btnProgress(View view) {
        intent = new Intent(this, CalendarActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);


    }

    public void YogaClick(View view) {
        intent = new Intent(this, RecylerActivity.class);
        startActivity(intent);


    }


    public void btnInfo(View view) {

        intent = new Intent(this, InfoActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);


    }

    public void TxtClick(View view) {
        intent = new Intent(this, SignUpActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }

    public void InfoClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme);

        builder.setTitle(" YOGA FIT CLASS  ");
        builder.setMessage("This is Mobile Application Project created by Beste Kulozu." +
                "For more information, contact me on github : bkkulozu ");
       // builder.setNegativeButton("No", null);
        builder.setPositiveButton("CLOSE", null);
        builder.show();

    }
}

