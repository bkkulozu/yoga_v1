package com.example.kulozubeste;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 *  Beste Kulozu 214 00 474 volley
 */
public class VolleyActivity extends AppCompatActivity {
    Intent intent;
    Bundle b;

    private ImageView mImageView;
    private Button mButton;

    MyVolleyUsage myVolley;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);


        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mButton = findViewById(R.id.btn);
        mImageView = findViewById(R.id.img);

        myVolley = new MyVolleyUsage(this);

    }

    public void onClick(View view) {
        //yoga image google
        myVolley.requestForBinaryData("https://i.pinimg.com/originals/d6/13/75/d61375d5376deaf384de413cd520ffbd.jpg");
        myVolley.sendPOSTRequest("https://i.pinimg.com/originals/d6/13/75/d61375d5376deaf384de413cd520ffbd.jpg");
        mButton.setEnabled(false);

    }

    public void setBitmapImage(Bitmap response) {
        mImageView.setImageBitmap(response);
        Toast.makeText(VolleyActivity.this, "IMAGE LOADED",
                Toast.LENGTH_SHORT).show();

    }
}
