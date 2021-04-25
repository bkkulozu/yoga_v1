package com.example.yogafitclass;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.yogafitclass.TimerState.Initial;
import static com.example.yogafitclass.TimerState.Paused;
import static com.example.yogafitclass.TimerState.Running;

/**
 * Created by Beste Kulozu 214 00 474
 */

public class CountDownActivity extends AppCompatActivity {
    Intent intent;
    Bundle b;
    EditText editText;
    TextView mTextField;
    TimerState timerState = Initial;
    Button startBtn, pauseBtn, resumeBtn;

    long timerMsleft =  15000;
    CountDownTimer timer;
    int seconds , minutes;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coundown_layout);

        mTextField=(TextView)findViewById(R.id.mTextField);
        startBtn = findViewById(R.id.startBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        resumeBtn = findViewById(R.id.resumeBtn);

        // Hiding title bar using code
        getSupportActionBar().hide();
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
        ImageView logo = findViewById(R.id.coundown_logo);
        logo.setImageResource(logoid);

        updateUiWithTimerState();
    }

    public void onCustomToggleClick(View view) {
        Toast.makeText(this, " ", Toast.LENGTH_SHORT).show();
    }

    private void startTimer(){
        timerState = Running;
        updateUiWithTimerState();
        //1000 ms x 15
        timer = new CountDownTimer(15000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                timerMsleft = millisUntilFinished;
                mTextField.setText(String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }
            public void onFinish() {
                mTextField.setText("done!");
                timerState = TimerState.Stopped;
                updateUiWithTimerState();

            }
        }.start();
    }

    private void pauseTimer() {
        timerState = Paused;
        updateUiWithTimerState();
            timer.cancel();
    }

    private void resumeTimer() {
        timerState = Running;
        updateUiWithTimerState();
        timer = new CountDownTimer(timerMsleft, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                timerMsleft = millisUntilFinished;
                mTextField.setText(String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }
            public void onFinish() {
                mTextField.setText("DONE !");
                timerState = TimerState.Stopped;
                updateUiWithTimerState();
            }
        }.start();

    }

    public void startClick(View view){
        startTimer();
    }

    public void pauseClick(View view){
        pauseTimer();
    }

    public void resumeClick(View view){
        resumeTimer();
    }

    private void updateUiWithTimerState() {
        switch(timerState) {
            case Initial:
                mTextField.setText("TAP START");
                pauseBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);
                resumeBtn.setVisibility(View.GONE);
                break;

            case Running:
                pauseBtn.setVisibility(View.VISIBLE);
                startBtn.setVisibility(View.GONE);
                resumeBtn.setVisibility(View.GONE);
                break;

            case Paused:
                pauseBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.GONE);
                resumeBtn.setVisibility(View.VISIBLE);
                break;

            case Stopped:
                pauseBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);
                resumeBtn.setVisibility(View.GONE);
                break;
        }
    }
}
