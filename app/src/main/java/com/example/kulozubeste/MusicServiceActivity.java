package com.example.kulozubeste;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import static com.example.kulozubeste.TimerState.Initial;
import static com.example.kulozubeste.TimerState.Paused;
import static com.example.kulozubeste.TimerState.Running;

/**
 *  Beste Kulozu 214 00 474
 */

public class MusicServiceActivity extends AppCompatActivity {
    Intent intent;
    Bundle b;

    ImageView img;
    Button btn;
    boolean image1Displaying = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        intent = getIntent();
        Bundle b = intent.getExtras();

        Toast.makeText(getApplicationContext(), "Press image to change ", Toast.LENGTH_LONG).show();

        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);

        //Play the mp3 when the button is pressed
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.moby);
                mp.start();
            }
        });

        //Change the image when the imageView is touched
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (image1Displaying) {
                    img.setImageResource(R.drawable.sea);
                    image1Displaying = false;
                } else {
                    img.setImageResource(R.drawable.windbell);
                    image1Displaying = true;
                }
                return false;
            }
        });

    }

    public void onStart(View view) {
        Intent intent = new Intent(this, MyService.class);

        if (view.getId() == R.id.btnStartService)
            startService(intent);
        else {

            stopService(intent);
        }
    }

}
