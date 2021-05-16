package com.example.kulozubeste;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/**
 *  Beste Kulozu 214 00 474
 */
public class ExerciseActivity extends AppCompatActivity {

    Button btnGoster;
    final Context context = this;

    Intent mIntent;
    int currentUser;

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.babycobra,  R.drawable.cat, R.drawable.chair, R.drawable.child,
    R.drawable.corpse, R.drawable.cow, R.drawable.downward, R.drawable.easyseat,
            R.drawable.halfseated, R.drawable.halfstandingfold, R.drawable.hero, R.drawable.highlunge,
    R.drawable.locusi, R.drawable.lowlunge, R.drawable.mountain, R.drawable.plank, R.drawable.tree,
    R.drawable.triangle, R.drawable.warrior1, R.drawable.warrior2};


    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnGoster = (Button) findViewById(R.id.button_show_dialog);
        btnGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyCustomAlertDialog();
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(images);
        recyclerView.setAdapter(adapter);

        mIntent = getIntent();
        Bundle mBundle = mIntent.getExtras();

    }

    public void showMyCustomAlertDialog() {
        // dialog object and layout
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);

        // custom dialog
        Button btnKaydet = (Button) dialog.findViewById(R.id.button_kaydet);
        Button btnIptal = (Button) dialog.findViewById(R.id.button_iptal);


        // got it button
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "BACK!!", Toast.LENGTH_SHORT).show();
            }
        });
        // cancel or back
        btnIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
