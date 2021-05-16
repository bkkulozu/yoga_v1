package com.example.kulozubeste;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

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
 *  Beste Kulozu 214 00 474 Json & Parse
 */
public class ThirdActivity extends AppCompatActivity {

    RecyclerView recyclerJson;
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> headline = new ArrayList<>();
    ArrayList<String> context = new ArrayList<>();
    ArrayList<String> content = new ArrayList<>();

    Intent intent;
    Bundle b;

        /*private TextView mTextViewResult;
   */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        recyclerJson = findViewById(R.id.recyclerJson);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerJson.setLayoutManager(linearLayoutManager);

        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("yoga");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject userData = jsonArray.getJSONObject(i);
                id.add(userData.getString("id"));
                headline.add(userData.getString("headline"));
                context.add(userData.getString("context"));
                content.add(userData.getString("content"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonAdapter jsonAdapter = new jsonAdapter(id, headline, context, content, ThirdActivity.this);
        recyclerJson.setAdapter(jsonAdapter);
    }


    private String JsonDataFromAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("yoga.json");
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
