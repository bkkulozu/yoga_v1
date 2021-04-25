package com.example.yogafitclass;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Created by Beste Kulozu 214 00 474
 */
public class ProfileActivity extends AppCompatActivity {

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_signup);

        // Hiding title bar using code
        getSupportActionBar().hide();

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        intent = getIntent();
        Bundle b = intent.getExtras();


    }

    public void btnPrevious(View view) {
        intent = new Intent(this, MainActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }
}
