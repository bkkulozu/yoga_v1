package com.example.kulozubeste;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
/**
 * Beste Kulozu 214 00 474
 */
public class InfoActivity extends AppCompatActivity implements GestureType{
    private GestureDetectorCompat mDetector;

    Intent intent;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        intent = getIntent();
        Bundle b = intent.getExtras();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        Intent intent = new Intent(InfoActivity.this, ThirdActivity.class);
        Bundle bundle = new Bundle();

        public boolean onDoubleTap(MotionEvent event) {
            bundle.putInt("key1", LONG_HOLD);
           /* intent.putExtras(bundle);
            startActivity(intent); */
            Intent mmintent;
            mmintent = new Intent(InfoActivity.this, MainActivity.class);
            //  intent.putExtras(b);
            startActivity(mmintent);
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            bundle.putInt("key1", DOUBLE_TAP);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}



