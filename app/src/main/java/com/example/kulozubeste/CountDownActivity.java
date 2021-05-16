package com.example.kulozubeste;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.kulozubeste.TimerState.Initial;
import static com.example.kulozubeste.TimerState.Paused;
import static com.example.kulozubeste.TimerState.Running;

/**
 *  Beste Kulozu 214 00 474
 */

public class CountDownActivity extends AppCompatActivity {
    Intent intent;
    Bundle b;
    EditText editText;
    TextView mTextField;
    TimerState timerState = Initial;
    Button startBtn, pauseBtn, resumeBtn;

    private int mNotificationId = 1;
    private Notification mNotification;

    /** for notification old version
    private final String CHANNEL_ID = "personal notifications";
    private final int NOTIFICATION_ID = 001; */

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

    public void BtnNotify(View view) {
        Toast.makeText(this, "One new notification", Toast.LENGTH_SHORT).show();
        // Obtaining the handle to system-level service
        //NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Prepare intent which is triggered if the notification is selected
        Intent intent = new Intent(this, NotificationResultDisplayActivity.class);
        intent.putExtra("notificationID", mNotificationId);
        intent.putExtra("bookname","Two Towers");

        // A PendingIntent is a token that you give to another application (e.g. Notification Manager,
        // Alarm Manager or other 3rd party applications), which allows this other application to use
        // the permissions of your application to execute a predefined piece of code.
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_HIGH);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setTicker("Hearty365")
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentTitle("Yoga Fit Class")
                .setContentText("Hey ! It's time for your yoga session~ And save this to remember if you are having break time :)  ")
                .setContentInfo("And save this to remember if you are having break time :)").
                setContentIntent(pIntent);
        notificationManager.notify(/*notification id*/1, notificationBuilder.build());


    }
}


