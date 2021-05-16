package com.example.kulozubeste;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/**
 *  Beste Kulozu 214 00 474
 */
public class CalendarActivity extends AppCompatActivity {
    Intent intent;

    ProgressBar progressBar;
    TextView textView;
    int value;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_layout);

        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        intent = getIntent();
        Bundle b = intent.getExtras();

        progressBar=findViewById(R.id.progressbarid);
        textView=findViewById(R.id.textviewid);

        // for progress bar percentage
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startProgress();
            }
        });
        thread.start();

    }

    public void startProgress() {

        for(value=0; value<100;value=value+1) {

            try{
                Thread.sleep(50);
                progressBar.setProgress(value);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            //for progress percentage
            handler.post(new Runnable() {
                @Override
                public void run() {
                textView.setText(String.valueOf("%"+ value));

                    // textView.setText(String.valueOf(value));

                }
            });
        }


    }
}

