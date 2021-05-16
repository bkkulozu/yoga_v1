package com.example.kulozubeste;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

/**
 *  Beste Kulozu 214 00 474
 *  CTIS - 487 Project
 */

public class MainActivity extends AppCompatActivity {
    Button notifyBtn;
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

    public void BtnExerciseClick(View view) {
        intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }

    public void CheckClick(View view) {
        intent = new Intent(this, FavouriteActivity.class);
        startActivity(intent);

    }


    public void btnProgress(View view) {
        intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }


    public void btnInfo(View view) {

        intent = new Intent(this, InfoActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }

    /*
    public void TxtClick(View view) {
        intent = new Intent(this, SignUpActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }
    */

    public void InfoClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme);

        builder.setTitle(" YOGA FIT CLASS  ");
        builder.setMessage("This is mobile application development project." +
                "For feedbacks and inquiries contact me on github : bkkulozu");
        //builder.setNegativeButton("NO", null);
        builder.setPositiveButton("CLOSE", null);
        builder.show();

    }

    public void btnDetails(View view) {
        intent = new Intent(this, FragmentsActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }

    public void btnMusic(View view) {
        intent = new Intent(this, MusicServiceActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }

    public void aboutApp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(" About App");
        builder.setMessage("Yoga Fit Class ");
        // builder.setNegativeButton("No", null);
        builder.setPositiveButton(" X ", null);
        builder.show();
    }

    public void aboutMail(View view) {
        intent = new Intent(this, MailActivity.class);
        startActivity(intent);
    }

    // for action bar
    // ...

}

/**                                      -  o -                                     */

/**
 *  to be continued with version improvement (for Google Play Store) in the upcoming days..
 */


