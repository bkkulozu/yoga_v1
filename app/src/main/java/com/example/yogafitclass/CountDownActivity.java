package com.example.yogafitclass;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;

public class CountDownActivity extends AppCompatActivity {

    Intent intent;
    Bundle b;
    EditText editText;
    TextView mTextField;



    //private static final String FORMAT = "%02d:%02d";
     private static final String FORMAT = "%02d:%02d:%02d";

    int seconds , minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coundown_layout);

        mTextField=(TextView)findViewById(R.id.mTextField);

        // Hiding title bar using code
        // getSupportActionBar().hide();

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        intent = getIntent();
        Bundle b = intent.getExtras();

        String posenamestr = b.getString("posename");
        TextView posename = findViewById(R.id.posename);
        posename.setText(posenamestr);

        int logoid = b.getInt("logoid");
        ImageView logo = findViewById(R.id.logo);
        logo.setImageResource(logoid);


        new CountDownTimer(16069000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                mTextField.setText(""+String.format(FORMAT, TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();


    }

}
