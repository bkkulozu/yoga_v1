package com.example.yogafitclass;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Adapter.featuresListAdapter;
import Models.featuresListModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // recyclerYoga.hasFixedSize();

        // Hiding title bar using code
        getSupportActionBar().hide();

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        featuresListModel[] featuresListModels = new featuresListModel[]{
                new featuresListModel("Posture 1: Baby cobra", R.drawable.babycobra),
                new featuresListModel("Posture 2: Cat", R.drawable.cat),
                new featuresListModel("Posture 3: Chair", R.drawable.chair),
                new featuresListModel("Posture 4: Child", R.drawable.child),
                new featuresListModel("Posture 5: Corpse", R.drawable.corpse),
                new featuresListModel("Posture 6: Cow", R.drawable.cow),
                new featuresListModel("Posture 7: Downward", R.drawable.downward),
                new featuresListModel("Posture 8: Easy Seat", R.drawable.easyseat),
                new featuresListModel("Posture 9: Half Seated", R.drawable.halfseated),
                new featuresListModel("Posture 10: Half standing fold", R.drawable.halfstandingfold),
                new featuresListModel("Posture 11: Hero", R.drawable.hero),
                new featuresListModel("Posture 12: High lunge", R.drawable.highlunge),
                new featuresListModel("Posture 13: Locusi", R.drawable.locusi),
                new featuresListModel("Posture 14: Low lunge", R.drawable.lowlunge),
                new featuresListModel("Posture 15: Mountain ", R.drawable.mountain),
                new featuresListModel("Posture 16: Plank", R.drawable.plank),
                new featuresListModel("Posture 17: Tree", R.drawable.tree),
                new featuresListModel("Posture 18: Triangle", R.drawable.triangle),
                new featuresListModel("Posture 19: Warrior", R.drawable.warrior1),
                new featuresListModel("Posture 20: Warrior 2", R.drawable.warrior2)


        };

        RecyclerView recyclerView = findViewById(R.id.recyclerYoga);
        featuresListAdapter adapter = new featuresListAdapter(featuresListModels, this);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
    public void onClick(View view) {
        intent = new Intent(this, ThirdActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);
    }

    public void openCountdownActivity(String posename, int logoid){
        intent = new Intent(this, CountDownActivity.class);
        Bundle nBundle = new Bundle();
        nBundle.putString("posename",posename);
        nBundle.putInt("logoid", logoid);
        intent.putExtras(nBundle);
        startActivity(intent);

    }


}

/*
    public void onClick(View view) {
        intent = new Intent(this, ThirdActivity.class);
        //  intent.putExtras(b);
        startActivity(intent);

    }
*/
    /*
public void onItemClick(View view) {
    intent = new Intent(this, ThirdActivity.class);
    Bundle bundle = new Bundle();
   // bundle.putString("name" , name);
    intent.putExtras(bundle);
    startActivity(intent);

}*/


        // recyclerYoga.hasFixedSize();









